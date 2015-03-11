package org.eclipse.gmf.runtime.gwt.commands;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;

public class WrappingCommand extends AbstractWrappingCommand {

	private final Command command;

	public WrappingCommand(EditingDomain editingDomain, Command command) {
		super(editingDomain);
		this.command = command;
	}

	@Override
	protected Command getOperation() {
		return command;
	}
	
}
