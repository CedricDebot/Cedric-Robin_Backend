package resources;

import domein.Icoon;
import domein.SchermType;
import domein.Toestand;
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
@Path("icoon")
@Transactional(dontRollbackOn = {BadRequestException.class, ClassCastException.class})
public class Iconen {

    @PersistenceContext
    private EntityManager em;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Icoon getIcoon(@PathParam("id") int id) {
        Icoon icoon = em.find(Icoon.class, id);

        if (icoon == null) {
            throw new NotFoundException();
        }

        return icoon;
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateIcoon(@PathParam("id") int id, InputStream in) {
        Icoon icoon = em.find(Icoon.class, id);

        if (icoon == null) {
            throw new NotFoundException();
        }
        
        em.detach(icoon);
        
        try(JsonReader jsonInput = Json.createReader(in)){
            JsonObject jsonIcoon = jsonInput.readObject();
            
            if(jsonIcoon.containsKey("naam")){
                String naam = jsonIcoon.getString("naam");
                icoon.setNaam(naam);
            }
            
            if(jsonIcoon.containsKey("toestand")){
                String toestand = jsonIcoon.getString("toestand");
                icoon.setToestand(Toestand.valueOf(toestand));
            }
            
            if(jsonIcoon.containsKey("type")){
                String type = jsonIcoon.getString("type");
                icoon.setType(SchermType.valueOf(type));
            }  
        } catch (BadRequestException | ClassCastException ex){
            throw new BadRequestException("Ongeldige JSON invoer");
        }
        
        em.merge(icoon);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addIcoon(Icoon icoon){
        em.persist(icoon);
        
        return Response.created(URI.create("/" + icoon.getId())).build();
    }
}
