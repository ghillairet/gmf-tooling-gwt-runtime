package org.eclipse.gmf.runtime.gwt.commands;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.Callback;
import org.eclipse.emf.edit.domain.EditingDomain;

public class AsyncWrappingCommand extends WrappingCommand {

	public AsyncWrappingCommand(EditingDomain editingDomain, Command command) {
		super(editingDomain, command);
	}

	private Callback<Collection<?>> callback;

	@Override
	protected Command getOperation() {
		return null;
	}

	public void setCallback(Callback<Collection<?>> callback) {
		this.callback = callback;
	}

	public Callback<Collection<?>> getCallback() {
		return callback;
	}

	@Override
	public void execute() {
		
		super.execute();
	}
}
