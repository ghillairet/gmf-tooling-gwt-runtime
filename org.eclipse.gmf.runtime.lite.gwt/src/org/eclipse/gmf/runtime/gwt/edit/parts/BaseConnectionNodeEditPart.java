package org.eclipse.gmf.runtime.gwt.edit.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gmf.runtime.gwt.edit.parts.decorations.IDecoratableEditPart;
import org.eclipse.gmf.runtime.gwt.edit.parts.decorations.IDecorationManager;
import org.eclipse.gmf.runtime.gwt.edit.policies.BendpointEditPolicy;
import org.eclipse.gmf.runtime.gwt.edit.policies.DelegatingDirectEditPolicy;
import org.eclipse.gmf.runtime.gwt.figures.ConnectionConnectionAnchor;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.swt.graphics.Color;

public class BaseConnectionNodeEditPart extends AbstractConnectionEditPart 
implements IDecoratableEditPart, NodeEditPart {

	/**
	 * The color descriptor (created by {@link #refreshBackgroundColor()}) currently assigned to the figure.
	 * Whenever another color is assigned to it, the previous one should be destroyed through the resource manager.
	 */
	private ColorDescriptor createdBackgroundColorDescriptor;

	private final NodeEditPartAdapter adapter = new NodeEditPartAdapter(this) {
		@Override
		public void refreshVisibility() {
			BaseConnectionNodeEditPart.this.refreshVisibility();			
		}
		@Override
		public void refreshTargetConnections() {
			BaseConnectionNodeEditPart.this.refreshTargetConnections();
		}
		@Override
		public void refreshSourceConnections() {
			BaseConnectionNodeEditPart.this.refreshSourceConnections();
		}
		@Override
		public void refreshFont() {}
		@Override
		public void refreshChildren() {
			BaseConnectionNodeEditPart.this.refreshChildren();	
		}
		@Override
		public void refreshBounds() {}
		@Override
		public void refreshBendpoints() {
			BaseConnectionNodeEditPart.this.refreshBendpoints();
		}
		@Override
		public void refreshBackgroundColor() {
			BaseConnectionNodeEditPart.this.refreshBackgroundColor();
		}
	};

	private final List<EObject> notifiers = new ArrayList<EObject>();

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		return new ConnectionConnectionAnchor(getConnectionFigure());
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		return new ConnectionConnectionAnchor(getConnectionFigure());
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return new ConnectionConnectionAnchor(getConnectionFigure());
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return new ConnectionConnectionAnchor(getConnectionFigure());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<View> getModelChildren() {
		return (List<View>) getDiagramEdge().getVisibleChildren();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<Edge> getModelSourceConnections() {
		return (List<Edge>) getDiagramEdge().getSourceEdges();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<Edge> getModelTargetConnections() {
		return (List<Edge>) getDiagramEdge().getTargetEdges();
	}

	@Override
	public IDecorationManager getDecorationManager() {
		return null;
	}

	protected void refreshVisibility() {
		boolean isVisible = getDiagramEdge().isVisible();
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void refreshBendpoints() {
		RelativeBendpoints bendpoints = (RelativeBendpoints) getDiagramEdge().getBendpoints();
		if (bendpoints == null) {
			getConnectionFigure().setRoutingConstraint(Collections.EMPTY_LIST);
			return;
		}

		List modelConstraint = bendpoints.getPoints();
		List figureConstraint = new ArrayList();

		for (int i = 0; i < modelConstraint.size(); i++) {
			RelativeBendpoint wbp = (RelativeBendpoint) modelConstraint.get(i);
			org.eclipse.draw2d.RelativeBendpoint rbp = new org.eclipse.draw2d.RelativeBendpoint(getConnectionFigure());
			rbp.setRelativeDimensions(
					new Dimension(wbp.getSourceX(), wbp.getSourceY()),
					new Dimension(wbp.getTargetX(), wbp.getTargetY()));
			rbp.setWeight((i + 1) / ((float) modelConstraint.size() + 1));
			figureConstraint.add(rbp);
		}

		getConnectionFigure().setRoutingConstraint(figureConstraint);
	}

	protected void refreshBackgroundColor() {
		FillStyle style = null;
		try {
			style = (FillStyle) getDiagramEdge().getStyle(NotationPackage.eINSTANCE.getFillStyle());
		} catch (Exception e) {

		}

		ColorDescriptor toDispose = createdBackgroundColorDescriptor;

		if (style != null) {
			int backgroundColor = style.getFillColor();
			int red = backgroundColor & 0x000000FF;
			int green = (backgroundColor & 0x0000FF00) >> 8;
			int blue = (backgroundColor & 0x00FF0000) >> 16;
			Color currentColor = getFigure().getBackgroundColor();

			if (currentColor != null && currentColor.getRed() == red  && currentColor.getGreen() == green && currentColor.getBlue() == blue) {
				return;
			}
			createdBackgroundColorDescriptor = 
				ColorDescriptor.createFrom(new org.eclipse.swt.graphics.RGB(red, green, blue));
		} else {
			createdBackgroundColorDescriptor = 
					ColorDescriptor.createFrom(new org.eclipse.swt.graphics.RGB(100, 100, 100));
		}

		getFigure().setBackgroundColor(getViewer().getResourceManager().createColor(createdBackgroundColorDescriptor));

		if (toDispose != null) {
			getViewer().getResourceManager().destroyColor(toDispose);
		}
	}

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

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE, new BendpointEditPolicy());
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new DelegatingDirectEditPolicy());
	}

	@Override
	public void activate() {
		super.activate();
		addNotifier(getDiagramEdge());
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

	public Edge getDiagramEdge() {
		return (Edge) getModel();
	}

}
