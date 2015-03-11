package org.eclipse.gmf.runtime.gwt.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Control;

public abstract class BaseNodeEditPart 
extends AbstractGraphicalEditPart
implements NodeEditPart {

	/**
	 * The font descriptor (created by {@link #refreshFont()}) currently assigned to the label (unless the default font is assigned).
	 * Whenever another non-default font is assigned to it, the previous one should be destroyed through the resource manager.
	 */
	protected FontDescriptor createdFontDescriptor;

	/**
	 * The color descriptor (created by {@link #refreshBackgroundColor()}) currently assigned to the figure.
	 * Whenever another color is assigned to it, the previous one should be destroyed through the resource manager.
	 */
	private ColorDescriptor createdBackgroundColorDescriptor;

	private final NodeEditPartAdapter adapter = new NodeEditPartAdapter(this) {
		@Override
		public void refreshVisibility() {
			BaseNodeEditPart.this.refreshVisibility();
		}
		@Override
		public void refreshTargetConnections() {
			BaseNodeEditPart.this.refreshTargetConnections();
		}
		@Override
		public void refreshSourceConnections() {
			BaseNodeEditPart.this.refreshSourceConnections();
		}
		@Override
		public void refreshFont() {
			BaseNodeEditPart.this.refreshFont();
		}
		@Override
		public void refreshChildren() {
			BaseNodeEditPart.this.refreshChildren();
		}
		@Override
		public void refreshBounds() {
			BaseNodeEditPart.this.refreshBounds();
		}
		@Override
		public void refreshBendpoints() {}
		@Override
		public void refreshBackgroundColor() {
			BaseNodeEditPart.this.refreshBackgroundColor();
		};
	};

	private final List<EObject> notifiers = new ArrayList<EObject>();

	@SuppressWarnings("unchecked")
	@Override
	protected void registerModel() {
		super.registerModel();
		View view = (View) getModel();
		if (view != null && view.isSetElement() && view.getElement() != null) {
			getViewer().getEditPartRegistry().put(view.getElement(), this);
		}
	}

	@Override
	protected void unregisterModel() {
		super.unregisterModel();
		View view = (View) getModel();
		if (view != null
				&& view.isSetElement()
				&& view.getElement() != null
				&& getViewer().getEditPartRegistry().get(view.getElement()) == this) {
			getViewer().getEditPartRegistry().remove(view.getElement());
		}
	}

	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	protected boolean addFixedChild(EditPart childEditPart) { 
		return false;
	};

	protected boolean removeFixedChild(EditPart childEditPart) { 
		return false;
	};

	@SuppressWarnings("unchecked")
	protected List<View> getModelChildren() {
		return getDiagramNode().getVisibleChildren();
	}

	@SuppressWarnings("unchecked")
	protected List<Edge> getModelSourceConnections() {
		return getDiagramNode().getSourceEdges();
	}

	@SuppressWarnings("unchecked")
	protected List<Edge> getModelTargetConnections() {
		return getDiagramNode().getTargetEdges();
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		return new ChopboxAnchor(getFigure());
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		return new ChopboxAnchor(getFigure());
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return new ChopboxAnchor(getFigure());
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return new ChopboxAnchor(getFigure());
	}

	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshVisibility();
		refreshBounds();
		refreshFont();
//		refreshBackgroundColor();
	}

	protected void refreshBounds() {
		Node node = getDiagramNode();
		if (node.getLayoutConstraint() == null) {
			return;
		}
		assert node.getLayoutConstraint() instanceof Bounds;

		Bounds bounds = (Bounds) node.getLayoutConstraint();
		int x = bounds.getX();
		int y = bounds.getY();
		int width = bounds.getWidth();
		int height = bounds.getHeight();
		if (width < 0) {
			x -= width;
			width = -width;
		}
		if (height < 0) {
			y -= height;
			height = -height;
		}

		((GraphicalEditPart) getParent()).setLayoutConstraint(this, 
				getFigure(), 
				new Rectangle(x, y, width, height));
	}
	
	protected void refreshVisibility() {
		boolean isVisible = getDiagramNode().isVisible();
		boolean wasVisible = getFigure().isVisible();
		if (isVisible == wasVisible) {
			return;
		}
		if (!isVisible && (getSelected() != SELECTED_NONE)) {
			getViewer().deselect(this);
		}
		getFigure().setVisible(isVisible);
		getFigure().revalidate();
	}
	
	protected void refreshFont() {
		FontStyle style = null;
		try {
			style = (FontStyle) getDiagramNode().getStyle(NotationPackage.eINSTANCE.getFontStyle());
		} catch (Exception e) {}

		FontDescriptor toDispose = createdFontDescriptor;
		
		if (style != null) {
			String fontName = style.getFontName();
			if (fontName != null) {
				Control control = getViewer() != null ? getViewer().getControl() : null;
				FontData[] matchingDatas = control != null ? control.getDisplay().getFontList(fontName, true) : null;
				if (matchingDatas == null || matchingDatas.length == 0) {
					fontName = null;
				}
			}
			int fontHeight = style.getFontHeight();
			if (fontName == null || fontHeight <= 0) {
				FontData defaultFont = new FontData();
				if (fontName == null) {
					fontName = defaultFont.getName();
				}
				if (fontHeight <= 0) {
					fontHeight = defaultFont.getHeight();
				}
			}
			int fontStyle = SWT.NORMAL;
			if (style.isBold()) {
				fontStyle |= SWT.BOLD;
			}
			if (style.isItalic()) {
				fontStyle |= SWT.ITALIC;
			}

			Font currentFont = getFigure().getFont();
			if (currentFont != null) {
				FontData currentFontData = currentFont.getFontData()[0];
				if (currentFontData.getName().equals(fontName) && 
						currentFontData.getHeight() == fontHeight && 
						currentFontData.getStyle() == fontStyle) {
					return;
				}
			}
			createdFontDescriptor = FontDescriptor.createFrom(fontName, fontHeight, fontStyle);
			getFigure().setFont(getViewer().getResourceManager().createFont(createdFontDescriptor));
		} else {
			//revert to the default font
			if (getViewer().getControl() != null) {
				getFigure().setFont(getViewer().getControl().getFont());
			}
			createdFontDescriptor = null;
		}

		if (toDispose != null) {
			getViewer().getResourceManager().destroyFont(toDispose);
		}
	}

	protected void refreshBackgroundColor() {
		FillStyle style = null;
		try {
			style = (FillStyle) getDiagramNode().getStyle(NotationPackage.eINSTANCE.getFillStyle());
		} catch (Exception e) {

		}

		ColorDescriptor toDispose = createdBackgroundColorDescriptor;
		int r, g, b; 

		if (style != null) {
			int backgroundColor = style.getFillColor();
			r = backgroundColor & 0x000000FF;
			g = (backgroundColor & 0x0000FF00) >> 8;
			b = (backgroundColor & 0x00FF0000) >> 16;
			Color currentColor = getFigure().getBackgroundColor();

			if (currentColor != null && 
					currentColor.getRed() == r  && 
					currentColor.getGreen() == g && 
					currentColor.getBlue() == b) {
				return;
			}
			createdBackgroundColorDescriptor = 
				ColorDescriptor.createFrom(new org.eclipse.swt.graphics.RGB(r, g, b));
		} else {
			createdBackgroundColorDescriptor = 
					ColorDescriptor.createFrom(new org.eclipse.swt.graphics.RGB(100, 100, 100));
		}

		getFigure().setBackgroundColor(getViewer().getResourceManager().createColor(createdBackgroundColorDescriptor));
//		getFigure().setBackgroundColor(new Color(null, r, g, b));
//		getFigure().repaint();
//		getViewer().flush();

		if (toDispose != null) {
			getViewer().getResourceManager().destroyColor(toDispose);
		}
	}

	@Override
	public void activate() {
		super.activate();
		addNotifier(getDiagramNode());
		addNotifier(getDiagramNode().getLayoutConstraint());
	}
	
	@Override
	public void deactivate() {
		for (EObject o: notifiers) 
			removeNotifier(o);
		notifiers.clear();
		super.deactivate();
	}

	public void installRefresher(EditPartRefresher refresher) {
		adapter.addRefresher(refresher);
	}
	
	public void uninstallRefresher(EditPartRefresher refresher) {
		adapter.removeRefresher(refresher);
	}

	public void addNotifier(EObject notifier) {
		if (notifier != null && !this.notifiers.contains(notifier)) {
			this.notifiers.add(notifier);
			notifier.eAdapters().add(adapter);
		}
	}

	public void removeNotifier(EObject notifier) {
		if (this.notifiers.contains(notifier)) {
			notifier.eAdapters().remove(adapter);
		}
	}

	public Node getDiagramNode() {
		return (Node) getModel();
	}

}
