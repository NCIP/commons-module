/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/commons-module/LICENSE.txt for details.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.3 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.07.25 at 06:17:47 PM IST 
//


package edu.wustl.common.cde.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for XMLPermissibleValueType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="XMLPermissibleValueType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="evsTerminology" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="conceptCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="parentConceptCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="depthOfHierarchyTree" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMLPermissibleValueType", propOrder = {
    "evsTerminology",
    "conceptCode",
    "parentConceptCode",
    "depthOfHierarchyTree"
})
public class XMLPermissibleValueType {

    @XmlElement(required = true)
    protected String evsTerminology;
    @XmlElement(required = true)
    protected String conceptCode;
    @XmlElement(required = true)
    protected String parentConceptCode;
    protected int depthOfHierarchyTree;

    /**
     * Gets the value of the evsTerminology property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvsTerminology() {
        return evsTerminology;
    }

    /**
     * Sets the value of the evsTerminology property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvsTerminology(String value) {
        this.evsTerminology = value;
    }

    /**
     * Gets the value of the conceptCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConceptCode() {
        return conceptCode;
    }

    /**
     * Sets the value of the conceptCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConceptCode(String value) {
        this.conceptCode = value;
    }

    /**
     * Gets the value of the parentConceptCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentConceptCode() {
        return parentConceptCode;
    }

    /**
     * Sets the value of the parentConceptCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentConceptCode(String value) {
        this.parentConceptCode = value;
    }

    /**
     * Gets the value of the depthOfHierarchyTree property.
     * 
     */
    public int getDepthOfHierarchyTree() {
        return depthOfHierarchyTree;
    }

    /**
     * Sets the value of the depthOfHierarchyTree property.
     * 
     */
    public void setDepthOfHierarchyTree(int value) {
        this.depthOfHierarchyTree = value;
    }

}
