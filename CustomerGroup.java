
public class CustomerGroup {
	
	// Attribute of the class
	private String name;
	private String location;

	
	//method to set attributes
public	CustomerGroup(String name, String location) {
		this.name = name;
		this.location = location;

	}
// getters
	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	@Override
	public String toString() {
		return getName();
	}
}
