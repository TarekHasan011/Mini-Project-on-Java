package file_project;

public class Course {
	private String courseId;
	private String courseName;
	private String courseDescription;
	private University university;
	
	//getter and setter
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName(){
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public University getUniversity() {
		return university;
	}
	public void setUniversity(University university) {
		this.university = university;
	}
	
	//method
	public String getCourseInfo()
	{
		return "courseId:\t" + courseId + "\tcourseName:\t" + courseName + "\tcourseDescription\t" + courseDescription + "\tCourseOfferedBy\t" + university.getUniversityName();
	}
	
	
}
