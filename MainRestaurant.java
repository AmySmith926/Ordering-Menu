import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import java.util.stream.Collectors;

public class MainRestaurant {
	final static String filename = "C:\\Users\\amysr\\Dropbox\\My PC (Amy)\\Desktop\\drivers.txt";

	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		// creating customer object
		Customer c = new Customer();
		c.custOrderNum = 1254;// setting the customer order number

		// getting user input
		System.out.println("Enter Your Name");
		c.name = s.nextLine();

		System.out.println("Enter Your ContactNumber");
		c.contactNum = s.nextLine();

		System.out.println("Enter Your Address");
		c.custAddress = s.nextLine();

		System.out.println("Enter Your Location");
		c.location = s.nextLine();

		System.out.println("Enter your Email Address");
		c.custEmail = s.nextLine();

		System.out.println(c);

		Restaurant r = new Restaurant();
		// setting the restaurants details
		r.contactNum = "656165165161";
		r.location = "Cape Town";
		r.name = "Burger Land";

		int menuOption;
		int foodItem = 0;
		s = new Scanner(System.in);
		// customer to enter any special preparations
		System.out.println("Any special Preperations");
		r.specialPreparations = s.nextLine();

		do {
			r.menu();// getting customers choice and quantity
			menuOption = s.nextInt();
			switch (menuOption) {
			case 1:
				foodItem = 1;
				r.itemPrice(foodItem);
				break;
			case 2:
				foodItem = 2;
				r.itemPrice(foodItem);
				break;
			case 3:
				foodItem = 3;
				r.itemPrice(foodItem);
				break;
			case 4:
				Restaurant.done();
				break;

			default:
				System.out.println("Invalid option.");
			}

		} while (Restaurant.ordering);

		{
			// adding the two classes into a list
			List<Combined> users = new ArrayList<Combined>();
			users.add(c);
			users.add(r);

			for (ResInterface u : users) {

				u.combined();

				File fileName = new File("invoice.txt");
				// creating a new file and writing to it.
				try {
					FileWriter fw = new FileWriter(fileName);
					BufferedWriter output = new BufferedWriter(fw);
					for (int i = 0; i < users.size(); i++) {

						output.write(users.get(i).toString());
						output.newLine();
					}
					output.close();

				} catch (FileNotFoundException e) {
					System.out.println("no");
				}

			}
		}

		String filePath = "C:\\Users\\amysr\\Dropbox\\My PC (Amy)\\Desktop\\drivers.txt";
		HashMap<String, String> map = new HashMap<String, String>();

		String line;
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		while ((line = reader.readLine()) != null) {
			String[] parts = line.split(",", 2);
			if (parts.length >= 2 && line.contains(r.location) && r.location.equals(c.location)) {
				String key = parts[0];
				String value = parts[1];
				map.put(key, value);
			} else {
				System.out.println(" " + line);
			}
		}

		for (String key : map.keySet()) {
			System.out.println("Yes the driver is close and will deliver  your meal at" + c.custAddress + " " + key
					+ ":" + map.get(key));
		}
		reader.close();

		Scanner scan = null;
		File f = new File(filename);
		try {
			scan = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
		}

		boolean foundInts = false; // to see if there are any integers

		while (scan.hasNextLine()) {
			String currentLine = scan.nextLine();
			// split into words
			String words[] = currentLine.split(" ");

			// For each word in the line
			for (String string : words) {
				try {
					int total = Integer.parseInt(string);
					total = total + 1;
					foundInts = true;
					System.out.println(+total);
				} catch (NumberFormatException nfe) {
				}
				; // word is not an integer, do nothing
			}
		} // end while

		if (!foundInts)
			System.out.println("No numbers found.");
		else
			System.out.println("The Driver has added your order to his load");

		// close the scanner
		scan.close();

// setting the customer list with names and order numbers
		List<CustomerList> listCustomers = new ArrayList<CustomerList>();
		listCustomers.add(new CustomerList("Joan", 1784));
		listCustomers.add(new CustomerList("Sam", 2345));
		listCustomers.add(new CustomerList("Betty", 6647));
		listCustomers.add(new CustomerList("John", 3325));
		listCustomers.add(new CustomerList("Sally", 1225));
		listCustomers.add(new CustomerList("Brad", 4485));
		listCustomers.add(new CustomerList("Becky", 7841));
		listCustomers.add(new CustomerList("Collin", 0125));
		listCustomers.add(new CustomerList("Mel", 9654));
		listCustomers.add(new CustomerList("Ann", 6547));
		listCustomers.add(new CustomerList("Dennis", 1111));
		listCustomers.add(new CustomerList("Debby", 3254));
		listCustomers.add(new CustomerList("Hank", 0024));
		listCustomers.add(new CustomerList("Fred", 5645));
		listCustomers.add(new CustomerList("Charlie", 1245));

		for (CustomerList o : listCustomers) {
			System.out.println("Unsorted List:" + o);

		}
// sorting the list
		Collections.sort(listCustomers,
				new CustomerArrayList(new CustomerNameComparator(), new CustomerOrderNumComparator()));

		System.out.println("Sorted List:");
		for (CustomerList o : listCustomers) {
			System.out.println(o);

			File fileName = new File("invoice2.txt");

			try {
				FileWriter fw = new FileWriter(fileName);// creating a new file and writing to it.
				BufferedWriter output = new BufferedWriter(fw);
				for (int i = 0; i < listCustomers.size(); i++) {

					output.write(listCustomers.get(i).toString());
					output.newLine();
				}
				output.close();

			} catch (FileNotFoundException e) {
				System.out.println("no file found");
			}
		}

		// setting the customer group with names and locations
		List<CustomerGroup> customer = Arrays.asList(new CustomerGroup("Tom", "Durban"),
				new CustomerGroup("Lisa", "Cape Town"), new CustomerGroup("Mary", "Cape Town"),
				new CustomerGroup("John", "George"), new CustomerGroup("Brad", "Durban"),
				new CustomerGroup("Lucy", "Johannesburg"), new CustomerGroup("Steven", "Durban"),
				new CustomerGroup("James", "George"), new CustomerGroup("Sally", "Cape Town"),
				new CustomerGroup("Frank", "Johannesburg"), new CustomerGroup("Mel", "Durban"));
// mapping customer group to group by location
		Map<String, List<CustomerGroup>> nameByLocation = customer.stream()
				.collect(Collectors.groupingBy(CustomerGroup::getLocation));

		// creating a file to write the list to
		File fileName = new File("invoice3.txt");

		BufferedWriter bf = null;
		;

		try {

			// create new BufferedWriter for the output file
			bf = new BufferedWriter(new FileWriter(fileName));

			// iterate map entries

			for (Entry<String, List<CustomerGroup>> entry : nameByLocation.entrySet()) {
				System.out.println("Customer " + entry.getKey() + " grouped by location " + entry.getValue());

				bf.write(entry.getKey() + ":" + entry.getValue());

				// new line
				bf.newLine();
			}

			bf.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {

				bf.close();
			} catch (Exception e) {
			}
		}
	}

}
