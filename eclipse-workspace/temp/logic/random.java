package logic;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import javax.swing.text.JTextComponent;

public class random {
private static File cFile = new File("temporary.data");
	
	public static void addInformation(String Product_id, String Name, String Description, int Quantity, int Unit_price) throws IOException {
		try(DataOutputStream dOUT = new DataOutputStream(new FileOutputStream(cFile, true));){
			writeFixedString(dOUT, Information.SIZE_PRODUCT_ID, Product_id);
			writeFixedString(dOUT, Information.SIZE_NAME, Name);
			writeFixedString(dOUT, Information.SIZE_DESCRIPTION, Description);
			dOUT.writeInt(Quantity);
			dOUT.writeInt(Unit_price);
		}
	}
	
	public static boolean updateInformation(String Product_id, String Name, String Description, int Quantity, int Unit_price) throws IOException {
		try(RandomAccessFile rdFile = new RandomAccessFile(cFile, "rw")){
			int index = findIndex(Product_id);
			if(index > 0) {
				rdFile.seek((index-1) * Information.RECORD_SIZE);
				writeFixedString(rdFile, Information.SIZE_PRODUCT_ID, Product_id);
				writeFixedString(rdFile, Information.SIZE_NAME, Name);
				writeFixedString(rdFile, Information.SIZE_DESCRIPTION, Description);
				rdFile.writeInt(Quantity);
				rdFile.writeInt(Unit_price);
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public static void writeFixedString(DataOutput out, int length, String s) throws IOException{
		for (int i = 0; i < length; i++) {
			if(i < s.length())
				out.writeChar(s.charAt(i));
			else
				out.writeChar(0);
		}
	}
	
	public static int findIndex(String Product_id) throws IOException{
		//boolean check = true;
		int index = 1;
		Information info = null;
		RandomAccessFile rdFile = new RandomAccessFile(cFile, "r");
		int numRecord = getNumberOfRecords();
		while (index <= numRecord) {
			rdFile.seek((index-1) * Information.RECORD_SIZE);
			info = new Information();
			info.setProduct_id(getFixedString(rdFile,Information.SIZE_PRODUCT_ID));
			if (info.getProduct_id().equals(Product_id)) {
				return index;
			}
			else {
				index++;
			}
		}
		return index;
	}
	
	public static boolean checkpID(JTextComponent c) throws IOException{
		boolean check = true;
		int index = 1;
		Information info = null;
		RandomAccessFile rdFile = new RandomAccessFile(cFile, "r");
		int numRecord = getNumberOfRecords();
		while (index <= numRecord) {
			rdFile.seek((index-1) * Information.RECORD_SIZE);
			info = new Information();
			info.setProduct_id(getFixedString(rdFile,Information.SIZE_PRODUCT_ID));
			if (info.getProduct_id().equals(c.getText())) {
				check = false;
				return check;
			}
			else {
				index++;
			}
		}
		return check;
	}
	
	public static Information readInformation(int recordNumber) throws IOException{
		Information info = null;
		try(RandomAccessFile rdFile = new RandomAccessFile(cFile, "r")){
			if(getNumberOfRecords() >= recordNumber) {
				rdFile.seek((recordNumber-1) * Information.RECORD_SIZE);
				info = new Information();
				info.setProduct_id(getFixedString(rdFile, Information.SIZE_PRODUCT_ID));
				info.setName(getFixedString(rdFile, Information.SIZE_NAME));
				info.setDescription(getFixedString(rdFile, Information.SIZE_DESCRIPTION));
				info.setQuantity(rdFile.readInt());
				info.setUnit_price(rdFile.readInt());
			}
		}
		return info;
		
	}
	
	public static int getNumberOfRecords() throws IOException{
		int count = 0;
		try(RandomAccessFile rdFile = new RandomAccessFile(cFile, "r")){
			count = (int)rdFile.length()/Information.RECORD_SIZE;
		}
		return count;
		
	}
	
	public static String getFixedString(DataInput in, int length) throws IOException{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			char c = in.readChar();
			if (c != 0)
				sb.append(c);
		}
		return sb.toString();
	}
	
	public static String checkkeyword(String keyword) throws IOException{
		String output = "";
		int index = 1;
		Information info = null;
		RandomAccessFile rdFile = new RandomAccessFile(cFile, "r");
		int numRecord = getNumberOfRecords();
		while (index <= numRecord) {
			rdFile.seek((index-1) * Information.RECORD_SIZE);
			info = new Information();
			info.setProduct_id(getFixedString(rdFile,Information.SIZE_PRODUCT_ID));
			info.setName(getFixedString(rdFile, Information.SIZE_NAME));
			info.setDescription(getFixedString(rdFile, Information.SIZE_DESCRIPTION));
			info.setQuantity(rdFile.readInt());
			info.setUnit_price(rdFile.readInt());
			if (info.getName().equals(keyword)) {
				output += "Product_id:" + info.getProduct_id() + " Name:" + info.getName() + " Description:" + info.getDescription() + " Quantity:" + info.getQuantity() + " Unit Price:" + info.getUnit_price() + "\n";
				index++;
			}
			else {
				index++;
			}
		}
		return output;
	}
	
	public static String checkPrice(int to, int from) throws IOException{
		String output = "";
		int index = 1;
		Information info = null;
		RandomAccessFile rdFile = new RandomAccessFile(cFile, "r");
		int numRecord = getNumberOfRecords();
		while (index <= numRecord) {
			rdFile.seek((index-1) * Information.RECORD_SIZE);
			info = new Information();
			info.setProduct_id(getFixedString(rdFile,Information.SIZE_PRODUCT_ID));
			info.setName(getFixedString(rdFile, Information.SIZE_NAME));
			info.setDescription(getFixedString(rdFile, Information.SIZE_DESCRIPTION));
			info.setQuantity(rdFile.readInt());
			info.setUnit_price(rdFile.readInt());
			if ((info.getUnit_price() >= to) && (info.getUnit_price() <= from)) {
				output += "Product_id:" + info.getProduct_id() + " Name:" + info.getName() + " Description:" + info.getDescription() + " Quantity:" + info.getQuantity() + " Unit Price:" + info.getUnit_price() + "\n";
				index++;
			}
			else {
				index++;
			}
		}
		return output;
	}
	
}
