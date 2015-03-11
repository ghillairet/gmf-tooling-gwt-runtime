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

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.commands.Command;

/**
 * GEF Command that wraps an unlimited number of EMF Commands that should be executed 
 * in a context of one transaction.
 */
public class CompositeWrappingCommand extends AbstractWrappingCommand {

	private final CompoundCommand myOperation;

	public CompositeWrappingCommand(EditingDomain domain, String label) {
		super(domain);
		myOperation = new CompoundCommand();
	}

	public void add(org.eclipse.emf.common.command.Command command) {
		myOperation.append(command);
	}

	/**
	 * Adds a GEF command. If the command is a wrapper command for an EMF command, it will be executed in
	 * the same transaction context.
	 */
	public void add(final Command command) {
		if (command instanceof AbstractWrappingCommand) {
			AbstractWrappingCommand wrappingCommand = (AbstractWrappingCommand) command;
			myOperation.append(wrappingCommand.getOperation());
		} else {
			myOperation.append(new org.eclipse.emf.common.command.AbstractCommand() {
				@Override
				public void execute() {
					command.execute();
				}
				@Override
				public void redo() {
					command.redo();
				}
			});
		}
	}

	@Override
	protected CompoundCommand getOperation() {
		return myOperation;
	}
}
