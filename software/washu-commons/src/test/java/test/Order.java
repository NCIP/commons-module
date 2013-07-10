/*L
 * Copyright Washington University in St. Louis, SemanticBits, Persistent Systems, Krishagni.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/commons-module/LICENSE.txt for details.
 */

package test;

/**
 * @author kalpana_thakur
 *
 */
public class Order
{
	/**
	 * id.
	 */
    private Long id;

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
	 * user.
	 */
	private User user;


	/**
	 * user.
	 * @return user
	 */
	public User getUser()
	{
		return user;
	}

	/**
	 * user.
	 * @param user user
	 */
	public void setUser(User user)
	{
		this.user = user;
	}

	/**
	 * @return identifier.
	 */
    public Long getId()
    {
		return id;
	}

    /**
	 * @param identifier :
	 */
	public void setId(Long identifier)
	{
		this.id = identifier;
	}


}
