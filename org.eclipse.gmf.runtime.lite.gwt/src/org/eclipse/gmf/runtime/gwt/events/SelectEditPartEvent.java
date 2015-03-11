package org.eclipse.gmf.runtime.gwt.events;

import org.eclipse.gmf.runtime.gwt.edit.parts.BaseNodeEditPart;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class SelectEditPartEvent extends GwtEvent<SelectEditPartEvent.SelectEditPartEventHandler> {

	public static final Type<SelectEditPartEventHandler> TYPE = new Type<SelectEditPartEventHandler>();

	public final BaseNodeEditPart part;

	public SelectEditPartEvent(BaseNodeEditPart part) {
		this.part = part;
	}

	@Override
	public Type<SelectEditPartEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(SelectEditPartEventHandler handler) {
		handler.onSelect(this);
	}

	public interface SelectEditPartEventHandler extends EventHandler {
		void onSelect(SelectEditPartEvent event);
	}

}
