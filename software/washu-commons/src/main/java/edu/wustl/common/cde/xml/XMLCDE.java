/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/catissue-commons-module/LICENSE.txt for details.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.3 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.07.25 at 06:17:47 PM IST 
//


package edu.wustl.common.cde.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for XMLCDE complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="XMLCDE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="publicId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="XMLPermissibleValues" type="{}XMLPermissibleValueType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="cache" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="lazyLoading" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMLCDE", propOrder = {
    "name",
    "publicId",
    "xmlPermissibleValues"
})
public class XMLCDE {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String publicId;
    @XmlElement(name = "XMLPermissibleValues", required = true)
    protected List<XMLPermissibleValueType> xmlPermissibleValues;
    @XmlAttribute
    protected Boolean cache;
    @XmlAttribute
    protected Boolean lazyLoading;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the publicId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicId() {
        return publicId;
    }

    /**
     * Sets the value of the publicId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicId(String value) {
        this.publicId = value;
    }

    /**
     * Gets the value of the xmlPermissibleValues property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the xmlPermissibleValues property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getXMLPermissibleValues().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XMLPermissibleValueType }
     * 
     * 
     */
    public List<XMLPermissibleValueType> getXMLPermissibleValues() {
        if (xmlPermissibleValues == null) {
            xmlPermissibleValues = new ArrayList<XMLPermissibleValueType>();
        }
        return this.xmlPermissibleValues;
    }

    /**
     * Gets the value of the cache property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCache() {
        return cache;
    }

    /**
     * Sets the value of the cache property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCache(Boolean value) {
        this.cache = value;
    }

    /**
     * Gets the value of the lazyLoading property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLazyLoading() {
        return lazyLoading;
    }

    /**
     * Sets the value of the lazyLoading property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLazyLoading(Boolean value) {
        this.lazyLoading = value;
    }

}
