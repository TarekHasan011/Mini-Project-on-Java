package file_project;

public class Enrolled {
	private Student student;
	private Course course;
	
	//getter and setter 
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	//method
	public String getEnrollmentInfo()
	{
		return student.getStudentName() + "\t is enrolled in course\t" + course.getCourseName() + "\t offered by\t" + course.getUniversity().getUniversityName();
	}
}
