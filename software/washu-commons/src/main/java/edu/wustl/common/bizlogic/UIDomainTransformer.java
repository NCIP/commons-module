/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/catissue-commons-module/LICENSE.txt for details.
 */

package edu.wustl.common.bizlogic;

import edu.wustl.common.domain.AbstractDomainObject;
import edu.wustl.common.domain.UIRepOfDomain;
import edu.wustl.common.factory.AbstractTransformerFactory;

/**
 * In addition to implementing this interface, a "transformer" also has to be
 * annotated with {@link InputUIRepOfDomain} if it wishes to be registered by
 * {@link AbstractTransformerFactory} automatically.
 * 
 * @author srinath_k
 * @param <U> the UI representation of a domain object class D
 * @param <D> the domain object class that's represented by U
 * 
 */
public interface UIDomainTransformer<U extends UIRepOfDomain, D extends AbstractDomainObject> {
    D createDomainObject(U uiRepOfDomain);

    void overwriteDomainObject(D domainObject, U uiRepOfDomain);
}
