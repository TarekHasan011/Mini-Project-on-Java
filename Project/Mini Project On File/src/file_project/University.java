package file_project;

public class University {
	private String UniversityId;
	private String UniversityName;
	
	//setter and getter
	public String getUniversityId() {
		return UniversityId;
	}
	
	public void setUniversityId(String universityId) {
		UniversityId = universityId;
	}
	public String getUniversityName() {
		return UniversityName;
	}
	public void setUniversityName(String universityName) {
		UniversityName = universityName;
	}
	
	//method
	public String getUniversityInfo()
	{
		return "universityId:\t"+UniversityId+"\tuniversityName:\t"+UniversityName;
	}
	
}
