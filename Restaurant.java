import java.util.Scanner;

public class Restaurant extends Combined implements ResInterface {

	// Attributes of the class Restaurant
	String specialPraperations;
	static int quantity;
	static double itemPrice;
	static double runningTotal;
	double subTotal;
	public String specialPreparations;

	static boolean ordering = true;

	static Scanner scan = new Scanner(System.in);

	public void menu() {// method for printing out the options
		System.out.println("Welcome \n1. Burger (R52.00) \n2. Pasta (R71.50)\n3. Fish (R100.00) \n4. Done");
		;
	}

	public double itemPrice(int foodItem) {// method to set item with price
		if (foodItem == 1) {

			System.out.println("You've ordered a burger");
			itemPrice = 52.00;
		}
		if (foodItem == 2) {

			System.out.println("You've ordered Pasta");
			itemPrice = 71.50;
		}
		if (foodItem == 3) {

			System.out.println("You've ordered a Fish");
			itemPrice = 100.00;
		}

		quantity();
		return foodItem;
	}

	public static double quantity() {// method to get quantity and multiplying with price
		System.out.println("Enter quantity");
		quantity = (int) scan.nextDouble();
		subTotal(quantity, itemPrice);
		return quantity;

	}

	public static double subTotal(int quantity, double itemPrice) {// method to get sub total
		double subTotal = quantity * itemPrice;
		System.out.println("Subtotal: " + subTotal);
		runningTotal += subTotal;
		return subTotal;
	}

	public static void done() {// method for when the customer is done with the choices
		ordering = false;
		System.out.println(runningTotal);
		System.out.println("Enjoy your meal");
	}

	public Restaurant() {
		this.specialPraperations = "";
	}

	

	public String getSpecialPreparations() {// method to get special preparations
		return this.specialPraperations;
	}
	// method to return object to String type
	public String toString() {
		return "You have ordered from" + " " + name + "\n" + "You ordered " + String.valueOf(quantity) + "\n" +

				"and the price is R" + String.valueOf(itemPrice) + " " + "the total amount will be R"
				+ String.valueOf(runningTotal) + "\n" + "Special Preperations:" + this.specialPreparations + "\n"
				+ "If you need to contact the restaurant their Number is:" +" "+ contactNum;
	}

	@Override
	public void combined() {
		System.out.printf("   ");



	}
}
