package exercise11_2;

public class Exercise11_2 {
	public static void main(String[] args){
		Person person = new Person("Fred Green", "9500 South Euclid", 
				"2165869540", "fredgreen@csu.edu");
		Student student = new Student("Anna Sue", "13921 Spring rd", 
				"2142045830", "annasue@csu.edu", "freshman");
		Employee employee = new Employee("Larry White","21904 Winter rd", "2165869540", 
				"larrywhite@csu.edu", "N340", 5000, new MyDate(2013, 10, 31));
		Faculty faculty = new Faculty("Daniel Liang","23143 Briton rd", "2164245633", 
				"danielliang@csu.edu", "F241", 5000, new MyDate(2011, 1, 1),
				"Wed 9:00 - 11:00", "professor");
		Staff staff = new Staff("Mike Lee","312 Woodland rd", "2161245123",
				"mikelee@csu.edu", "N312", 5000, new MyDate(2005, 3, 10), "secretary");
		
		System.out.println(person.toString());
		System.out.println(student.toString());
		System.out.println(employee.toString());
		System.out.println(faculty.toString());
		System.out.println(staff.toString());
	}
}


