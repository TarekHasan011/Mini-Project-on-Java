package file_project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.NonWritableChannelException;
import java.util.LinkedList;

public class RunFile {

	public static LinkedList<University> universities=new LinkedList<University>();
	public static LinkedList<Course> courses=new LinkedList<Course>();
	public static LinkedList<Student> students=new LinkedList<Student>();
	
	public static void WriteInFile()
	{
		LinkedList<Enrolled> list=new LinkedList<Enrolled>();
		try {
			FileWriter writer=new FileWriter("Output.txt");
			
			for(int i=0,j=0;i!=students.size();i++,j++)
			{
				Enrolled enrolled=new Enrolled();
				enrolled.setStudent(students.get(i));
				if(j==courses.size())	j=0;
				enrolled.setCourse(courses.get(j));
				
				boolean flag=true;
				
				for (Enrolled enroll : list) {
					if(enroll.getStudent().getStudentName().equals(enrolled.getStudent().getStudentName()) && enroll.getCourse().getCourseName().equals(enrolled.getCourse().getCourseName()))
					{
						if(enroll.getStudent().getUniversity().getUniversityName().equals(enrolled.getStudent().getUniversity().getUniversityName()) && enroll.getCourse().getUniversity().getUniversityName().equals(enrolled.getCourse().getUniversity().getUniversityName()))
						{
							
							writer.write("Already Enrolled\n");
							flag=false;
							break;
						}
					}
				}
				if(flag) 
				{
					list.add(enrolled);
					writer.write(enrolled.getEnrollmentInfo()+"\r\n");
				}
				
			}
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void ReadFromFile()
	{
		try {
			BufferedReader br=new BufferedReader(new FileReader("input.txt"));
			String s=br.readLine();
			int i=0,j=0;
			while(s!=null)
			{
				boolean flag=true;
				String ar[]=s.split(" ");
				if(ar.length==3)
				{
					Course course=new Course();
					course.setCourseId(ar[0]);
					course.setCourseName(ar[1]);
					course.setCourseDescription(ar[2]);
					if(j==universities.size()) j=0;
					course.setUniversity(universities.get(j++));
					courses.add(course);
				}
				else
				{
					try {
						int n=Integer.parseInt(ar[0]);
					} catch (Exception e) {
						flag=false;
					}
					if(flag)
					{
						Student student=new Student();
						student.setStudentId(ar[0]);
						student.setStudentName(ar[1]);
						if(i==universities.size()) i=0;
						student.setUniversity(universities.get(i++));
						students.add(student);
					}
					else {
						University university=new University();
						university.setUniversityName(ar[0]);
						university.setUniversityId(ar[1]);
						universities.add(university);
					}
				}
				s=br.readLine();
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ReadFromFile();
		WriteInFile();
	}

}
