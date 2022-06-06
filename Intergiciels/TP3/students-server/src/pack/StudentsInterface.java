package pack;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/rest")
public interface StudentsInterface {

    @POST
    @Path("/addstudent")
    @Consumes({ "application/json" })
    public Response addStudent(Student s);

    @GET
    @Path("/getstudent")
    @Produces({ "application/json" })
    public Student getStudent(@QueryParam("firstname") String firstname, @QueryParam("lastname") String lastname);

   
    @POST
    @Path("/addrecord")
    @Consumes({ "application/json" })
    public Response addRecord(Record r);

    @GET
    @Path("/getrecord")
    @Produces({ "application/json" })
    public Record getRecord(@QueryParam("ine") String ine);
    
    @GET
	@Path("/createstudent")
    @Produces({ "application/json" })
	public Student CreateStudent(@QueryParam("ine") String ine);

}
