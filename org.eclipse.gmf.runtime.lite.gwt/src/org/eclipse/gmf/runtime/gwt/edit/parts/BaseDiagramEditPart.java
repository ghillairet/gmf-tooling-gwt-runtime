package org.eclipse.gmf.runtime.gwt.edit.parts;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.gwt.edit.parts.update.IExternallyUpdatableEditPart;
import org.eclipse.gmf.runtime.gwt.edit.parts.update.IUpdatableEditPart;
import org.eclipse.gmf.runtime.gwt.edit.parts.update.RefreshersRegistry;
import org.eclipse.gmf.runtime.gwt.edit.parts.update.UpdaterUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

public abstract class BaseDiagramEditPart extends AbstractGraphicalEditPart implements Adapter, IUpdatableEditPart {

	private Notifier target;
	private RefreshersRegistry myRefreshersRegistry;
	
	private final NotationPackage notation = NotationPackage.eINSTANCE;

	@SuppressWarnings("unchecked")
	protected void registerModel() {
		super.registerModel();
		View view = (View) getModel();
		if (view != null && view.isSetElement() && view.getElement() != null) {
			getViewer().getEditPartRegistry().put(view.getElement(), this);
		}
	}

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

	public Diagram getDiagram() {
		return (Diagram) getModel();
	}

	@SuppressWarnings("unchecked")
	protected List<View> getModelChildren() {
		return getDiagram().getVisibleChildren();
	}

	public Refresher getRefresher(EStructuralFeature feature, Notification msg) {
		if (myRefreshersRegistry == null) {
			createRefreshers();
		}
		return myRefreshersRegistry.getRefresher(feature, msg);
	}

	private void createRefreshers() {
		myRefreshersRegistry = new RefreshersRegistry();
		Refresher childrenRefresher = new IExternallyUpdatableEditPart.ExternalRefresher() {
			public void refresh() {
				if (isActive()) refreshChildren();
			}
			public boolean isAffectingEvent(Notification msg) {
				if (notation.getView_PersistedChildren() == msg.getFeature() || 
						notation.getView_TransientChildren() == msg.getFeature() || 
						notation.getDrawerStyle_Collapsed() == msg.getFeature()) {
					return true;
				}
				if (notation.getView_Styles() == msg.getFeature()) {
					return UpdaterUtil.affects(msg, notation.getDrawerStyle());
				}
				if (notation.getView_Visible() == msg.getFeature()) {
					return msg.getNotifier() != getDiagram();
				}
				if (EcorePackage.eINSTANCE.getEModelElement_EAnnotations() == msg.getFeature()) {
					return msg.getNotifier() != getDiagram();
				}
				return false;
			}
		};
		myRefreshersRegistry.add(notation.getView_PersistedChildren(), childrenRefresher);
		myRefreshersRegistry.add(notation.getView_TransientChildren(), childrenRefresher);
		myRefreshersRegistry.add(notation.getView_Styles(), childrenRefresher);
		myRefreshersRegistry.add(notation.getDrawerStyle_Collapsed(), childrenRefresher);
		myRefreshersRegistry.add(notation.getView_Visible(), childrenRefresher);
		myRefreshersRegistry.add(EcorePackage.eINSTANCE.getEModelElement_EAnnotations(), childrenRefresher);
	}

	@Override
	public void activate() {
		super.activate();
		if (getModel() instanceof Notifier) {
			((Notifier) getModel()).eAdapters().add(this);
		}
	}

	@Override
	public void deactivate() {
		if (getModel() instanceof Notifier) {
			((Notifier) getModel()).eAdapters().remove(this);
		}
		super.deactivate();
	}

	@Override
	public void notifyChanged(Notification notification) {
		Object feature = notification.getFeature();
		if (feature instanceof EStructuralFeature) {
			Refresher refresher = getRefresher((EStructuralFeature) feature, notification);
			if (refresher != null) {
				refresher.refresh();
			}
		}
	}

	@Override
	public Notifier getTarget() {
		return target;
	}

	@Override
	public void setTarget(Notifier newTarget) {
		this.target = newTarget;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return getModel().getClass() == type;
	}

}
