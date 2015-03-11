package org.eclipse.gmf.runtime.gwt.edit.parts;

import static org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain.getEditingDomainFor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.gwt.commands.AbstractWrappingCommand;
import org.eclipse.gmf.runtime.gwt.commands.CreateNotationalElementCommand;
import org.eclipse.gmf.runtime.gwt.commands.RemoveNotationalElementCommand;
import org.eclipse.gmf.runtime.gwt.commands.ReplaceNotationalElementCommand;
import org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.ElementDescriptor;
import org.eclipse.gmf.runtime.notation.View;

public abstract class ChildNotationModelRefresher implements EditPartRefresher {

	private final AbstractGraphicalEditPart editPart;

	public ChildNotationModelRefresher(AbstractGraphicalEditPart editPart) {
		this.editPart = editPart;
	}

	protected abstract CreateNotationalElementCommand getCreateNotationalElementCommand(ElementDescriptor descriptor);

	protected Command getRefreshExternalElementCommand(View externalView) {
		return null;
	}

	protected abstract List<ElementDescriptor> getSemanticChildNodes();

	protected abstract boolean shouldCreateView(ElementDescriptor descriptor);

	protected boolean shouldRemoveView(View view) {
		return true;
	}

	protected Command buildCommand() {
		List<ElementDescriptor> semanticChildren = getSemanticChildNodes();
		@SuppressWarnings("unchecked")
		List<View> notationalChildren = (List<View>) getHost().getChildren();

		if (semanticChildren.isEmpty() && notationalChildren.isEmpty()) {
			return null;
		}

		final Map<EObject, View> semanticToNotational = new HashMap<EObject, View>();
		for(Iterator<View> it = notationalChildren.iterator(); it.hasNext(); ) {
			View next = it.next();
			if (next.isSetElement()) {
				EObject nextSemantic = next.getElement();
				if (nextSemantic != null) {
					semanticToNotational.put(nextSemantic, next);
				}
			}
		}
		CompoundCommand command = new CompoundCommand();
		for(Iterator<ElementDescriptor> it = semanticChildren.iterator(); it.hasNext(); ) {
			ElementDescriptor next = it.next();
			EObject node = next.getElement();
			View currentView = semanticToNotational.remove(node);
			int nodeVisualID = next.getVisualID();
			if (currentView == null) {
				if (shouldCreateView(next)) {
					command.appendIfCanExecute(getCreateNotationalElementCommand(next));
				}
			} else if (nodeVisualID != getVisualID(currentView)) {
				CreateNotationalElementCommand notationalCommand = getCreateNotationalElementCommand(next);
				if (notationalCommand != null) {
					command.appendIfCanExecute(new ReplaceNotationalElementCommand(getHost(), notationalCommand, currentView));
				} else {
					command.appendIfCanExecute(new RemoveNotationalElementCommand(getHost(), currentView));
				}
			}
		}
		for(Iterator<View> it = semanticToNotational.values().iterator(); it.hasNext(); ) {
			View obsoleteView = it.next();
			if (shouldRemoveView(obsoleteView)) {
				command.appendIfCanExecute(new RemoveNotationalElementCommand(getHost(), obsoleteView));
			} else {
				command.appendIfCanExecute(getRefreshExternalElementCommand(obsoleteView));
			}
		}
		return command.getCommandList().isEmpty() ? null : command;
	}
	
	@Override
	public void refresh() {
		final View host = getHost();
		if (host == null) {
			return;
		}
		final Command command = buildCommand();
		if (command == null) {
			return;
		}
		final AbstractWrappingCommand gefCommand = new AbstractWrappingCommand(getEditingDomainFor(host)) {
			@Override
			protected Command getOperation() {
				return command;
			}
		};
		editPart.getViewer().getEditDomain().getCommandStack().execute(gefCommand);
	}

	public View getHost() {
		return (View) editPart.getModel();
	}

	protected int getVisualID(View view) {
		try {
			return Integer.parseInt(view.getType());
		} catch (NumberFormatException e) {
			return -1;
		}
	}

}
