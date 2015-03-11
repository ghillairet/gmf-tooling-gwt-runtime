package org.eclipse.gmf.runtime.gwt.events;

import org.eclipse.gmf.runtime.gwt.edit.parts.BaseNodeEditPart;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class DeselectEditPartEvent extends GwtEvent<DeselectEditPartEvent.DeselectEditPartEventHandler> {

	public static final Type<DeselectEditPartEventHandler> TYPE = new Type<DeselectEditPartEventHandler>();

	public final BaseNodeEditPart part;

	public DeselectEditPartEvent(BaseNodeEditPart part) {
		this.part = part;
	}

	@Override
	public Type<DeselectEditPartEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(DeselectEditPartEventHandler handler) {
		handler.onDeselect(this);
	}

	public interface DeselectEditPartEventHandler extends EventHandler {
		void onDeselect(DeselectEditPartEvent event);
	}

}
