
/**
 * This class deals with the customer details
 * @author Jrosh
 *
 */

public class Customer {
	String customerName;
	String surname;
	int cellNo;
	String emailAd;
	String physAdd;
	String customerId;
	/**
	 * 
	 * @param customerName This is the Customer First name
	 * @param surname  This is the Customer surname
	 * @param cellNo This is the Customers cell number
	 * @param emailAd This is the Customers email address
	 * @param physAdd This is the Customers physical address
	 * @param customerId This is the Customers Identity number
	 */
	public Customer(String customerName, String surname, int cellNo, String emailAd, String physAdd, String customerId) {
		this.customerName = customerName;
		this.surname = surname;
		this.cellNo = cellNo; 
		this.emailAd = emailAd;
		this.physAdd = physAdd;
		this.customerId = customerId;
	}
	/*
	 * toString Method for outputting the customer details as a string
	 */
	
	public String toString() {
		String output = "Customer name: " + customerName + " " + surname;
		output += "\nCellphone number: " + cellNo;
		output += "\nEmail address: " + emailAd;
		output += "\nPhysical address: " + physAdd;
		
		return output;
	}
	public String getEmail() {
		return emailAd;
	}
	public int getNum() {
		return cellNo;
	}
	public String getId() {
		return customerId;
	}
	public  String getName() {
		return customerName;
	}
	public String getSurname() {
		return surname;
		
	}
	public String invoice(int due) {
		
		String output = "Invoice for: " + customerName + surname;
		output += "\nCell Number: " + cellNo;
		output += "\nEmail Address: " + emailAd;
		output += "\nAmount Due: " + due;
		
		return output;
	
	}
	

}
