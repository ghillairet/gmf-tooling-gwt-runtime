package org.eclipse.gmf.runtime.gwt.tools;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.tools.CreationTool;
import org.eclipse.gmf.runtime.gwt.requests.ModelCreationFactory;
import org.eclipse.gmf.runtime.gwt.requests.RequestConstants;
import org.eclipse.gmf.runtime.notation.Node;

public abstract class NodeTool extends CreationTool {

	public NodeTool() {
		setFactory(new ModelCreationFactory(Node.class));
	}

	@Override
	protected abstract Request createTargetRequest();

	@Override
	protected void performCreation(int button) {
		super.performCreation(button);
		final EditPart createdEditPart = (EditPart) getCurrentViewer()
				.getEditPartRegistry()
				.get(getCreateRequest().getNewObject());

		if (createdEditPart != null) {
			if (createdEditPart.isActive()) {
				createdEditPart.performRequest(new Request(RequestConstants.REQ_DIRECT_EDIT));
			}
		}
	}

}
