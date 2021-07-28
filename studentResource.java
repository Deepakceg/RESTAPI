import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/studentservice")
public class studentResource<StudentMokup> 
{
  StudentMokup mokup = new StudentMokup();
  
	@GET
	@produces(MediaType.APPLICATION_ATOM_XML)
public Student<Student> getstudent() throws SQLException
	{
	 return mokup.getStudent();
   }
	@POST
	@produces({MediaType.APPLICATION_ATOM_XML})
	public studentResource(Student:s) throws SQLException{
	mokup.createStudent(s);
		return s;
	}
	@PUT
	@path("StudentAPI/{name}");
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML})
	public UpdateStudent(Student:s)  throws SQLException{
	mokup.Update(s);
		return s;
    }
	//Delete
	@DELETE
	@path("StudentAPI/{name}");
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML})
	public void DropStudent(@pathParam("name") String name) Student:s) throws SQLException{
	 mokup.drop(name);  
	}
}
}

