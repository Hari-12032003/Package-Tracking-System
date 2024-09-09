
public class OrderModel {
	int order_id,cus_id,product_id,product_amount;
	String name,product_name,product_order_location,product_curr_location;
	public OrderModel() {
		super();
	}
	public OrderModel( String product_order_location, String product_curr_location) {
		super();
		this.product_order_location = product_order_location;
		this.product_curr_location = product_curr_location;
	}
	@Override
	public String toString() {
		return "OrderModel [order_id=" + order_id + ", cus_id=" + cus_id + ", product_id=" + product_id
				+ ", product_amount=" + product_amount + ", name=" + name + ", product_name=" + product_name
				+ ", product_order_location=" + product_order_location + ", product_curr_location="
				+ product_curr_location + "]";
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getCus_id() {
		return cus_id;
	}
	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getProduct_amount() {
		return product_amount;
	}
	public void setProduct_amount(int product_amount) {
		this.product_amount = product_amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_order_location() {
		return product_order_location;
	}
	public void setProduct_order_location(String product_order_location) {
		this.product_order_location = product_order_location;
	}
	public String getProduct_curr_location() {
		return product_curr_location;
	}
	public void setProduct_curr_location(String product_curr_location) {
		this.product_curr_location = product_curr_location;
	}
	
	
}
