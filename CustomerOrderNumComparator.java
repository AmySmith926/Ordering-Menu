import java.util.Comparator;

public   class CustomerOrderNumComparator implements Comparator<CustomerList> {

	//Overriding the Comparator Interface to get orderNum to compare
	@Override
	public int compare(CustomerList o1, CustomerList o2) {
		
		return o1.getOrderNum()-o2.getOrderNum();
	}
	

}
