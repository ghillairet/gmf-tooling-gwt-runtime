/**
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    bblajer - initial API and implementation
 */
package org.eclipse.gmf.runtime.gwt.commands;

import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

public class RemoveNotationalEdgeCommand extends RemoveNotationalElementCommand {
	private View source;
	private View target;

	public RemoveNotationalEdgeCommand(View parentView, View childView) {
		super(parentView, childView);
	}

	protected boolean prepare() {
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(getParent());
		if (domain != null && domain.isReadOnly(getParent().eResource())) {
			return false;
		}
		return getParent() instanceof Diagram && getChildView() instanceof Edge
			&& ((Diagram) getParent()).getEdges().contains(getChildView());
	}

	public void execute() {
		Edge edgeToRemove = (Edge) getChildView();
		source = edgeToRemove.getSource();
		target = edgeToRemove.getTarget();
		edgeToRemove.setSource(null);
		edgeToRemove.setTarget(null);
		((Diagram) getParent()).removeEdge(edgeToRemove);
		sweepElement();
	}

	public void undo() {
		restoreElement();
		Edge edge = (Edge) getChildView();
		((Diagram) getParent()).insertEdge(edge);
		edge.setSource(source);
		edge.setTarget(target);
	}
}
