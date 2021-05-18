
public class CustomerList {

	String name;
	int orderNum;
	

	public CustomerList(String name, int orderNum) {
		this.name = name;
		this.orderNum = orderNum;

	}
	// getters 

	public String getName() {
		return this.name;

	}

	public int getOrderNum() {
		return this.orderNum;
	}

	
	// method to return object to String type
	public String toString() {
		return String.format("%s\t%s", name, orderNum);
	}

}
