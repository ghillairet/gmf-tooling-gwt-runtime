/**
 */
package org.eclipse.gmf.runtime.notation.util;

import java.util.Map;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.gmf.runtime.notation.Alignment;
import org.eclipse.gmf.runtime.notation.Anchor;
import org.eclipse.gmf.runtime.notation.ArrowStyle;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.BasicDecorationNode;
import org.eclipse.gmf.runtime.notation.BasicSemanticCompartment;
import org.eclipse.gmf.runtime.notation.Bendpoints;
import org.eclipse.gmf.runtime.notation.BooleanListValueStyle;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.ByteArrayValueStyle;
import org.eclipse.gmf.runtime.notation.CanonicalStyle;
import org.eclipse.gmf.runtime.notation.Compartment;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.ConnectorStyle;
import org.eclipse.gmf.runtime.notation.DataTypeStyle;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.DescriptionStyle;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.DiagramLinkStyle;
import org.eclipse.gmf.runtime.notation.DiagramStyle;
import org.eclipse.gmf.runtime.notation.DoubleListValueStyle;
import org.eclipse.gmf.runtime.notation.DoubleValueStyle;
import org.eclipse.gmf.runtime.notation.DrawerStyle;
import org.eclipse.gmf.runtime.notation.EObjectListValueStyle;
import org.eclipse.gmf.runtime.notation.EObjectValueStyle;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.FilteringStyle;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.Guide;
import org.eclipse.gmf.runtime.notation.GuideStyle;
import org.eclipse.gmf.runtime.notation.HintedDiagramLinkStyle;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.Image;
import org.eclipse.gmf.runtime.notation.ImageBufferStyle;
import org.eclipse.gmf.runtime.notation.ImageStyle;
import org.eclipse.gmf.runtime.notation.IntListValueStyle;
import org.eclipse.gmf.runtime.notation.IntValueStyle;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.LineStyle;
import org.eclipse.gmf.runtime.notation.LineTypeStyle;
import org.eclipse.gmf.runtime.notation.ListCompartment;
import org.eclipse.gmf.runtime.notation.ListValueStyle;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.MultiDiagramLinkStyle;
import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.PageStyle;
import org.eclipse.gmf.runtime.notation.PropertiesSetStyle;
import org.eclipse.gmf.runtime.notation.PropertyValue;
import org.eclipse.gmf.runtime.notation.Ratio;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.RoundedCornersStyle;
import org.eclipse.gmf.runtime.notation.RoutingStyle;
import org.eclipse.gmf.runtime.notation.SemanticListCompartment;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.SingleValueStyle;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.SortingStyle;
import org.eclipse.gmf.runtime.notation.StandardDiagram;
import org.eclipse.gmf.runtime.notation.StringListValueStyle;
import org.eclipse.gmf.runtime.notation.StringObjectConverter;
import org.eclipse.gmf.runtime.notation.StringValueStyle;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.TextStyle;
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.gmf.runtime.notation.View;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.runtime.notation.NotationPackage
 * @generated
 */
public class NotationSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static NotationPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotationSwitch() {
		if (modelPackage == null) {
			modelPackage = NotationPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case NotationPackage.EDGE: {
				Edge edge = (Edge)theEObject;
				T result = caseEdge(edge);
				if (result == null) result = caseView(edge);
				if (result == null) result = caseEModelElement(edge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.NODE: {
				Node node = (Node)theEObject;
				T result = caseNode(node);
				if (result == null) result = caseView(node);
				if (result == null) result = caseEModelElement(node);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.STYLE: {
				Style style = (Style)theEObject;
				T result = caseStyle(style);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.FILL_STYLE: {
				FillStyle fillStyle = (FillStyle)theEObject;
				T result = caseFillStyle(fillStyle);
				if (result == null) result = caseStyle(fillStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.LINE_STYLE: {
				LineStyle lineStyle = (LineStyle)theEObject;
				T result = caseLineStyle(lineStyle);
				if (result == null) result = caseStyle(lineStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.FONT_STYLE: {
				FontStyle fontStyle = (FontStyle)theEObject;
				T result = caseFontStyle(fontStyle);
				if (result == null) result = caseStyle(fontStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.TITLE_STYLE: {
				TitleStyle titleStyle = (TitleStyle)theEObject;
				T result = caseTitleStyle(titleStyle);
				if (result == null) result = caseStyle(titleStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.SORTING_STYLE: {
				SortingStyle sortingStyle = (SortingStyle)theEObject;
				T result = caseSortingStyle(sortingStyle);
				if (result == null) result = caseStyle(sortingStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.DESCRIPTION_STYLE: {
				DescriptionStyle descriptionStyle = (DescriptionStyle)theEObject;
				T result = caseDescriptionStyle(descriptionStyle);
				if (result == null) result = caseStyle(descriptionStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.LAYOUT_CONSTRAINT: {
				LayoutConstraint layoutConstraint = (LayoutConstraint)theEObject;
				T result = caseLayoutConstraint(layoutConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.SIZE: {
				Size size = (Size)theEObject;
				T result = caseSize(size);
				if (result == null) result = caseLayoutConstraint(size);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.LOCATION: {
				Location location = (Location)theEObject;
				T result = caseLocation(location);
				if (result == null) result = caseLayoutConstraint(location);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.BOUNDS: {
				Bounds bounds = (Bounds)theEObject;
				T result = caseBounds(bounds);
				if (result == null) result = caseLocation(bounds);
				if (result == null) result = caseSize(bounds);
				if (result == null) result = caseLayoutConstraint(bounds);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.RATIO: {
				Ratio ratio = (Ratio)theEObject;
				T result = caseRatio(ratio);
				if (result == null) result = caseLayoutConstraint(ratio);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.ANCHOR: {
				Anchor anchor = (Anchor)theEObject;
				T result = caseAnchor(anchor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.BENDPOINTS: {
				Bendpoints bendpoints = (Bendpoints)theEObject;
				T result = caseBendpoints(bendpoints);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.IDENTITY_ANCHOR: {
				IdentityAnchor identityAnchor = (IdentityAnchor)theEObject;
				T result = caseIdentityAnchor(identityAnchor);
				if (result == null) result = caseAnchor(identityAnchor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.ROUTING_STYLE: {
				RoutingStyle routingStyle = (RoutingStyle)theEObject;
				T result = caseRoutingStyle(routingStyle);
				if (result == null) result = caseRoundedCornersStyle(routingStyle);
				if (result == null) result = caseStyle(routingStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.VIEW: {
				View view = (View)theEObject;
				T result = caseView(view);
				if (result == null) result = caseEModelElement(view);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.RELATIVE_BENDPOINTS: {
				RelativeBendpoints relativeBendpoints = (RelativeBendpoints)theEObject;
				T result = caseRelativeBendpoints(relativeBendpoints);
				if (result == null) result = caseBendpoints(relativeBendpoints);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.DIAGRAM: {
				Diagram diagram = (Diagram)theEObject;
				T result = caseDiagram(diagram);
				if (result == null) result = caseView(diagram);
				if (result == null) result = caseEModelElement(diagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.IMAGE: {
				Image image = (Image)theEObject;
				T result = caseImage(image);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.CANONICAL_STYLE: {
				CanonicalStyle canonicalStyle = (CanonicalStyle)theEObject;
				T result = caseCanonicalStyle(canonicalStyle);
				if (result == null) result = caseStyle(canonicalStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.SHAPE_STYLE: {
				ShapeStyle shapeStyle = (ShapeStyle)theEObject;
				T result = caseShapeStyle(shapeStyle);
				if (result == null) result = caseFontStyle(shapeStyle);
				if (result == null) result = caseDescriptionStyle(shapeStyle);
				if (result == null) result = caseFillStyle(shapeStyle);
				if (result == null) result = caseLineStyle(shapeStyle);
				if (result == null) result = caseRoundedCornersStyle(shapeStyle);
				if (result == null) result = caseStyle(shapeStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.CONNECTOR_STYLE: {
				ConnectorStyle connectorStyle = (ConnectorStyle)theEObject;
				T result = caseConnectorStyle(connectorStyle);
				if (result == null) result = caseRoutingStyle(connectorStyle);
				if (result == null) result = caseLineStyle(connectorStyle);
				if (result == null) result = caseRoundedCornersStyle(connectorStyle);
				if (result == null) result = caseStyle(connectorStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.PAGE_STYLE: {
				PageStyle pageStyle = (PageStyle)theEObject;
				T result = casePageStyle(pageStyle);
				if (result == null) result = caseStyle(pageStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.DRAWER_STYLE: {
				DrawerStyle drawerStyle = (DrawerStyle)theEObject;
				T result = caseDrawerStyle(drawerStyle);
				if (result == null) result = caseStyle(drawerStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.GUIDE_STYLE: {
				GuideStyle guideStyle = (GuideStyle)theEObject;
				T result = caseGuideStyle(guideStyle);
				if (result == null) result = caseStyle(guideStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.GUIDE: {
				Guide guide = (Guide)theEObject;
				T result = caseGuide(guide);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.NODE_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<Node, Alignment> nodeEntry = (Map.Entry<Node, Alignment>)theEObject;
				T result = caseNodeEntry(nodeEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.FILTERING_STYLE: {
				FilteringStyle filteringStyle = (FilteringStyle)theEObject;
				T result = caseFilteringStyle(filteringStyle);
				if (result == null) result = caseStyle(filteringStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.DIAGRAM_STYLE: {
				DiagramStyle diagramStyle = (DiagramStyle)theEObject;
				T result = caseDiagramStyle(diagramStyle);
				if (result == null) result = casePageStyle(diagramStyle);
				if (result == null) result = caseGuideStyle(diagramStyle);
				if (result == null) result = caseDescriptionStyle(diagramStyle);
				if (result == null) result = caseStyle(diagramStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.IMAGE_STYLE: {
				ImageStyle imageStyle = (ImageStyle)theEObject;
				T result = caseImageStyle(imageStyle);
				if (result == null) result = caseStyle(imageStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.IMAGE_BUFFER_STYLE: {
				ImageBufferStyle imageBufferStyle = (ImageBufferStyle)theEObject;
				T result = caseImageBufferStyle(imageBufferStyle);
				if (result == null) result = caseImageStyle(imageBufferStyle);
				if (result == null) result = caseStyle(imageBufferStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.PROPERTIES_SET_STYLE: {
				PropertiesSetStyle propertiesSetStyle = (PropertiesSetStyle)theEObject;
				T result = casePropertiesSetStyle(propertiesSetStyle);
				if (result == null) result = caseNamedStyle(propertiesSetStyle);
				if (result == null) result = caseStyle(propertiesSetStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.STRING_TO_PROPERTY_VALUE_MAP_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<String, PropertyValue> stringToPropertyValueMapEntry = (Map.Entry<String, PropertyValue>)theEObject;
				T result = caseStringToPropertyValueMapEntry(stringToPropertyValueMapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.PROPERTY_VALUE: {
				PropertyValue propertyValue = (PropertyValue)theEObject;
				T result = casePropertyValue(propertyValue);
				if (result == null) result = caseStringObjectConverter(propertyValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.SINGLE_VALUE_STYLE: {
				SingleValueStyle singleValueStyle = (SingleValueStyle)theEObject;
				T result = caseSingleValueStyle(singleValueStyle);
				if (result == null) result = caseDataTypeStyle(singleValueStyle);
				if (result == null) result = caseNamedStyle(singleValueStyle);
				if (result == null) result = caseStringObjectConverter(singleValueStyle);
				if (result == null) result = caseStyle(singleValueStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.LIST_VALUE_STYLE: {
				ListValueStyle listValueStyle = (ListValueStyle)theEObject;
				T result = caseListValueStyle(listValueStyle);
				if (result == null) result = caseDataTypeStyle(listValueStyle);
				if (result == null) result = caseNamedStyle(listValueStyle);
				if (result == null) result = caseStringObjectConverter(listValueStyle);
				if (result == null) result = caseStyle(listValueStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.NAMED_STYLE: {
				NamedStyle namedStyle = (NamedStyle)theEObject;
				T result = caseNamedStyle(namedStyle);
				if (result == null) result = caseStyle(namedStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.STRING_OBJECT_CONVERTER: {
				StringObjectConverter stringObjectConverter = (StringObjectConverter)theEObject;
				T result = caseStringObjectConverter(stringObjectConverter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.DATA_TYPE_STYLE: {
				DataTypeStyle dataTypeStyle = (DataTypeStyle)theEObject;
				T result = caseDataTypeStyle(dataTypeStyle);
				if (result == null) result = caseNamedStyle(dataTypeStyle);
				if (result == null) result = caseStringObjectConverter(dataTypeStyle);
				if (result == null) result = caseStyle(dataTypeStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.INT_VALUE_STYLE: {
				IntValueStyle intValueStyle = (IntValueStyle)theEObject;
				T result = caseIntValueStyle(intValueStyle);
				if (result == null) result = caseNamedStyle(intValueStyle);
				if (result == null) result = caseStyle(intValueStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.INT_LIST_VALUE_STYLE: {
				IntListValueStyle intListValueStyle = (IntListValueStyle)theEObject;
				T result = caseIntListValueStyle(intListValueStyle);
				if (result == null) result = caseNamedStyle(intListValueStyle);
				if (result == null) result = caseStyle(intListValueStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.BOOLEAN_VALUE_STYLE: {
				BooleanValueStyle booleanValueStyle = (BooleanValueStyle)theEObject;
				T result = caseBooleanValueStyle(booleanValueStyle);
				if (result == null) result = caseNamedStyle(booleanValueStyle);
				if (result == null) result = caseStyle(booleanValueStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.DOUBLE_VALUE_STYLE: {
				DoubleValueStyle doubleValueStyle = (DoubleValueStyle)theEObject;
				T result = caseDoubleValueStyle(doubleValueStyle);
				if (result == null) result = caseNamedStyle(doubleValueStyle);
				if (result == null) result = caseStyle(doubleValueStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.DOUBLE_LIST_VALUE_STYLE: {
				DoubleListValueStyle doubleListValueStyle = (DoubleListValueStyle)theEObject;
				T result = caseDoubleListValueStyle(doubleListValueStyle);
				if (result == null) result = caseNamedStyle(doubleListValueStyle);
				if (result == null) result = caseStyle(doubleListValueStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.STRING_VALUE_STYLE: {
				StringValueStyle stringValueStyle = (StringValueStyle)theEObject;
				T result = caseStringValueStyle(stringValueStyle);
				if (result == null) result = caseNamedStyle(stringValueStyle);
				if (result == null) result = caseStyle(stringValueStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.STRING_LIST_VALUE_STYLE: {
				StringListValueStyle stringListValueStyle = (StringListValueStyle)theEObject;
				T result = caseStringListValueStyle(stringListValueStyle);
				if (result == null) result = caseNamedStyle(stringListValueStyle);
				if (result == null) result = caseStyle(stringListValueStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.EOBJECT_VALUE_STYLE: {
				EObjectValueStyle eObjectValueStyle = (EObjectValueStyle)theEObject;
				T result = caseEObjectValueStyle(eObjectValueStyle);
				if (result == null) result = caseNamedStyle(eObjectValueStyle);
				if (result == null) result = caseStyle(eObjectValueStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.EOBJECT_LIST_VALUE_STYLE: {
				EObjectListValueStyle eObjectListValueStyle = (EObjectListValueStyle)theEObject;
				T result = caseEObjectListValueStyle(eObjectListValueStyle);
				if (result == null) result = caseNamedStyle(eObjectListValueStyle);
				if (result == null) result = caseStyle(eObjectListValueStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.BYTE_ARRAY_VALUE_STYLE: {
				ByteArrayValueStyle byteArrayValueStyle = (ByteArrayValueStyle)theEObject;
				T result = caseByteArrayValueStyle(byteArrayValueStyle);
				if (result == null) result = caseNamedStyle(byteArrayValueStyle);
				if (result == null) result = caseStyle(byteArrayValueStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.BOOLEAN_LIST_VALUE_STYLE: {
				BooleanListValueStyle booleanListValueStyle = (BooleanListValueStyle)theEObject;
				T result = caseBooleanListValueStyle(booleanListValueStyle);
				if (result == null) result = caseNamedStyle(booleanListValueStyle);
				if (result == null) result = caseStyle(booleanListValueStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.HINTED_DIAGRAM_LINK_STYLE: {
				HintedDiagramLinkStyle hintedDiagramLinkStyle = (HintedDiagramLinkStyle)theEObject;
				T result = caseHintedDiagramLinkStyle(hintedDiagramLinkStyle);
				if (result == null) result = caseDiagramLinkStyle(hintedDiagramLinkStyle);
				if (result == null) result = caseStyle(hintedDiagramLinkStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.DIAGRAM_LINK_STYLE: {
				DiagramLinkStyle diagramLinkStyle = (DiagramLinkStyle)theEObject;
				T result = caseDiagramLinkStyle(diagramLinkStyle);
				if (result == null) result = caseStyle(diagramLinkStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.MULTI_DIAGRAM_LINK_STYLE: {
				MultiDiagramLinkStyle multiDiagramLinkStyle = (MultiDiagramLinkStyle)theEObject;
				T result = caseMultiDiagramLinkStyle(multiDiagramLinkStyle);
				if (result == null) result = caseStyle(multiDiagramLinkStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.TEXT_STYLE: {
				TextStyle textStyle = (TextStyle)theEObject;
				T result = caseTextStyle(textStyle);
				if (result == null) result = caseStyle(textStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.LINE_TYPE_STYLE: {
				LineTypeStyle lineTypeStyle = (LineTypeStyle)theEObject;
				T result = caseLineTypeStyle(lineTypeStyle);
				if (result == null) result = caseStyle(lineTypeStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.ARROW_STYLE: {
				ArrowStyle arrowStyle = (ArrowStyle)theEObject;
				T result = caseArrowStyle(arrowStyle);
				if (result == null) result = caseStyle(arrowStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.SHAPE: {
				Shape shape = (Shape)theEObject;
				T result = caseShape(shape);
				if (result == null) result = caseNode(shape);
				if (result == null) result = caseShapeStyle(shape);
				if (result == null) result = caseView(shape);
				if (result == null) result = caseFontStyle(shape);
				if (result == null) result = caseDescriptionStyle(shape);
				if (result == null) result = caseFillStyle(shape);
				if (result == null) result = caseLineStyle(shape);
				if (result == null) result = caseRoundedCornersStyle(shape);
				if (result == null) result = caseEModelElement(shape);
				if (result == null) result = caseStyle(shape);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.COMPARTMENT: {
				Compartment compartment = (Compartment)theEObject;
				T result = caseCompartment(compartment);
				if (result == null) result = caseBasicCompartment(compartment);
				if (result == null) result = caseCanonicalStyle(compartment);
				if (result == null) result = caseTitleStyle(compartment);
				if (result == null) result = caseDecorationNode(compartment);
				if (result == null) result = caseDrawerStyle(compartment);
				if (result == null) result = caseBasicDecorationNode(compartment);
				if (result == null) result = caseStyle(compartment);
				if (result == null) result = caseNode(compartment);
				if (result == null) result = caseView(compartment);
				if (result == null) result = caseEModelElement(compartment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.LIST_COMPARTMENT: {
				ListCompartment listCompartment = (ListCompartment)theEObject;
				T result = caseListCompartment(listCompartment);
				if (result == null) result = caseBasicCompartment(listCompartment);
				if (result == null) result = caseSortingStyle(listCompartment);
				if (result == null) result = caseFilteringStyle(listCompartment);
				if (result == null) result = caseTitleStyle(listCompartment);
				if (result == null) result = caseDecorationNode(listCompartment);
				if (result == null) result = caseDrawerStyle(listCompartment);
				if (result == null) result = caseBasicDecorationNode(listCompartment);
				if (result == null) result = caseStyle(listCompartment);
				if (result == null) result = caseNode(listCompartment);
				if (result == null) result = caseView(listCompartment);
				if (result == null) result = caseEModelElement(listCompartment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.CONNECTOR: {
				Connector connector = (Connector)theEObject;
				T result = caseConnector(connector);
				if (result == null) result = caseEdge(connector);
				if (result == null) result = caseConnectorStyle(connector);
				if (result == null) result = caseView(connector);
				if (result == null) result = caseRoutingStyle(connector);
				if (result == null) result = caseLineStyle(connector);
				if (result == null) result = caseEModelElement(connector);
				if (result == null) result = caseRoundedCornersStyle(connector);
				if (result == null) result = caseStyle(connector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.STANDARD_DIAGRAM: {
				StandardDiagram standardDiagram = (StandardDiagram)theEObject;
				T result = caseStandardDiagram(standardDiagram);
				if (result == null) result = caseDiagram(standardDiagram);
				if (result == null) result = caseDiagramStyle(standardDiagram);
				if (result == null) result = caseView(standardDiagram);
				if (result == null) result = casePageStyle(standardDiagram);
				if (result == null) result = caseGuideStyle(standardDiagram);
				if (result == null) result = caseDescriptionStyle(standardDiagram);
				if (result == null) result = caseEModelElement(standardDiagram);
				if (result == null) result = caseStyle(standardDiagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.DECORATION_NODE: {
				DecorationNode decorationNode = (DecorationNode)theEObject;
				T result = caseDecorationNode(decorationNode);
				if (result == null) result = caseBasicDecorationNode(decorationNode);
				if (result == null) result = caseNode(decorationNode);
				if (result == null) result = caseView(decorationNode);
				if (result == null) result = caseEModelElement(decorationNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.BASIC_DECORATION_NODE: {
				BasicDecorationNode basicDecorationNode = (BasicDecorationNode)theEObject;
				T result = caseBasicDecorationNode(basicDecorationNode);
				if (result == null) result = caseNode(basicDecorationNode);
				if (result == null) result = caseView(basicDecorationNode);
				if (result == null) result = caseEModelElement(basicDecorationNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.BASIC_COMPARTMENT: {
				BasicCompartment basicCompartment = (BasicCompartment)theEObject;
				T result = caseBasicCompartment(basicCompartment);
				if (result == null) result = caseDecorationNode(basicCompartment);
				if (result == null) result = caseDrawerStyle(basicCompartment);
				if (result == null) result = caseBasicDecorationNode(basicCompartment);
				if (result == null) result = caseStyle(basicCompartment);
				if (result == null) result = caseNode(basicCompartment);
				if (result == null) result = caseView(basicCompartment);
				if (result == null) result = caseEModelElement(basicCompartment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.BASIC_SEMANTIC_COMPARTMENT: {
				BasicSemanticCompartment basicSemanticCompartment = (BasicSemanticCompartment)theEObject;
				T result = caseBasicSemanticCompartment(basicSemanticCompartment);
				if (result == null) result = caseBasicDecorationNode(basicSemanticCompartment);
				if (result == null) result = caseDrawerStyle(basicSemanticCompartment);
				if (result == null) result = caseNode(basicSemanticCompartment);
				if (result == null) result = caseStyle(basicSemanticCompartment);
				if (result == null) result = caseView(basicSemanticCompartment);
				if (result == null) result = caseEModelElement(basicSemanticCompartment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.SEMANTIC_LIST_COMPARTMENT: {
				SemanticListCompartment semanticListCompartment = (SemanticListCompartment)theEObject;
				T result = caseSemanticListCompartment(semanticListCompartment);
				if (result == null) result = caseBasicSemanticCompartment(semanticListCompartment);
				if (result == null) result = caseSortingStyle(semanticListCompartment);
				if (result == null) result = caseFilteringStyle(semanticListCompartment);
				if (result == null) result = caseTitleStyle(semanticListCompartment);
				if (result == null) result = caseBasicDecorationNode(semanticListCompartment);
				if (result == null) result = caseDrawerStyle(semanticListCompartment);
				if (result == null) result = caseNode(semanticListCompartment);
				if (result == null) result = caseStyle(semanticListCompartment);
				if (result == null) result = caseView(semanticListCompartment);
				if (result == null) result = caseEModelElement(semanticListCompartment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case NotationPackage.ROUNDED_CORNERS_STYLE: {
				RoundedCornersStyle roundedCornersStyle = (RoundedCornersStyle)theEObject;
				T result = caseRoundedCornersStyle(roundedCornersStyle);
				if (result == null) result = caseStyle(roundedCornersStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdge(Edge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNode(Node object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStyle(Style object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fill Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fill Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFillStyle(FillStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Line Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Line Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLineStyle(LineStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Font Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Font Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFontStyle(FontStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Title Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Title Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTitleStyle(TitleStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sorting Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sorting Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSortingStyle(SortingStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Description Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Description Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDescriptionStyle(DescriptionStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Layout Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Layout Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLayoutConstraint(LayoutConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Size</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Size</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSize(Size object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Location</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocation(Location object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bounds</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bounds</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBounds(Bounds object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ratio</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ratio</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRatio(Ratio object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Anchor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Anchor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnchor(Anchor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bendpoints</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bendpoints</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBendpoints(Bendpoints object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identity Anchor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identity Anchor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentityAnchor(IdentityAnchor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Routing Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Routing Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoutingStyle(RoutingStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>View</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseView(View object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relative Bendpoints</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relative Bendpoints</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelativeBendpoints(RelativeBendpoints object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiagram(Diagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Image</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Image</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImage(Image object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Canonical Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Canonical Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCanonicalStyle(CanonicalStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Shape Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Shape Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShapeStyle(ShapeStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnectorStyle(ConnectorStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Page Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Page Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePageStyle(PageStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Drawer Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Drawer Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDrawerStyle(DrawerStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Guide Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Guide Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGuideStyle(GuideStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Guide</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Guide</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGuide(Guide object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNodeEntry(Map.Entry<Node, Alignment> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Filtering Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Filtering Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFilteringStyle(FilteringStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Diagram Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Diagram Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiagramStyle(DiagramStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Image Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Image Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImageStyle(ImageStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Image Buffer Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Image Buffer Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImageBufferStyle(ImageBufferStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Properties Set Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Properties Set Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertiesSetStyle(PropertiesSetStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String To Property Value Map Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String To Property Value Map Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringToPropertyValueMapEntry(Map.Entry<String, PropertyValue> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyValue(PropertyValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Single Value Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Single Value Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSingleValueStyle(SingleValueStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>List Value Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>List Value Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseListValueStyle(ListValueStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedStyle(NamedStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Object Converter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Object Converter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringObjectConverter(StringObjectConverter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataTypeStyle(DataTypeStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Int Value Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int Value Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntValueStyle(IntValueStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Int List Value Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int List Value Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntListValueStyle(IntListValueStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Value Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Value Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanValueStyle(BooleanValueStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double Value Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double Value Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoubleValueStyle(DoubleValueStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double List Value Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double List Value Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoubleListValueStyle(DoubleListValueStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Value Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Value Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringValueStyle(StringValueStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String List Value Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String List Value Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringListValueStyle(StringListValueStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject Value Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject Value Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEObjectValueStyle(EObjectValueStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject List Value Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject List Value Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEObjectListValueStyle(EObjectListValueStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Byte Array Value Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Byte Array Value Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseByteArrayValueStyle(ByteArrayValueStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean List Value Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean List Value Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanListValueStyle(BooleanListValueStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hinted Diagram Link Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hinted Diagram Link Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHintedDiagramLinkStyle(HintedDiagramLinkStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Diagram Link Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Diagram Link Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiagramLinkStyle(DiagramLinkStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multi Diagram Link Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multi Diagram Link Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiDiagramLinkStyle(MultiDiagramLinkStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTextStyle(TextStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Line Type Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Line Type Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLineTypeStyle(LineTypeStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Arrow Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Arrow Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArrowStyle(ArrowStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Shape</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Shape</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShape(Shape object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompartment(Compartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>List Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>List Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseListCompartment(ListCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnector(Connector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Standard Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Standard Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStandardDiagram(StandardDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Decoration Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Decoration Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDecorationNode(DecorationNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Basic Decoration Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Basic Decoration Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBasicDecorationNode(BasicDecorationNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Basic Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Basic Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBasicCompartment(BasicCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Basic Semantic Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Basic Semantic Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBasicSemanticCompartment(BasicSemanticCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Semantic List Compartment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Semantic List Compartment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSemanticListCompartment(SemanticListCompartment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rounded Corners Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rounded Corners Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoundedCornersStyle(RoundedCornersStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EModel Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EModel Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEModelElement(EModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //NotationSwitch
