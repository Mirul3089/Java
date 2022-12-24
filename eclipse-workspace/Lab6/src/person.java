import java.util.*;
public class person {

	String firstName,lastName;
	int age;
	
public String getFirstName() 
{
	return this.firstName;
}
public String getLastName() 
{
	return this.lastName;
}

public int getAge() 
{
	return this.age;
}
public void setFirstName(String firstName) 
{
	this.firstName=firstName;
}
public void setLastName(String lastName) 
{
	this.lastName=lastName;
}
public void setAge(int age) 
{
	if(age<0 || age>100)
	{
		setAge(0);
	}
	else 
	{
		this.age=age;
	}
	 
}
public boolean isTeen() 
{
	if(age>12 && age<20) {
		return true;
	}
	else 
	{
		return false;
	}
}
public String getFullName() 
{
	if(firstName.isEmpty() && lastName.isEmpty()) 
	{
		return "";
	}
	else if(lastName.isEmpty()) {
		return firstName;
	}
	else if(firstName.isEmpty()) {
		return lastName;
	}
	else {
		return firstName + lastName;
	}
}
public static void main(String[]args) 
{
}
}



