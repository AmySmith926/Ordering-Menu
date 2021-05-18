
public class Customer extends Combined implements ResInterface {
// Attributes of the customer class 
	int custOrderNum;
	String custAddress;

	String custEmail;

// method to set current details
	public Customer() {
		this.custOrderNum = 000;

		this.custAddress = "";

		this.custEmail = "";
	}

// method to get order number
	public int getCustOrderNum() {
		return this.custOrderNum;
	}

// method to set order number
	public void setCustOrderNum(int custOrderNum) {
		this.custOrderNum = custOrderNum;
	}

// method to get address
	public String getCustAddress() {
		return this.custAddress;
	}

// method to get email
	public String getCustEmail() {
		return this.custEmail;
	}

// method to return object to String type
	public String toString() {

		return "Customer Order Number:" + this.getCustOrderNum() + "\n" + "Customer Name:" + name + "\n"
				+ "Customer Contact Number:" + contactNum + "\n " + " Location:" + location + "\n "
				+ "Customer Address:" + this.getCustAddress() + "\n" + "Customer Email Address:" + this.getCustEmail()
				+ "\n ";

	}

	@Override
	public void combined() {

		System.out.println("");

	}

}
