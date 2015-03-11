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

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

public class ReconnectNotationalEdgeTargetCommand extends AbstractCommand {
	private final Edge edge;
	private final View newTarget;
	private View oldTarget;

	public ReconnectNotationalEdgeTargetCommand(Edge edge, View newTarget) {
		this.edge = edge;
		this.newTarget = newTarget;
	}

	protected boolean prepare() {
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(edge);
		if (domain != null && domain.isReadOnly(edge.eResource())) {
			return false;
		}
		return newTarget != null;
	}

	public boolean canUndo() {
		return oldTarget != null;
	}

	public void execute() {
		oldTarget = edge.getTarget();
		edge.setTarget(newTarget);
	}

	public void redo() {
		execute();
	}

	public void undo() {
		edge.setTarget(oldTarget);
		oldTarget = null;
	}
}
