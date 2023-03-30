
public class Student {

	//create a Student with name, height, age, course
	static String name;
	static String height;
	static String age;
	static String course;
	
	Student(String name, String height, String age, String course){
		this.name = name;
		this.height = height;
		this.age = age;
		this.course = course;
	}
	
	public String getName() {
		return name;
	}
	
	public String getHeight() {
		return height;
	}
	
	public String getAge() {
		return age;
	}
	
	public String getCourse() {
		return course;
	}
	
}
