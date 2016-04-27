package resources;

import domein.Evaluatiemoment3;
import domein.Status;
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
@Path("evaluatiemoment3")
@Transactional(dontRollbackOn = {BadRequestException.class, NotFoundException.class})
public class Evaluatiemomenten3 {
     @PersistenceContext
    private EntityManager em;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Evaluatiemoment3 getEvaluatiemoment3(@PathParam("id") int id) {
        Evaluatiemoment3 evaluatiemoment3 = em.find(Evaluatiemoment3.class, id);
        
        if(evaluatiemoment3 == null){
            throw new NotFoundException();
        }
        
        return evaluatiemoment3;
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateEvaluatiemoment3(@PathParam("id") int id, InputStream in) {
    Evaluatiemoment3 evaluatiemoment3 = em.find(Evaluatiemoment3.class, id);
        
        if(evaluatiemoment3 == null){
            throw new NotFoundException();
        }
        
        em.detach(evaluatiemoment3);
        
        try(JsonReader jsonInput = Json.createReader(in)){
            JsonObject jsonEvaluatiemoment1 = jsonInput.readObject();
            
            if(jsonEvaluatiemoment1.containsKey("zithouding")){
                String zithouding = jsonEvaluatiemoment1.getString("zithouding");
                evaluatiemoment3.setZithouding(zithouding.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("koppeling")){
                String koppeling = jsonEvaluatiemoment1.getString("koppeling");
                evaluatiemoment3.setZithouding(koppeling.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("remtechniek")){
                String remtechniek = jsonEvaluatiemoment1.getString("remtechniek");
                evaluatiemoment3.setZithouding(remtechniek.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("schakelen")){
                String schakelen = jsonEvaluatiemoment1.getString("schakelen");
                evaluatiemoment3.setZithouding(schakelen.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("stuurtechniek")){
                String stuurtechniek = jsonEvaluatiemoment1.getString("stuurtechniek");
                evaluatiemoment3.setZithouding(stuurtechniek.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("kijken")){
                String kijken = jsonEvaluatiemoment1.getString("kijken");
                evaluatiemoment3.setZithouding(kijken.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("helling")){
                String helling = jsonEvaluatiemoment1.getString("helling");
                evaluatiemoment3.setZithouding(helling.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("parkeren")){
                String parkeren = jsonEvaluatiemoment1.getString("parkeren");
                evaluatiemoment3.setZithouding(parkeren.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("keren")){
                String keren = jsonEvaluatiemoment1.getString("keren");
                evaluatiemoment3.setZithouding(keren.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("garage")){
                String garage = jsonEvaluatiemoment1.getString("garage");
                evaluatiemoment3.setZithouding(garage.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("achteruit")){
                String achteruit = jsonEvaluatiemoment1.getString("achteruit");
                evaluatiemoment3.setZithouding(achteruit.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("acht")){
                String acht = jsonEvaluatiemoment1.getString("acht");
                evaluatiemoment3.setZithouding(acht.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("voorrang")){
                String voorrang = jsonEvaluatiemoment1.getString("voorrang");
                evaluatiemoment3.setZithouding(voorrang.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("orderOpvolgen")){
                String orderOpvolgen = jsonEvaluatiemoment1.getString("orderOpvolgen");
                evaluatiemoment3.setZithouding(orderOpvolgen.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("snelheid")){
                String snelheid = jsonEvaluatiemoment1.getString("snelheid");
                evaluatiemoment3.setZithouding(snelheid.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("afstand")){
                String afstand = jsonEvaluatiemoment1.getString("afstand");
                evaluatiemoment3.setZithouding(afstand.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("inhalen")){
                String inhalen = jsonEvaluatiemoment1.getString("inhalen");
                evaluatiemoment3.setZithouding(inhalen.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("kruisen")){
                String kruisen = jsonEvaluatiemoment1.getString("kruisen");
                evaluatiemoment3.setZithouding(kruisen.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("linksaf")){
                String linksaf = jsonEvaluatiemoment1.getString("linksaf");
                evaluatiemoment3.setZithouding(linksaf.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("rechtsaf")){
                String rechtsaf = jsonEvaluatiemoment1.getString("rechtsaf");
                evaluatiemoment3.setZithouding(rechtsaf.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("pinkers")){
                String pinkers = jsonEvaluatiemoment1.getString("pinkers");
                evaluatiemoment3.setZithouding(pinkers.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("openbareWeg")){
                String openbareWeg = jsonEvaluatiemoment1.getString("openbareWeg");
                evaluatiemoment3.setZithouding(openbareWeg.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("rotonde")){
                String rotonde = jsonEvaluatiemoment1.getString("rotonde");
                evaluatiemoment3.setZithouding(rotonde.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("rijbaan")){
                String rijbaan = jsonEvaluatiemoment1.getString("rijbaan");
                evaluatiemoment3.setZithouding(rijbaan.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("stad")){
                String stad = jsonEvaluatiemoment1.getString("stad");
                evaluatiemoment3.setZithouding(stad.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("autosnelweg")){
                String autosnelweg = jsonEvaluatiemoment1.getString("autosnelweg");
                evaluatiemoment3.setZithouding(autosnelweg.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
//            if(jsonEvaluatiemoment1.containsKey("attitude")){
//                String attitude = jsonEvaluatiemoment1.getString("attitude");
//                evaluatiemoment1.setZithouding(attitude.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
//            }
        }catch(BadRequestException | ClassCastException ex){
            throw new BadRequestException("Ongeldige JSON invoer");
        }
        
        em.merge(evaluatiemoment3);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEvaluatiemoment3(Evaluatiemoment3 evaluatiemoment3) {
        em.persist(evaluatiemoment3);
        
        return Response.created(URI.create("/" + evaluatiemoment3.getId())).build();
    }
}
