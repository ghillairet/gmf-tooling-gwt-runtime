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

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.commands.Command;

/**
 * Abstract command that wraps a EMF command and is a GEF command.
 */
public abstract class AbstractWrappingCommand extends Command {

	private final EditingDomain myEditingDomain;

	public AbstractWrappingCommand(EditingDomain editingDomain) {
		myEditingDomain = editingDomain;
	}

	public void execute() {
		getOperation().execute();
	}

	public boolean canExecute() {
		return getOperation().canExecute();
	}

	public void undo() {
		getOperation().undo();
	}

	public boolean canUndo() {
		return getOperation().canUndo();
	}

	public void redo() {
		getOperation().redo();
	}

	@Override
	public void dispose() {
		getOperation().dispose();
		super.dispose();
	}

	protected final EditingDomain getEditingDomain() {
		return myEditingDomain;
	}

	protected abstract org.eclipse.emf.common.command.Command getOperation();
}
