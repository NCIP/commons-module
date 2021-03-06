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

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the edu.wustl.common.cde.xml package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _XMLCDECACHE_QNAME = new QName("", "XMLCDE_CACHE");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.wustl.common.cde.xml
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link XMLCDE }
     *
     */
    public XMLCDE createXMLCDE() {
        return new XMLCDE();
    }

    /**
     * Create an instance of {@link XMLPermissibleValueType }
     *
     */
    public XMLPermissibleValueType createXMLPermissibleValueType() {
        return new XMLPermissibleValueType();
    }

    /**
     * Create an instance of {@link XMLCDECacheType }
     *
     */
    public XMLCDECacheType createXMLCDECacheType() {
        return new XMLCDECacheType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLCDECacheType }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "", name = "XMLCDE_CACHE")
    public JAXBElement<XMLCDECacheType> createXMLCDECACHE(XMLCDECacheType value) {
        return new JAXBElement<XMLCDECacheType>(_XMLCDECACHE_QNAME, XMLCDECacheType.class, null, value);
    }

}
