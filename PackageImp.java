import java.sql.SQLException;
import java.util.*;

public class PackageImp {

	public static void main(String[] args) throws SQLException, InterruptedException {
		Scanner sc =new Scanner(System.in);
		int ch;
		List<String> arr=new ArrayList<>();
		CustomerDAO cusdetails=new CustomerDAO();
		DeliveryBoyDAO deldetails=new DeliveryBoyDAO();
		ProductDAO productdet=new ProductDAO();
		OrderDAO orderdet=new OrderDAO();
		do {
			System.out.println("1.Customer"); 
			System.out.println("2.DeliveryBoy");
			
			System.out.println("3.Exit...");
			System.out.print("Enter your Roll: ");
			ch=sc.nextInt();
			switch(ch){
			case 1:
				
				System.out.println("\t\t\t\tWelcome Customer");
				int cuslogin;
				do {
				System.out.println("1.Login");
				System.out.println("2.Sign in");
				System.out.println("3.Back");
				System.out.print("Enter your choice :");
				 cuslogin=sc.nextInt();
				
				switch(cuslogin) {
				case 1:
					
					
					System.out.println("Enter UserName: ");
					String name=sc.next();
					
					System.out.println("Enter Password");
					String pass=sc.next();
					CustomerModel cus=new CustomerModel();
					if(cusdetails.login(name, pass)) {
						int cho1;
					do {
						System.out.println("1.Order");
						System.out.println("2.View Account Details");
						System.out.println("3.View Order Details");
						System.out.println("4.Delete Account");
						System.out.println("5.Back");
						cho1=sc.nextInt();
						switch(cho1) {
						case 1:
							productdet.getAllItem();
							System.out.print("Enter the Product ID to Order: ");
							int proid=sc.nextInt();
							System.out.print("Enter your Location: ");
							String locate=sc.next();
							orderdet.getProduct(proid);
							orderdet.getCustomer(name);
							OrderModel order=new OrderModel();
							
							orderdet.insertOrder(order,locate,name,proid);
							break;
						case 2: 
							int id=cusdetails.getCustomer_Id(name, pass);
							cusdetails.getCustomer(id);
							break;
						case 3:
							int cus1_id=cusdetails.getCustomer_Id(name, pass);
							orderdet.getOrder(cus1_id);
							System.out.println("Enter order_Id");
							int order_id=sc.nextInt();
							for(int i=0;i<arr.size();i++) {
								System.out.println(""+arr.get(i));
								System.out.println("\t.");
								System.out.println("\t.");
								System.out.println("\t.");
								System.out.println("\t⌄");

								Thread.sleep(2000);
								
								}
								System.out.println("Product reached");
							
							break;
						case 4:
							System.out.println("Enter Delete Customer Id: ");
							int cus_id=cusdetails.getCustomer_Id(name, pass);
//							System.out.println(cus_id);
							if(cusdetails.delete_cus(cus_id))
								System.out.println("Account Deleted");
							else
								System.out.println("Account Not Found");
							cho1=5;
							break;
						}
						
					}while(cho1!=5);
					}
					else {
						System.out.println("Login failed");
					}
					
							
					break;
				case 2:
					System.out.print("Enter name: ");
					String username=sc.next();
					System.out.print("Enter PhoneNo: ");
					String phone=sc.next();
					System.out.print("Enter Email: ");
					String email=sc.next();
					System.out.print("Enter Location: ");
					String location=sc.next();
					System.out.print("Enter Password: ");
					String password=sc.next();
					CustomerModel customer=new CustomerModel(username,phone,email,location,password);
					cusdetails.insertCus(customer);
					break;
				}
				}while(cuslogin!=3);
				break;
			case 2:
				System.out.println("\t\t\t\tWelcome DeliverBoy");
				int dellogin;
				do {
				System.out.println("1.Login");
				System.out.println("2.Sign in");
				System.out.println("3.Back");
				System.out.println("Enter Your Choice :");
				 dellogin=sc.nextInt();
				
				switch(dellogin) {
				case 1:
					System.out.println("Enter UserName: ");
					String name=sc.next();
					System.out.println("Enter Password");
					String pass=sc.next();
					if(deldetails.login(name, pass)) {
						int cho2;
						do {
							System.out.println("1.Update Location");
							System.out.println("2.View Account Details");
							System.out.println("3.Delete Account");
							System.out.println("4.Back...");
							System.out.print("Enter your choice: ");
							cho2=sc.nextInt();
							switch(cho2) {
							case 1:
								orderdet.getOrder_del();
								System.out.print("Enter Order_Id: ");
								int order_id=sc.nextInt();
								
								System.out.print("Enter Current Location: ");
								String locat=sc.next();
								
								orderdet.updateUser( order_id,locat);
								
								break;
							case 2:
								int id=deldetails.getdeliver_Id(name, pass);
								deldetails.getDeliver(id);
								break;
							case 3:
								System.out.println("Delete your Account :");
								int del_id=deldetails.getdeliver_Id(name, pass);
								
								if(deldetails.delete_del(del_id))
									System.out.println("Account Deleted");
								else
									System.out.println("Account Not Found");
								cho2=4;
								break;
							}
						}while(cho2!=4);
					}
					else {
						System.out.println("Login Failed");
					}
					
							
					break;
				case 2:
					System.out.print("Enter Your Name: ");
					String username=sc.next();
					System.out.print("Enter PhoneNo: ");
					String phone=sc.next();
					System.out.print("Enter Email: ");
					String email=sc.next();
					System.out.print("Enter Password: ");
					String password=sc.next();
					DeliveryBoyModel delivery=new DeliveryBoyModel(username,phone,email,password);
					deldetails.insertDel(delivery);				
					break;
				}
				}while(dellogin!=3);
				break;
			}
		}while(ch!=3);
		for(int i=0;i<3;i++) {
			System.out.println("Exit...");
			Thread.sleep(1000);
		}
	}
}
