/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/commons-module/LICENSE.txt for details.
 */

package edu.wustl.common.factory;

import edu.wustl.common.bizlogic.UIDomainTransformer;
import edu.wustl.common.domain.AbstractDomainObject;
import edu.wustl.common.domain.UIRepOfDomain;

public interface ITransformerFactory {
    UIDomainTransformer<UIRepOfDomain, AbstractDomainObject> getTransformer(Class<? extends UIRepOfDomain> uiClass);
}
