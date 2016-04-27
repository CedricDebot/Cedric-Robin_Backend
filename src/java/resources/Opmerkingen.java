package resources;

import domein.Opmerking;
import java.io.InputStream;
import java.net.URI;
import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("opmerking")
@Transactional(dontRollbackOn = {BadRequestException.class, NotFoundException.class})
public class Opmerkingen {
    
    @PersistenceContext
    private EntityManager em;
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Opmerking getOpmerking(@PathParam("id") int id){
        Opmerking opmerking = em.find(Opmerking.class, id);
        
        if(opmerking == null){
            throw new NotFoundException();
        }
        
        return opmerking;
    }
    
    @PUT 
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateOpmerking(@PathParam("id") int id, InputStream in){
        Opmerking opmerking = em.find(Opmerking.class, id);
        
        if(opmerking == null){
            throw new NotFoundException();
        }
        
        em.detach(opmerking);
        
        try(JsonReader jsonInput = Json.createReader(in)){
            JsonObject jsonOpmerking = jsonInput.readObject();
            
            if(jsonOpmerking.containsKey("naam")){
                String naam = jsonOpmerking.getString("naam");
                opmerking.setNaam(naam);
            }
            
            if(jsonOpmerking.containsKey("opmerking")){
                String opmerkingString = jsonOpmerking.getString("opmerking");
                opmerking.setOpmerking(opmerkingString);
            }
            
            if(jsonOpmerking.containsKey("uitroeptekenactive")){
                boolean uitroeptekenactive = jsonOpmerking.getBoolean("uitroeptekenactive");
                opmerking.setUitroeptekenactive(uitroeptekenactive);
            }   
        }catch (BadRequestException | ClassCastException ex){
            throw new BadRequestException("Ongeldige JSON invoer");
        }
        
        em.merge(opmerking);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addOpmerking(Opmerking opmerking){
        em.persist(opmerking);
        
        return Response.created(URI.create("/" + opmerking.getId())).build();
    }
    
}
