import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import pack.Student;
import pack.StudentsInterface;

public class MyClient {
	public static void main(String args[]) {
		  
        final String path = "http://localhost:8080/students-server"; 

        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(UriBuilder.fromPath(path));
        StudentsInterface proxy = target.proxy(StudentsInterface.class);

        Student p = proxy.getStudent("Alain","Tchana");
        System.out.println("fisrtname : " + p.getFirstname() + " lastname : "+ p.getLastname());
    }
}
