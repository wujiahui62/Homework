package exercise11_2;

public class Faculty extends Employee{
	private String officeHours;
	private String rank;
	
	public Faculty(String name, String address, String phoneNumber, 
			String emailAddress, String office, double salary, 
			MyDate dateHired, String officeHour, String rank){
		super(name, address, phoneNumber, emailAddress, office, salary, dateHired);
		this.officeHours = officeHour;
		this.rank = rank;
	}
	
	public String getOfficeHours() {
		return officeHours;
	}

	public void setOfficeHours(String officeHours) {
		this.officeHours = officeHours;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	@Override
	public String toString(){
		return  "class: Faculty" + "\nname: " + getName();
	}
}
