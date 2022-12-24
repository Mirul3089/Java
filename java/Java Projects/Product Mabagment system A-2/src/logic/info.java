package logic;

public class info {
	public static final int SIZEPRODUCT_ID = 25;
	public static final int SIZENAME = 25;
	public static final int SIZEDESCRIPTION = 30;
	public static final int RECORDSIZE = (SIZEPRODUCT_ID + SIZENAME + SIZEDESCRIPTION) * 2 + 4 + 4;
	private String productid;
	private String name;
	private String description;
	private int quantity;
	private int unitprice;
	public String getProduct_id() {
		return productid;
	}
	public void setProduct_id(String Product_id) {
		this.productid = Product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String Name) {
		this.name = Name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String Description) {
		this.description = Description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int Quantity) {
		this.quantity = Quantity;
	}
	public int getUnit_price() {
		return unitprice;
	}
	public void setUnit_price(int Unit_price) {
		this.unitprice = Unit_price;
	}
	public info(String Product_id, String Name, String Description, int Quantity, int Unit_price) {
		this.productid = Product_id;
		this.name = Name;
		this.description = Description;
		this.quantity = Quantity;
		this.unitprice = Unit_price;
	}
	public info() {
		
	}
	@Override
	public String toString() {
		return productid + name + description + quantity + "[" + unitprice +"]";
	}

}
