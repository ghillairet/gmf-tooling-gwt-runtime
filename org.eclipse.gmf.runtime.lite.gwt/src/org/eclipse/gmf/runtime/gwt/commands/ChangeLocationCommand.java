/**
 * Copyright (c) 2007 Borland Software Corporation
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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;

public class ChangeLocationCommand extends AbstractCommand {
	private final Node myNode;
	private final ChangeBoundsRequest myRequest;
	private final IFigure myReferenceFigure;

	private Point myMoveDelta;

	public ChangeLocationCommand(Node node, ChangeBoundsRequest request, IFigure figure) {
		super("Change node position/size");
		myNode = node;
		myRequest = request;
		myReferenceFigure = figure;
	}

	public boolean canUndo() {
		return canExecute();
	}

	protected boolean prepare() {
		if (myNode.getLayoutConstraint() instanceof Location == false) {
			return false;
		}
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(myNode);
		if (domain != null && domain.isReadOnly(myNode.eResource())) {
			return false;
		}
		Location location = (Location) myNode.getLayoutConstraint();
		Rectangle original = new Rectangle(location.getX(), location.getY(), 0, 0);
		myReferenceFigure.translateToAbsolute(original);
		Rectangle transformed = myRequest.getTransformedRectangle(original);
		myReferenceFigure.translateToRelative(transformed);
		myReferenceFigure.translateToRelative(original);
		myMoveDelta = transformed.getTopLeft().translate(original.getTopLeft().negate());
		return true;
	}

	public void undo() {
		execute(myMoveDelta.getNegated());
	}

	public void execute() {
		execute(myMoveDelta);
	}

	public void redo() {
		execute();
	}

	private void execute(Point move) {
		Location location = (Location) myNode.getLayoutConstraint();
		location.setX(location.getX() + move.x);
		location.setY(location.getY() + move.y);
	}
}
