package at.htl.graveyard.boundary;

import at.htl.graveyard.control.EmployeeRepository;
import at.htl.graveyard.entity.Employee;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("Employee")
public class EmployeeEndpoint {
    @Inject
    EmployeeRepository employeeRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(Employee employee){
        Employee employee1 = employeeRepository.save(employee);
        return Response
                .status(Response.Status.OK)
                .header("created", employee1)
                .build();
    }

    @DELETE
    @Path("delete/{id}")
    @Transactional
    public Response delete(@PathParam("id") long id){
        employeeRepository.delete(id);
        return Response
                .status(Response.Status.OK)
                .build();
    }

    @PUT
    @Transactional
    @Path("/put")
    public Response update(Employee employee){
        Employee employee1 = new Employee();
        employee1.setFirstname(employee.getFirstname());
        employee1.setLastname(employee.getLastname());
        employee1.setAddress(employee.getAddress());
        employeeRepository.save(employee1);

        return Response
                .status(Response.Status.OK)
                .header("updated", employee1)
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/findAll")
    public Response findAll(){
        final List<Employee> employeeList = employeeRepository.findAllEmployees();
        return Response
                .status(Response.Status.OK)
                .header("GET", employeeList)
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/findById/{id}")
    public Response findById(@PathParam("id") long id){
        Employee employee = employeeRepository.findById(id);
        return Response
                .status(Response.Status.OK)
                .header("GET", employee)
                .build();
    }

}
