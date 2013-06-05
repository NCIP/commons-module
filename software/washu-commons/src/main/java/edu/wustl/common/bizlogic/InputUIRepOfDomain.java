/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/catissue-commons-module/LICENSE.txt for details.
 */

package edu.wustl.common.bizlogic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import edu.wustl.common.domain.UIRepOfDomain;
import edu.wustl.common.factory.AbstractTransformerFactory;

/**
 * Specifies which {@link UIRepOfDomain} is being transformed by a
 * {@link UIDomainTransformer}. This is used by
 * {@link AbstractTransformerFactory} in auto-detecting transformers.
 * 
 * @see AbstractTransformerFactory
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface InputUIRepOfDomain {
    Class<? extends UIRepOfDomain> value();
}
