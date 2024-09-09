
public class CustomerModel {
	String name,phoneno,email,password,location;
	int id;

	public CustomerModel() {
		super();
	}

	public CustomerModel(String name, String phoneno, String email,String location, String password) {
		super();
		this.name = name;
		this.phoneno = phoneno;
		this.email = email;
		this.location=location;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "CustomerModel [name=" + name + ", phoneno=" + phoneno + ", email=" + email + ", password=" + password
				+ ", location=" + location + "]";
	}

	

	
	
	

}
