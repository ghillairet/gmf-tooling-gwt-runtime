package org.eclipse.gmf.runtime.gwt.edit.parts;

import static org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain.getEditingDomainFor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.gwt.commands.AbstractWrappingCommand;
import org.eclipse.gmf.runtime.gwt.commands.CreateNotationalElementCommand;
import org.eclipse.gmf.runtime.gwt.commands.ReconnectNotationalEdgeSourceCommand;
import org.eclipse.gmf.runtime.gwt.commands.ReconnectNotationalEdgeTargetCommand;
import org.eclipse.gmf.runtime.gwt.commands.RemoveNotationalEdgeCommand;
import org.eclipse.gmf.runtime.gwt.commands.ReplaceNotationalElementCommand;
import org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.ElementDescriptor;
import org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.IViewService;
import org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.LinkDescriptor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

public abstract class OwnedLinksNotationModelRefresher implements EditPartRefresher {

	private AbstractGraphicalEditPart editPart;
	private IViewService service;

	public OwnedLinksNotationModelRefresher(AbstractGraphicalEditPart editPart, IViewService service) {
		this.editPart = editPart;
		this.service = service;
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Command buildCommand() {
		List/*<LinkDescriptor>*/ semanticChildLinks = getSemanticChildLinks();
		List/*<Edge>*/ notationalChildLinks = getNotationalChildLinks();
		if (semanticChildLinks.isEmpty() && notationalChildLinks.isEmpty()) {
			return null;
		}
		final Map semanticToNotationalTypeBasedLinks = new HashMap();
		final Map/*<EObject, List<Edge>>*/ semanticToNotationalFeatureBasedLinks = new HashMap();
		for(Iterator it = notationalChildLinks.iterator(); it.hasNext(); ) {
			Edge next = (Edge) it.next();
			EObject nextSemantic = next.getElement();
			if (nextSemantic != null) {
				semanticToNotationalTypeBasedLinks.put(nextSemantic, next);
			} else {
				List featureBasedLinksForSource = (List) semanticToNotationalFeatureBasedLinks.get(next.getSource().getElement());
				if (featureBasedLinksForSource == null) {
					featureBasedLinksForSource = new LinkedList();
					semanticToNotationalFeatureBasedLinks.put(next.getSource().getElement(), featureBasedLinksForSource);
				}
				featureBasedLinksForSource.add(next);
			}
		}
		Diagram parentView = getHost().getDiagram();
		CompoundCommand command = new CompoundCommand();
		for(Iterator it = semanticChildLinks.iterator(); it.hasNext(); ) {
			LinkDescriptor next = (LinkDescriptor) it.next();
			EObject nextLinkElement = next.getElement();
			Edge currentEdge;
			if (nextLinkElement != null) {
				currentEdge = (Edge) semanticToNotationalTypeBasedLinks.remove(nextLinkElement);
			} else {
				List featureBasedLinksForSource = (List) semanticToNotationalFeatureBasedLinks.get(next.getSource());
				if (featureBasedLinksForSource == null || featureBasedLinksForSource.isEmpty()) {
					currentEdge = null;
				} else {
					currentEdge = (Edge) featureBasedLinksForSource.remove(0);
				}
			}
			int linkVisualID = next.getVisualID();
			if (currentEdge == null) {
				if (nextLinkElement == null || shouldCreateView(next)) {
					command.appendIfCanExecute(getCreateNotationalElementCommand(next));
				}
			} else {
				boolean changedSource = currentEdge.getSource().getElement() != next.getSource();
				boolean changedTarget = currentEdge.getTarget().getElement() != next.getDestination();
				boolean changedVID = linkVisualID != getVisualID(currentEdge);
				if (!changedSource && !changedTarget) {
					if (changedVID) {
						CreateNotationalElementCommand notationalCommand = getCreateNotationalElementCommand(next);
						if (notationalCommand != null) {
							command.appendIfCanExecute(new ReplaceNotationalElementCommand(parentView, notationalCommand, currentEdge));
						} else {
							command.appendIfCanExecute(new RemoveNotationalEdgeCommand(parentView, currentEdge));
						}
					}
				} else {
					if (changedVID) {
						command.appendIfCanExecute(new RemoveNotationalEdgeCommand(parentView, currentEdge));
						command.appendIfCanExecute(getCreateNotationalElementCommand(next));
					} else {
						View newSourceView = service.findView(next.getSource());
						if (changedSource) {
							if (newSourceView != null && isValidLinkSource(newSourceView, next)) { 
								command.appendIfCanExecute(new ReconnectNotationalEdgeSourceCommand(currentEdge, newSourceView));
							} else {
								command.appendIfCanExecute(new RemoveNotationalEdgeCommand(currentEdge.getDiagram(), currentEdge));
							}
						}
						View newTargetView = service.findView(next.getDestination());
						if (changedTarget) {
							if (newTargetView != null && isValidLinkTarget(newTargetView, next)) {
								command.appendIfCanExecute(new ReconnectNotationalEdgeTargetCommand(currentEdge, newTargetView));
							} else {
								command.appendIfCanExecute(new RemoveNotationalEdgeCommand(currentEdge.getDiagram(), currentEdge));
							}
						}
					}
				}
			}
		}
		for(Iterator it = semanticToNotationalTypeBasedLinks.values().iterator(); it.hasNext(); ) {
			View obsoleteView = (View) it.next();
			command.appendIfCanExecute(new RemoveNotationalEdgeCommand(parentView, obsoleteView));
		}
		for(Iterator it = semanticToNotationalFeatureBasedLinks.values().iterator(); it.hasNext(); ) {
			List obsoleteViews = (List) it.next();
			for(Iterator obsoleteViewsIt = obsoleteViews.iterator(); obsoleteViewsIt.hasNext(); ) {
				View obsoleteView = (View) obsoleteViewsIt.next();
				command.appendIfCanExecute(new RemoveNotationalEdgeCommand(parentView, obsoleteView));
			}
		}
		return command.getCommandList().isEmpty() ? null : command;
	}

	public View getHost() {
		return (View) editPart.getModel();
	}

	protected abstract List<?> getNotationalChildLinks();

	protected abstract List<?> getSemanticChildLinks();

	/**
	 * Returns whether the given view can be source of the given link. 
	 */
	protected boolean isValidLinkSource(View sourceCandidate, LinkDescriptor linkDescriptor) {
		return true;
	}

	/**
	 * Returns whether the given view can be source of the given link. 
	 */
	protected boolean isValidLinkTarget(View targetCandidate, LinkDescriptor linkDescriptor) {
		return true;
	}

	protected abstract CreateNotationalElementCommand getCreateNotationalElementCommand(ElementDescriptor descriptor);

	protected abstract boolean shouldCreateView(ElementDescriptor descriptor);

	protected int getVisualID(View view) {
		try {
			return Integer.parseInt(view.getType());
		} catch (NumberFormatException e) {
			return -1;
		}
	}

}
