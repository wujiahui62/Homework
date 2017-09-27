package exercise11_2;

public class Staff extends Employee{
	private String title;
	
	public Staff(String name, String address, String phoneNumber, 
			String emailAddress, String office, double salary, 
			MyDate dateHired, String title){
		super(name, address, phoneNumber, emailAddress, office, salary, dateHired);
		this.setTitle(title);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString(){
		return  "class: Staff" + "\nname: " + getName();
	}
}

