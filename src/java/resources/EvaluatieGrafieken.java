package resources;

import domein.EvaluatieGrafiek;
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
@Path("evaluatieGrafiek")
@Transactional(dontRollbackOn = {BadRequestException.class, NotFoundException.class})
public class EvaluatieGrafieken {

    @PersistenceContext
    private EntityManager em;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public EvaluatieGrafiek getEvaluatieGrafiek(@PathParam("id") int id) {
        EvaluatieGrafiek evaluatieGrafiek = em.find(EvaluatieGrafiek.class, id);
        
        if(evaluatieGrafiek == null){
            throw new NotFoundException();
        }
        
        return evaluatieGrafiek;
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateEvaluatieGrafiek(@PathParam("id") int id, InputStream in) {
        EvaluatieGrafiek evaluatieGrafiek = em.find(EvaluatieGrafiek.class, id);
        
        if(evaluatieGrafiek == null){
            throw new NotFoundException();
        }
        
        em.detach(evaluatieGrafiek);
        
        try(JsonReader jsonInput = Json.createReader(in)){
            JsonObject jsonEvaluatieGrafiek = jsonInput.readObject();
            
            if(jsonEvaluatieGrafiek.containsKey("positie")){
                int positie = jsonEvaluatieGrafiek.getInt("positie");
                evaluatieGrafiek.setPositie(positie);
            }
            
            if(jsonEvaluatieGrafiek.containsKey("voortgang")){
                String voortgang = jsonEvaluatieGrafiek.getString("voortgang");
                evaluatieGrafiek.setVoortgang(voortgang);
            }
        }catch(BadRequestException | ClassCastException ex){
            throw new BadRequestException("Ongeldige JSON invoer");
        }
        
        em.merge(evaluatieGrafiek);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEvaluatieGrafiek(EvaluatieGrafiek evaluatieGrafiek) {
        em.persist(evaluatieGrafiek);
        
        return Response.created(URI.create("/" + evaluatieGrafiek.getId())).build();
    }
}
