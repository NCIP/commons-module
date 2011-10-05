package test;

/**
 * @author kalpana_thakur
 *
 */

public class Address
{
	/**
	 * identifier.
	 */
    private Long id;

    /**
	 * street.
	 */
	private String street;


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

	/**
	 * @return street.
	 */
	public String getStreet()
	{
		return street;
	}
	/**
	 * @param street :
	 */
	public void setStreet(String street)
	{
		this.street = street;
	}


}
