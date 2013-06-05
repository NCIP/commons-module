/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/catissue-commons-module/LICENSE.txt for details.
 */

package edu.wustl.common.testdomain;




/**
 * @author kalpana_thakur
 *
 */
public class Order
{
	/**
	 * Default Serial Version Id.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * id.
	 */
    private Long identifier;

    /**
	 * Person.
	 */
	private Person person;


    /**
     * @return person
     */
    public Person getPerson()
    {
		return person;
	}

	/**
	 * @param person person.
	 */
	public void setPerson(Person person)
	{
		this.person = person;
	}

	/**
	 * @return : identifier
	 */
	public Long getIdentifier()
	{
		return identifier;
	}

	/**
	 * @param identifier :
	 */
	public void setIdentifier(Long identifier)
	{
		this.identifier = identifier;
	}
	/**
	 * @return id.
	 */
	public Long getId()
	{
		// TODO Auto-generated method stub
		return getIdentifier();
	}
}
