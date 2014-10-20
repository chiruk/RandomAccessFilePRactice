package RandomFile;

public class Student {
	private String first;
	private String last;
	private double GPA;
	private int ID;
	/**
	 * Constructs the student with name, GPA, and student ID.
	 * @param first The first name
	 * @param last The last name
	 * @param GPA The GPA
	 * @param ID The student ID
	 */
	public Student(String first, String last, double GPA, int ID){
		this.first=first;
		this.last=last;
		this.GPA=GPA;
		this.ID=ID;
	}
	
	public String getFirstName(){
		return first;
	}
	
	public String getLastName(){
		return last;
	}
	
	public double getGPA(){
		return GPA;
	}
	
	public int getID(){
		return ID;
	}
}