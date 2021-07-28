import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class studentMackup {
	List<Student>students = new ArrayList<Student>(); 
	
	public List<Student> getStudent(){
	
	Student student1 = new Student("Deepak","kumar");
	Student student2 = new Student("Arun","kumar");
	Student student3 = new Student("Vivik","kumar");
	Student student4 = new Student("Krishana","kumar");
	return Arrays.asList(student1,student2,student3,student4);
}
	//select  data 
	public List<Student> getStudent1() throws SQLException {
		List<Student>students = new ArrayList<Student>(); 
		ResultSet result = getConnection().createStatement().executeQuery("selected * from student");
		while(result.next())
		{
			Student stu = new Student();
			stu.setFirstname(result.getString(2));
			stu.setLastname(result.getString(3));
			Student.add(stu);
		
					
		}
		return students;
	}

	public Student getStudent(String name) 
	{
		return Student.Stream().filter(P-> p.getFristName().equals(name)).findany().orElse(null));
	}
	// insert data 
	public void  CreatedStudent(Student student) throws Exception {
	PreparedStatement ps = getConnection().prepareStatement("insert into student{FirstName,LastName} Valuse = ?");
		ps.setString(1,student.getFirstname());
		ps.setString(2,student.getLastname());
		ps.executeUpdate();
	}
	// Update 
	public void  UpdateStudent(Student student) throws Exception  { 
		PreparedStatement ps = getConnection().prepareStatement("Update set  student LastirstName = ? where  firstname=?");
			ps.setString(1,student.getFirstname());
			ps.setString(2,student.getLastname());
			int count = ps.executeUpdate();
			System.out.println("Upadte count:"+count);
			
		}
	//Delete 
	public void  dropStudent(String name) throws Exception  { 
		PreparedStatement ps = getConnection().prepareStatement("delete from student firstname=?");
			ps.setString(1, name);
			int count = ps.executeUpdate();
			System.out.println("Upadte count:"+count);
			
		}
		public  Connection  getConnection() throws SQLException 
		{
			Connection con = null;
			try {
			 Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:Mysql://localhost:80007/student","admin","admin");
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
				
			}
			return con;
		}
		
	}
}