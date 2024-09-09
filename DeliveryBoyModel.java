
public class DeliveryBoyModel {
	String name,phoneno,email,password,location;

	public DeliveryBoyModel() {
		super();
	}

	public DeliveryBoyModel(String name, String phoneno, String email, String password) {
		super();
		this.name = name;
		this.phoneno = phoneno;
		this.email = email;
		this.password = password;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "DeliverBoyModel [name=" + name + ", phoneno=" + phoneno + ", email=" + email + ", password=" + password
				+ "]";
	}
	
}
