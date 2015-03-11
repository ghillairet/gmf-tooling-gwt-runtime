package org.eclipse.gmf.runtime.gwt.commands;

import com.google.gwt.core.client.Callback;

public interface AsyncCommand<T, F> {

	void execute(Callback<T, F> callback);

}
