/**
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    bblajer - initial API and implementation
 */
package org.eclipse.gmf.runtime.gwt.edit.parts.labels;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * An implementation of {@link ILabelTextDisplayer} that is based on a MessageFormat format and 
 * a number of {@link EStructuralFeature structural features} of the source object.
 */
public class MessageFormatLabelTextDisplayer extends AbstractFeatureBasedLabelTextDisplayer {
	private final String myViewPattern;
	private final String myEditPattern;
	private final String myEditorPattern;

//	private MessageFormat myViewProcessor;
//	private MessageFormat myEditProcessor;
//	private MessageFormat myEditorProcessor;

	public MessageFormatLabelTextDisplayer(String viewPattern, EStructuralFeature... features) {
		this(viewPattern, null, features);
	}

	public MessageFormatLabelTextDisplayer(String viewPattern, String editorPattern, EStructuralFeature... features) {
		this(viewPattern, editorPattern, null, features);
	}

	public MessageFormatLabelTextDisplayer(String viewPattern, String editorPattern, String editPattern, EStructuralFeature... features) {
		super(features);
		myViewPattern = viewPattern;
		myEditPattern = editPattern;
		myEditorPattern = editorPattern;
	}

//	protected final MessageFormat getViewPatternProcessor() {
//		if (myViewProcessor == null) {
//			myViewProcessor = createViewPatternProcessor(adjustPattern(myViewPattern));
//		}
//		return myViewProcessor;
//	}

//	protected MessageFormat createViewPatternProcessor(String viewPattern) {
//		return new MessageFormat(viewPattern);
//	}
//
//	protected final MessageFormat getEditPatternProcessor() {
//		if (myEditProcessor == null) {
//			myEditProcessor = createEditPatternProcessor(adjustPattern(myEditPattern));
//		}
//		return myEditProcessor;
//	}
//
//	protected MessageFormat createEditPatternProcessor(String editPattern) {
//		return new MessageFormat(editPattern);
//	}
//
//	protected final MessageFormat getEditorPatternProcessor() {
//		if (myEditorProcessor == null) {
//			myEditorProcessor = createEditorPatternProcessor(adjustPattern(myEditorPattern));
//		}
//		return myEditorProcessor;
//	}

//	protected MessageFormat createEditorPatternProcessor(String editorPattern) {
//		return new MessageFormat(editorPattern);
//	}

	protected String adjustPattern(String pattern) {
		if (pattern == null || pattern.length() == 0) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < getFeatures().length; i++) {
				if (i > 0) {
					sb.append(' ');
				}
				sb.append('{');
				sb.append(i);
				sb.append('}');
			}
			return sb.toString();
		}
		return pattern;
	}

	@Override
	protected String buildDisplayText(Object[] featureValues) {
//		return buildTextByPattern(featureValues, getViewPatternProcessor());
		
		if (featureValues != null && featureValues.length > 0) {
			return featureValues[0].toString();
		}
		return "";
	}

	@Override
	protected String buildEditText(Object[] featureValues) {
//		return buildTextByPattern(featureValues, getEditorPatternProcessor());

		if (featureValues != null && featureValues.length > 0) {
			return featureValues[0].toString();
		}
		return "";
	}

	@Override
	protected Object[] parseEditedValues(String newValue) throws IllegalArgumentException {
//		if (getEditPatternProcessor() == null) {
//			return null;
//		}
//		ParsePosition pos = new ParsePosition(0);
		if (getFeatures().length == 1 && EMPTY_STRING.equals(newValue)) {
			return new Object[] { null };
		} else {
//			return getEditPatternProcessor().parse(newValue, pos);
			return new Object[]{ newValue };
		}
//		return new Object[] {null};
	}

//	protected String buildTextByPattern(Object[] featureValues, MessageFormat format) {
//		if (format == null) {
//			return null;
//		}
//		return format.format(featureValues, new StringBuffer(), new FieldPosition(0)).toString();
//	}
}
