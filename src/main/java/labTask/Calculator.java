package labTask;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)


public class Calculator {
	
	@PersistenceContext(unitName= "hello")
    private EntityManager em;
	
	@POST
	@Path("/calc")
	
	public Response CreateCalculations(Calculation calculation) {
		try {
			em.persist(calculation);
			return Response.ok (calculation.calculate()).build();
		}
		catch (Exception e){
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
	@GET
	@Path("/calculations")
	public Response getAllCalculations() {
		
		try {
			TypedQuery<Calculation> query=em.createQuery("SELECT c from Calculation c ", Calculation.class);
			return Response.ok (query.getResultList()).build();
		}
		catch (Exception e){
			return Response.serverError().entity(e.getMessage()).build();
		}	
	}
	
	
	
}
