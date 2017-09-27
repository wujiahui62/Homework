package exercise11_2;

public class Student extends Person{
	private final String CLASS_STATUS;
	
	public Student(String name, String address, String phoneNumber, 
			String emailAddress, String CLASS_STATUS){
		super(name, address, phoneNumber, emailAddress);
		this.CLASS_STATUS = CLASS_STATUS;
	}
	
	public String getCLASS_STATUS() {
		return CLASS_STATUS;
	}
	
	@Override
	public String toString(){
		return  "class: Student" + "\nname: " + getName();
	}
}

