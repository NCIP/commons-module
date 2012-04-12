package edu.wustl.common.testdomain;

import java.util.Collection;



/**
 * @author kalpana_thakur
 *
 */

public class Address
{
	/**
	 * Default Serial Version Id.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * identifier.
	 */
    private Long identifier;

    /**
	 * street.
	 */
	private String street;


    /**
	 * @return identifier.
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
	/**
	 * @return Id.
	 */
	public Long getId()
	{
		// TODO Auto-generated method stub
		return getIdentifier();
	}
	/**
	 *
	 * @return orderCollection
	 */
	public Collection<Object> getOrderCollection()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
