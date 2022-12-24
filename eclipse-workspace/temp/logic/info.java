package logic;

public class info {
	public static final int SIZE_PRODUCT_ID = 25;
	public static final int SIZE_NAME = 25;
	public static final int SIZE_DESCRIPTION = 30;
	public static final int RECORD_SIZE = (SIZE_PRODUCT_ID + SIZE_NAME + SIZE_DESCRIPTION) * 2 + 4 + 4;
	private String Product_id;
	private String Name;
	private String Description;
	private int Quantity;
	private int Unit_price;
	public String getProduct_id() {
		return Product_id;
	}
	public void setProduct_id(String Product_id) {
		this.Product_id = Product_id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String Description) {
		this.Description = Description;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int Quantity) {
		this.Quantity = Quantity;
	}
	public int getUnit_price() {
		return Unit_price;
	}
	public void setUnit_price(int Unit_price) {
		this.Unit_price = Unit_price;
	}
	public Information(String Product_id, String Name, String Description, int Quantity, int Unit_price) {
		this.Product_id = Product_id;
		this.Name = Name;
		this.Description = Description;
		this.Quantity = Quantity;
		this.Unit_price = Unit_price;
	}
	public Information() {
		
	}
	@Override
	public String toString() {
		return Product_id + Name + Description + Quantity + "[" + Unit_price +"]";
	}

}
