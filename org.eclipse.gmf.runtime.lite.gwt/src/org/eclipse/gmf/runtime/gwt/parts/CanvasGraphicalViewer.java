package org.eclipse.gmf.runtime.gwt.parts;

import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.gef.ui.parts.GraphicalViewerImpl;
import org.eclipse.swt.widgets.Control;

import com.google.gwt.canvas.client.Canvas;

public class CanvasGraphicalViewer extends GraphicalViewerImpl {
	
	private final Canvas gwtCanvas;

	public CanvasGraphicalViewer(Canvas canvas) {
		super();
		this.gwtCanvas = canvas;
		super.setControl(new org.eclipse.swt.widgets.Canvas(gwtCanvas));
	}

	@Override
	protected LightweightSystem createLightweightSystem() {
		return new LightweightSystem();
	}

	@Override
	public void setControl(Control control) {}

	public Canvas getCanvas() {
		return gwtCanvas;
	}

}