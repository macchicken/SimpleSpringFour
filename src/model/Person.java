package model;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Models a Person who registers.
 * 
 */
public class Person
{
    @NotEmpty(message="You must supply your first name")
	private String firstName;
    private String lastName;
    @NotEmpty(message="You must supply an email address") @Email(message="Please supply a valid email address")
    private String email;
    @Min(value=16, message="You must be 16 or older to register")
    private int age;
    private String id;
    
    public String getFirstName()
    {
        return firstName;
    }

    public Person(String firstName, String lastName, String email, int age,
			String id) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
		this.id = id;
	}

	public Person() {
		super();
	}

	public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge( int age)
    {
        this.age = age;
    }


    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String toString()
    {
        return "First Name: " + getFirstName() + " Last Name:  " + getLastName() + 
        " Email:      " + getEmail() + " Age:      " + getAge() ;
    }
}
