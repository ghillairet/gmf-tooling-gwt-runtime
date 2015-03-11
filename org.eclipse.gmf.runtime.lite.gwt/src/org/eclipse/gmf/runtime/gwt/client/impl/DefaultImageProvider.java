package org.eclipse.gmf.runtime.gwt.client.impl;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.gmf.runtime.gwt.client.ImageProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import com.google.gwt.resources.client.ImageResource;

public class DefaultImageProvider implements ImageProvider {

	private final Map<String, ImageDescriptor> map = new HashMap<String, ImageDescriptor>();

	@Inject
	private ComposedAdapterFactory adapter;

	@Override
	public Image getImage(ENamedElement element) {
		return getImageDescriptor(element).createImage();
	}

	private String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	@Override
	public ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = map.get(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			map.put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	@Override
	public ImageDescriptor getItemImageDescriptor(Object item) {
		IItemLabelProvider labelProvider = (IItemLabelProvider) adapter.adapt(item, IItemLabelProvider.class);

		if (labelProvider != null) {
			Object image = labelProvider.getImage(item);
			if (image instanceof Image) {
				return ImageDescriptor.createFromImage((Image) image);
			} else if (image instanceof ImageResource) {
				return ImageDescriptor.createFromImage(new Image(null, image));
			}
		}
		return null;
	}

	private ImageDescriptor getProvidedImageDescriptor(ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass && !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return getItemImageDescriptor(eClass.getEPackage().getEFactoryInstance().create(eClass));
			}
		} 
		return null;
	}

}

