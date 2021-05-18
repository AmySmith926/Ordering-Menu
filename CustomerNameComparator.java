import java.util.Comparator;

public class CustomerNameComparator implements Comparator<CustomerList> {

	// Overriding the Comparator interface to compare the names
	@Override

	public int compare(CustomerList o1, CustomerList o2) {

		return o1.getName().compareTo(o2.getName());
	}

}
