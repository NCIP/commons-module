/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/commons-module/LICENSE.txt for details.
 */

/**
 * <p>Title: AbstractActionFormFactory Class>
 * <p>Description:	This is an abstract class for the DomainObjectFactory class.</p>
 * Copyright:    Copyright (c) year
 * Company: Washington University, School of Medicine, St. Louis.
 * @author Gautam Shetty
 * @version 1.00
 * Created on April 19, 2006
 */

package edu.wustl.common.factory;

import edu.wustl.common.actionForm.AbstractActionForm;
import edu.wustl.common.domain.AbstractDomainObject;
import edu.wustl.common.domain.UIRepOfDomain;
import edu.wustl.common.exception.ApplicationException;
import edu.wustl.common.exception.AssignDataException;

/**
 * This is an interface for the DomainObjectFactory class.
 * @author prashant_bandal
 */
public interface IDomainObjectFactory
{

	/**
	 * This method returns an AbstractDomain object copy of the form bean object.
	 * @param formType Form bean Id.
	 * @param form Form bean object.
	 * @return an AbstractDomain object copy of the form bean object.
	 * @throws AssignDataException Assign Data Exception.
	 */
	AbstractDomainObject getDomainObject(int formType, AbstractActionForm form)
			throws AssignDataException;

	/**
	 * Returns the fully qualified name of the class according to the form bean type.
	 * @param formType Form bean Id.
	 * @return the fully qualified name of the class according to the form bean type.
	 */
	String getDomainObjectName(int formType);
	/**
	 * Returns the form bean corresponding to the domain object passed
	 * and the operation to be performed.
	 * @param domainObject The domain object whose form bean is required.
	 * @param operation The operation to be performed.
	 * @return the form bean corresponding to the domain object passed
	 * and the operation to be performed.
	 * @throws ApplicationException Application Exception.
	 */
	AbstractActionForm getFormBean(Object domainObject, String operation)
			throws ApplicationException;

	 /**
     * Copies the values from specified UI representation into specified domain
     * object.
     *
     * @param domainObject the domain object to be overwritten
     * @param uiRep the UI representation from which values are to be copied
     *            into <code>domainObject</code>
     * @throws AssignDataException
     */
    void overwriteDomainObject(AbstractDomainObject domainObject, UIRepOfDomain uiRep) throws AssignDataException;

    /**
     * Creates a domain object corresponding to specified UI representation.
     *
     * @param uiRepOfDomain the UI representation from which a domain object is
     *            to be created.
     * @return the domain object corresponding to the specified UI
     *         representation.
     * @throws AssignDataException
     */
    AbstractDomainObject createDomainObject(UIRepOfDomain uiRepOfDomain) throws AssignDataException;
}
