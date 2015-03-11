package org.eclipse.gmf.runtime.gwt.edit.parts;

import org.eclipse.emf.common.notify.Notification;

public interface EditPartRefresher {

	public boolean shouldRefresh(Notification notification);

	public void refresh();

}
