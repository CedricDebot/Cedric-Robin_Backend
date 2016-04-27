package resources;

import domein.Evaluatiemoment2;
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
@Path("evaluatiemoment2")
@Transactional(dontRollbackOn = {BadRequestException.class, NotFoundException.class})
public class Evaluatiemomenten2 {
    @PersistenceContext
    private EntityManager em;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Evaluatiemoment2 getEvaluatiemoment2(@PathParam("id") int id) {
        Evaluatiemoment2 evaluatiemoment2 = em.find(Evaluatiemoment2.class, id);
        
        if(evaluatiemoment2 == null){
            throw new NotFoundException();
        }
        
        return evaluatiemoment2;
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateEvaluatiemoment2(@PathParam("id") int id, InputStream in) {
    Evaluatiemoment2 evaluatiemoment2 = em.find(Evaluatiemoment2.class, id);
        
        if(evaluatiemoment2 == null){
            throw new NotFoundException();
        }
        
        em.detach(evaluatiemoment2);
        
        try(JsonReader jsonInput = Json.createReader(in)){
            JsonObject jsonEvaluatiemoment1 = jsonInput.readObject();
            
            if(jsonEvaluatiemoment1.containsKey("zithouding")){
                String zithouding = jsonEvaluatiemoment1.getString("zithouding");
                evaluatiemoment2.setZithouding(zithouding.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("koppeling")){
                String koppeling = jsonEvaluatiemoment1.getString("koppeling");
                evaluatiemoment2.setZithouding(koppeling.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("remtechniek")){
                String remtechniek = jsonEvaluatiemoment1.getString("remtechniek");
                evaluatiemoment2.setZithouding(remtechniek.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("schakelen")){
                String schakelen = jsonEvaluatiemoment1.getString("schakelen");
                evaluatiemoment2.setZithouding(schakelen.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("stuurtechniek")){
                String stuurtechniek = jsonEvaluatiemoment1.getString("stuurtechniek");
                evaluatiemoment2.setZithouding(stuurtechniek.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("kijken")){
                String kijken = jsonEvaluatiemoment1.getString("kijken");
                evaluatiemoment2.setZithouding(kijken.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("helling")){
                String helling = jsonEvaluatiemoment1.getString("helling");
                evaluatiemoment2.setZithouding(helling.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("parkeren")){
                String parkeren = jsonEvaluatiemoment1.getString("parkeren");
                evaluatiemoment2.setZithouding(parkeren.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("keren")){
                String keren = jsonEvaluatiemoment1.getString("keren");
                evaluatiemoment2.setZithouding(keren.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("garage")){
                String garage = jsonEvaluatiemoment1.getString("garage");
                evaluatiemoment2.setZithouding(garage.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("achteruit")){
                String achteruit = jsonEvaluatiemoment1.getString("achteruit");
                evaluatiemoment2.setZithouding(achteruit.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("acht")){
                String acht = jsonEvaluatiemoment1.getString("acht");
                evaluatiemoment2.setZithouding(acht.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("voorrang")){
                String voorrang = jsonEvaluatiemoment1.getString("voorrang");
                evaluatiemoment2.setZithouding(voorrang.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("orderOpvolgen")){
                String orderOpvolgen = jsonEvaluatiemoment1.getString("orderOpvolgen");
                evaluatiemoment2.setZithouding(orderOpvolgen.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("snelheid")){
                String snelheid = jsonEvaluatiemoment1.getString("snelheid");
                evaluatiemoment2.setZithouding(snelheid.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("afstand")){
                String afstand = jsonEvaluatiemoment1.getString("afstand");
                evaluatiemoment2.setZithouding(afstand.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("inhalen")){
                String inhalen = jsonEvaluatiemoment1.getString("inhalen");
                evaluatiemoment2.setZithouding(inhalen.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("kruisen")){
                String kruisen = jsonEvaluatiemoment1.getString("kruisen");
                evaluatiemoment2.setZithouding(kruisen.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("linksaf")){
                String linksaf = jsonEvaluatiemoment1.getString("linksaf");
                evaluatiemoment2.setZithouding(linksaf.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("rechtsaf")){
                String rechtsaf = jsonEvaluatiemoment1.getString("rechtsaf");
                evaluatiemoment2.setZithouding(rechtsaf.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("pinkers")){
                String pinkers = jsonEvaluatiemoment1.getString("pinkers");
                evaluatiemoment2.setZithouding(pinkers.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("openbareWeg")){
                String openbareWeg = jsonEvaluatiemoment1.getString("openbareWeg");
                evaluatiemoment2.setZithouding(openbareWeg.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("rotonde")){
                String rotonde = jsonEvaluatiemoment1.getString("rotonde");
                evaluatiemoment2.setZithouding(rotonde.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("rijbaan")){
                String rijbaan = jsonEvaluatiemoment1.getString("rijbaan");
                evaluatiemoment2.setZithouding(rijbaan.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("stad")){
                String stad = jsonEvaluatiemoment1.getString("stad");
                evaluatiemoment2.setZithouding(stad.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
            if(jsonEvaluatiemoment1.containsKey("autosnelweg")){
                String autosnelweg = jsonEvaluatiemoment1.getString("autosnelweg");
                evaluatiemoment2.setZithouding(autosnelweg.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
            }
            
//            if(jsonEvaluatiemoment1.containsKey("attitude")){
//                String attitude = jsonEvaluatiemoment1.getString("attitude");
//                evaluatiemoment1.setZithouding(attitude.equalsIgnoreCase("GROEN")? Status.OK : Status.WERKPUNT);
//            }
        }catch(BadRequestException | ClassCastException ex){
            throw new BadRequestException("Ongeldige JSON invoer");
        }
        
        em.merge(evaluatiemoment2);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEvaluatiemoment2(Evaluatiemoment2 evaluatiemoment2) {
        em.persist(evaluatiemoment2);
        
        return Response.created(URI.create("/" + evaluatiemoment2.getId())).build();
    }
}
