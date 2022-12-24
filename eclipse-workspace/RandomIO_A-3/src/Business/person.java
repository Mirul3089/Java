package Business;

public class person {
	
	 private int recordNumber;
	    private String firstName;
	    private String lastName;
	    private String phone;
	    private int age;
	    
	    public person(int recordnumber, String firstname, String lastname, String phone, int age) {
	        this.recordNumber = recordnumber;
	        this.firstName = firstname;
	        this.lastName = lastname;
	        this.phone = phone;
	        this.age = age;
	    }
	    
	    //getters and setters
	    
	    public int getAge() {
	        return age;
	    }
	    
	    public void setAge(int age) {
	        this.age = age;
	    }
	    
	    public String getPhone() {
	        return phone;
	    }
	    
	    public void setPhone(String phone) {
	        this.phone = phone;
	    }
	    
	    public String getLastName() {
	        return lastName;
	    }
	    
	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }
	    
	    public String getFirstName() {
	        return firstName;
	    }
	    
	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }
	    
	    public int getRecordNumber() {
	        return recordNumber;
	    }
	    
	    public void setRecordNumber(int recordNumber) {
	        this.recordNumber = recordNumber;
	    }
	    
	    @Override
	    public String toString() {
	        return "Person{" + "recordNumber=" + recordNumber + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", age=" + age + '}';
	    }

}
