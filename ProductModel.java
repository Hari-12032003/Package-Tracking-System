
public class ProductModel {
	String pro_name;
	int pro_id,pro_Amount;
	public ProductModel() {
		super();
	}
	public ProductModel(String pro_name, int pro_Amount) {
		super();
		this.pro_name = pro_name;
		this.pro_Amount = pro_Amount;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public int getPro_id() {
		return pro_id;
	}
	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}
	public int getPro_Amount() {
		return pro_Amount;
	}
	public void setPro_Amount(int pro_Amount) {
		this.pro_Amount = pro_Amount;
	}
	@Override
	public String toString() {
		return "ProductModel [pro_name=" + pro_name + ", pro_id=" + pro_id + ", pro_Amount=" + pro_Amount + "]";
	}
	
	
}
