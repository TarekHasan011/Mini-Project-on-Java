package file_project;

import java.util.LinkedList;
import java.util.Scanner;

public class TestProject {

	private static Scanner myScanner=new Scanner(System.in);
	
	public static void main(String[] args) {
		LinkedList<Enrolled> list=new LinkedList<Enrolled>();
		int n;
		do {
			System.out.print("Want to enroll? :: ");
			n=myScanner.nextInt();
			if(n!=0)
			{
				
				Course course=new Course();
				System.out.print("Enter Course Id: ");
				String idString=myScanner.next();
				System.out.print("Enter Course Name: ");
				String nameString=myScanner.next();
				System.out.print("Enter Course Description: ");
				String coursedescriptionString=myScanner.next();
				
				course.setCourseDescription(coursedescriptionString);
				course.setCourseId(idString);
				course.setCourseName(nameString);
				course.setUniversity(getUniversity());
				
				Student student=new Student();
				System.out.print("Enter Student Name: ");
				nameString=myScanner.next();
				System.out.print("Enter Student Id: ");
				idString=myScanner.next();
				
				student.setStudentId(idString);
				student.setStudentName(nameString);
				student.setUniversity(getUniversity());
				
				Enrolled enrolled=new Enrolled();
				enrolled.setCourse(course);
				enrolled.setStudent(student);
				
				boolean flag=true;
				for (Enrolled enroll : list) {
					if(enroll.getStudent().getStudentName().equals(enrolled.getStudent().getStudentName()) && enroll.getCourse().getCourseName().equals(enrolled.getCourse().getCourseName()))
					{
						if(enroll.getStudent().getUniversity().getUniversityName().equals(enrolled.getStudent().getUniversity().getUniversityName()) && enroll.getCourse().getUniversity().getUniversityName().equals(enrolled.getCourse().getUniversity().getUniversityName()))
						{
							
							System.out.println("You are already enrolled");
							flag=false;
							break;
						}
					}
				}
				if(flag) 
				{
					list.add(enrolled);
					System.out.println(enrolled.getEnrollmentInfo());
				}
			}
		} while (n!=0);
		
	}
	private static University getUniversity()
	{
		University university=new University();
		System.out.print("Enter University Id: ");
		String idString=myScanner.next();
		university.setUniversityId(idString);
		System.out.print("Enter University Name: ");
		String nameString=myScanner.next();
		university.setUniversityName(nameString);
		return university;
	}

}
