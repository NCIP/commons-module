/**
 * 
 */
package edu.wustl.common.testdomain;


/**
 * @author shrishail_kalshetty
 *
 */
public class UserRole
{
	/**
	 * Default Serial Id.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Identifier
	 */
	private Long identifier ;
	/**
	 * User object.
	 */
	private User user ;
	/**
	 * @return the identifier
	 */
	public Long getIdentifier()
	{
		return identifier;
	}
	/**
	 * @param identifier the identifier to set
	 */
	public void setIdentifier(Long identifier)
	{
		this.identifier = identifier;
	}
	/**
	 * @return the user
	 */
	public User getUser()
	{
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user)
	{
		this.user = user;
	}
	/**
	 * @return Long id.
	 */
	public Long getId()
	{
		// TODO Auto-generated method stub
		return getIdentifier();
	}
}
