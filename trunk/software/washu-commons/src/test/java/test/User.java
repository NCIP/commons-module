
package test;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author kalpana_thakur
 *
 */

public class User
{
	/**
	 * id.
	 */
    private Long id;
    /**
	 * lastName.
	 */
    private String lastName;
    /**
	 * firstName.
	 */
    private String firstName;
    /**
	 * emailAddress.
	 */
    private String emailAddress;
    /**
	 * activityStatus.
	 */
    private String activityStatus;
    /**
     * Role of the User
     */
    private Collection<Object> roleCollection = new HashSet<Object>() ;
    /**
     * @return activityStatus
     */
    public String getActivityStatus()
    {
		return activityStatus;
	}

	/**
	 * @param activityStatus : Activity status.
	 */
	public void setActivityStatus(String activityStatus)
	{
		this.activityStatus = activityStatus;
	}

	

    /**
     * @return emailAddress
     */
    public String getEmailAddress()
    {
        return emailAddress;
    }

    /**
     * @param emailAddress :
     */
    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    /**
     * @return firstName
     */
    public String getFirstName()
    {
        return firstName;
    }
    /**
     * @param firstName :
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    /**
     * @return lastName
     */
    public String getLastName()
    {
        return lastName;
    }
    /**
     * @param lastName :
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    /**
	 * @return the roleCollection
	 */
	public Collection<Object> getRoleCollection()
	{
		return roleCollection;
	}
	/**
	 * @param roleCollection the roleCollection to set
	 */
	public void setRoleCollection(Collection<Object> roleCollection)
	{
		this.roleCollection = roleCollection;
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
	 * orderCollection.
	 */
	 private Collection<Object> orderCollection = new HashSet<Object>() ;

	 /**
	  * orderCollection.
	  * @return orderCollection
	  */
	 public Collection<Object> getOrderCollection()
	 {
		return orderCollection;
	 }

	 /**
	  * orderCollection.
	  * @param orderCollection orderCollection
	  */
	public void setOrderCollection(Collection<Object> orderCollection)
	{
		this.orderCollection = orderCollection;
	}


}