import java.util.*;
class Account {
     
	 private int number;
	 private String customer;
	 private String type;
	 private double balance;
     
	 public Account() 
	 {
		 number = 10;
		 customer = "mirul";
		 type= "savings";
		 balance = 10000;
	 }
	 public void display() 
     {
		 System.out.println("Customer number= " +number );
		 System.out.println("Customer account type= " +type );
		 System.out.println("Customer account balance= " +balance);
	 }
	 
	 public Account(int number,String customer,String type,double balance)
	 {
		 this.number = number;
		 this.customer = customer;
		 this.type= type;
		 this.balance = balance;
	 }
	 public Account(int n,String c,String t,float b)
	 {
		number=n;
		customer=c;
		type=t;
		balance=b;
		
	 }
	 public Account(float number,String customer,String type, double balance)
	 {
		 
	 }
	 
	 public int getCustomer() {
		 return number;
	 }
	 public void setCustomer(int number) {
		 this.number=number;
	 }
	 public String getType() {
		 return type;
	 }
	 public void setType(String type)
	 {
		this.type= type;
	 }
	 public String getCustomerName() {
		 return customer;
	 }
	 public void setname(String customer) 
	 {
		 this.customer=customer;
	 }
	 public static void main (String[] args) 
	 { 
	  customer cs= new customer();
	  String bb=cs.getName("Mirul");
	  System.out.println("Customer name: "+bb);
	 }
	 
}


