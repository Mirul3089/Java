package data;

import Business.person;
import java.io.IOException;
import java.io.RandomAccessFile;

public class randomIO {

	private RandomAccessFile file;
	
	public static int PHONE_SIZE=10;
	public static int FIRSTNAME_SIZE=20;
	public static int LASTNAME_SIZE=25;
	
	
	//Declared fixed size 
	public static int RECORD_SIZE = PHONE_SIZE + FIRSTNAME_SIZE + 
			LASTNAME_SIZE ;
	
	
	public randomIO()
	{
		file = null;
	}
	
	public void open(String fileName) throws IOException { //file permissions
		if(file != null)
			file.close();
		
		file = new RandomAccessFile(fileName,"rw");
	}
	
	public int size() throws IOException {
		return (int) (file.length() / RECORD_SIZE);   //returns the size of file
	}
	
	public person read(int n) throws IOException 
	{                                              //binary read method
		file.seek(n * RECORD_SIZE);
		int recordNumber = file.readInt();
		String  firstName = file.readUTF();
		String lastName = file.readUTF();
		String phone = file.readUTF();
		int age = file.readInt();
		
		return new person(recordNumber, firstName, lastName, phone, age);
	}
	
	
	public int find(int recordNumber) throws IOException //binary find method
	{
		for(int i =0 ; i< size(); i++)
		{
			file.seek(i * RECORD_SIZE);
			int a = file.readInt();
			if( a == recordNumber)
				return i;
		}
		return -1;
	}
	
	public void write(int n, person record ) throws IOException //binary write method
	{
		file.seek(n * RECORD_SIZE);
		file.writeInt(record.getRecordNumber());
		file.writeUTF(record.getFirstName());
		file.writeUTF(record.getLastName());
		file.write(record.getAge());
		file.writeUTF(record.getPhone());
	}
}