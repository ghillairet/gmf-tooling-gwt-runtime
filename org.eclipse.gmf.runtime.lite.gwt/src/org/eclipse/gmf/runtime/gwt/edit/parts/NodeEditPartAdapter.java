package org.eclipse.gmf.runtime.gwt.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.gwt.edit.parts.update.UpdaterUtil;
import org.eclipse.gmf.runtime.notation.NotationPackage;

public abstract class NodeEditPartAdapter extends EContentAdapter {

	private static final NotationPackage notation = NotationPackage.eINSTANCE;
	private final AbstractGraphicalEditPart editPart;
	private final ArrayList<EditPartRefresher> refreshers = new ArrayList<EditPartRefresher>();

	public NodeEditPartAdapter(AbstractGraphicalEditPart editPart) {
		this.editPart = editPart;
	}

	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);

		if (editPart.isActive()) {
			if (shouldRefreshChildren(notification)) {
				refreshChildren();
			}
			if (shouldRefreshVisibility(notification)) {
				refreshVisibility();
			}
			if (shouldRefreshFont(notification)) {
				refreshFont();
			}
			if (shouldRefreshBounds(notification)) {
				refreshBounds();
			}
			if (shouldRefreshSourceEdges(notification)) {
				refreshSourceConnections();
			}
			if (shoulRefreshTargetEdges(notification)) {
				refreshTargetConnections();
			}
			if (shouldRefreshFont(notification)) {
				refreshFont();
			}
			if (shouldRefreshBendpoints(notification)) {
				refreshBendpoints();
			}
			if (shouldRefreshBackgroundColor(notification)) {
				refreshBackgroundColor();
			}
		}

		for (EditPartRefresher refresher: refreshers) {
			if (refresher.shouldRefresh(notification)) {
				refresher.refresh();
			}
		}
	}

	private boolean shoulRefreshTargetEdges(Notification notification) {
		return notation.getView_TargetEdges().equals(notification.getFeature());
	}

	private boolean shouldRefreshSourceEdges(Notification notification) {
		return notation.getView_SourceEdges().equals(notification.getFeature());
	}

	private boolean shouldRefreshBounds(Notification notification) {
		if (notation.getNode_LayoutConstraint().equals(notification.getFeature())) {
			return true;
		}
		if (notation.getSize_Width().equals(notification.getFeature())) {
			return true;
		}
		if (notation.getSize_Height().equals(notification.getFeature())) {
			return true;
		}
		if (notation.getLocation_X().equals(notification.getFeature())) {
			return true;
		}
		if (notation.getLocation_Y().equals(notification.getFeature())) {
			return true;
		}
		return false;
	}

	protected boolean shouldRefreshChildren(Notification notification) {
		final Object feature = notification.getFeature();

		if (notation.getView_PersistedChildren() == feature || 
				notation.getView_TransientChildren() == feature|| 
				notation.getDrawerStyle_Collapsed() == feature) {
			return true;
		}
		if (notation.getView_Styles() == feature) {
			return UpdaterUtil.affects(notification, notation.getDrawerStyle());
		}
		if (notation.getView_Visible() == feature) {
			return notification.getNotifier() != editPart.getModel();
		}
		if (EcorePackage.eINSTANCE.getEModelElement_EAnnotations() == feature) {
			return notification.getNotifier() != editPart.getModel();
		}
		return false;
	}

	protected boolean shouldRefreshVisibility(Notification notification) {
		if (notation.getView_Visible() == notification.getFeature()) {
			return notification.getNotifier() == editPart.getModel();
		}
		return false;
	}

	protected boolean shouldRefreshFont(Notification notification) {
		List<EStructuralFeature> features = notation.getFontStyle().getEStructuralFeatures();
		if (notification.getFeature() != null && features.contains(notification.getFeature())) {
			return true;
		}
		if (notation.getView_Styles() == notification.getFeature()) {
			return UpdaterUtil.affects(notification, notation.getFontStyle());
		}
		return false;
	}
	
	protected boolean shouldRefreshBendpoints(Notification notification) {
		return notation.getEdge_Bendpoints().equals(notification.getFeature()) || 
				notation.getRelativeBendpoints_Points().equals(notification.getFeature());
	}
	
	protected boolean shouldRefreshBackgroundColor(Notification notification) {
		if (notation.getFillStyle_FillColor().equals(notification.getFeature())) {
			return true;
		}
		if (notation.getView_Styles() == notification.getFeature()) {
			return UpdaterUtil.affects(notification, notation.getFillStyle());
		}
		return false;
	}

	public void addRefresher(EditPartRefresher refresher) {
		refreshers.add(refresher);
	}

	public void removeRefresher(EditPartRefresher refresher) {
		refreshers.remove(refresher);
	}

	public abstract void refreshChildren();
	public abstract void refreshVisibility();
	public abstract void refreshFont();
	public abstract void refreshSourceConnections();
	public abstract void refreshTargetConnections();
	public abstract void refreshBounds();
	public abstract void refreshBendpoints();
	public abstract void refreshBackgroundColor();

}
