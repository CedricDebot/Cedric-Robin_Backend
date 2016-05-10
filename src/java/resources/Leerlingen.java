package resources;

import domein.Leerling;
import java.net.URI;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("leerlingen")
@Transactional(dontRollbackOn = {BadRequestException.class, NotFoundException.class})
public class Leerlingen {

    @PersistenceContext
    private EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Leerling> getAllLeerlingen() {
        return em.createNamedQuery("Leerling.findAll", Leerling.class).getResultList();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addLeerling(Leerling leerling){
        if(leerling.getVoornaam() == null){
            throw new BadRequestException("Gelieve een voornaam in te geven");
        }
        
        if(leerling.getFamilienaam() == null){
            throw new BadRequestException("Gelieve een familienaam in te geven");
        }
        
        if(leerling.getEmail() == null){
            throw new BadRequestException("Gelieve een email adres in te geven");
        }
        
        if(em.find(Leerling.class, leerling.getEmail()) != null){
            throw new BadRequestException("Leerling is reeds geregistreerd");
        }
        
        em.persist(leerling);
        
        return Response.created(URI.create("/" + leerling.getVoornaam())).build();
    }
    
    @Path("{inschrijvingsnummer}")
    @DELETE 
    public void removeLeerling(@PathParam("inschrijvingsnummer") String inschrijvingsnummer){
        Leerling leerling = em.find(Leerling.class, inschrijvingsnummer);
        
        if(leerling == null){
            throw new NotFoundException("Gebruiker niet gevonden");
        }
        
        em.remove(leerling);
    }
}
