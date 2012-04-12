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
