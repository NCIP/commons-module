package test;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author kalpana_thakur
 *
 */
public class Person
{
	/**
	 * id.
	 */
    private Long id;

    /**
     * name.
     */
    private String name;


    /**
     * The address of the site.
     */
	private Address address;


	/**
	 * person's order collection.
	 */
	private Collection<Object> orderCollection = new HashSet<Object>();

    /**
     * @return collection of orders.
     */
    public Collection<Object> getOrderCollection()
    {
		return orderCollection;
	}

	/**
	 * @param orderCollection :
	 */
	public void setOrderCollection(Collection<Object> orderCollection)
	{
		this.orderCollection = orderCollection;
	}

	/**
     *@return person name.
     */
    public String getName()
	{
		return name;
	}

    /**
     * @param name : name of person
     */
	public void setName(String name)
	{
		this.name = name;
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



	/**
	 * Returns the address.
	 * @return Address
	*/
	public Address getAddress()
	{
		return address;
	}

	/**
	 * Sets the address.
	 * @param address address
	 */
	public void setAddress(Address address)
	{
		this.address = address;
	}


}

