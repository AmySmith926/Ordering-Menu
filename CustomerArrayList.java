import java.util.Arrays;

import java.util.Comparator;
import java.util.List;

public class CustomerArrayList implements Comparator<CustomerList> {

	// creating list comparator
	private List<Comparator<CustomerList>> listComparators;

	@SafeVarargs // setting Arraylist to list
	public CustomerArrayList(Comparator<CustomerList>... comparators) {
		this.listComparators = Arrays.asList(comparators);
	}

	// comparing CustomerList class
	public int compare(CustomerList o1, CustomerList o2) {
		for (Comparator<CustomerList> comparator : listComparators) {

			int result = comparator.compare(o1, o2);
			if (result != 0) {
				return result;
			}
		}
		return 0;
	}

}
