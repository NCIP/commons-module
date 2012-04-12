package edu.wustl.common.factory;

import edu.wustl.common.bizlogic.UIDomainTransformer;
import edu.wustl.common.domain.AbstractDomainObject;
import edu.wustl.common.domain.UIRepOfDomain;

public interface ITransformerFactory {
    UIDomainTransformer<UIRepOfDomain, AbstractDomainObject> getTransformer(Class<? extends UIRepOfDomain> uiClass);
}
