package org.eclipse.gmf.runtime.gwt.client;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

public interface ImageProvider {

	Image getImage(ENamedElement element);

	ImageDescriptor getImageDescriptor(ENamedElement element);

	ImageDescriptor getItemImageDescriptor(Object item);

}
