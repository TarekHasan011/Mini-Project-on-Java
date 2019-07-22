package file_project;

public class Student {
	private String studentId;
	private String studentName;
	private University university;
	
	//getter and setter 
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public University getUniversity() {
		return university;
	}
	public void setUniversity(University university) {
		this.university = university;
	}
	
	//method
	public String getStudentInfo()
	{
		return "studentId:\t" + studentId + "\tstudentName:\t" + studentName + "\t registered in University:\t" + university.getUniversityName();
	}
	
}
