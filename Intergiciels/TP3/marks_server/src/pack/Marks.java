package pack;

import java.lang.reflect.Method;
import java.util.Hashtable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

@Path("/rest")
public class Marks {
	 
    static final String path = "http://localhost:8080/students-server"; 

    static ResteasyClient client = new ResteasyClientBuilder().build();
    static ResteasyWebTarget target = client.target(UriBuilder.fromPath(path));
    static StudentsInterface proxy = target.proxy(StudentsInterface.class);
    private static String capitalize(final String line) {
		return Character.toUpperCase(line.charAt(0)) + line.substring(1);
	}
		@GET
		@Path("/getmark")
		@Produces({ "application/json" })
		public Response getMark(@QueryParam("firstname") String firstname, @QueryParam("lastname") String lastname, @QueryParam("lecture") String matiere) {
	        Student s = proxy.getStudent(firstname,lastname);
	        Record r = proxy.getRecord(s.getINE());
	        try {
	        	Method m = r.getClass().getMethod("get"+capitalize(matiere));
		        String note = (String) m.invoke(r);
		        return Response.status(200).entity(note).build();
	        }catch (Exception e) {
	        	System.out.println("La matiere donné n'existe pas");
		        return null;
	        }
		}

}
