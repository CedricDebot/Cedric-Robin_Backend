package resources;

import domein.Attitude;
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
@Path("attitude")
@Transactional(dontRollbackOn = {BadRequestException.class, NotFoundException.class})
public class Attitudes {

    @PersistenceContext
    private EntityManager em;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Attitude getAttitude(@PathParam("id") int id) {
        Attitude attitude = em.find(Attitude.class, id);

        if (attitude == null) {
            throw new NotFoundException();
        }

        return attitude;
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateAttitude(@PathParam("id") int id, InputStream in) {
        Attitude attitude = em.find(Attitude.class, id);

        if (attitude == null) {
            throw new NotFoundException();
        }

        em.detach(attitude);

        try (JsonReader jsonInput = Json.createReader(in)) {
            JsonObject jsonAttitude = jsonInput.readObject();

            if (jsonAttitude.containsKey("naam")) {
                String naam = jsonAttitude.getString("naam");
                attitude.setNaam(naam);
            }

            if (jsonAttitude.containsKey("opmerking")) {
                String opmerking = jsonAttitude.getString("opmerking");
                attitude.setOpmerking(opmerking);
            }

            if (jsonAttitude.containsKey("uitroeptekenActive")) {
                boolean uitroeptekenActive = jsonAttitude.getBoolean("uitroeptekenActive");
                attitude.setUitroeptekenActive(uitroeptekenActive);
            }
        } catch (BadRequestException | ClassCastException ex) {
            throw new BadRequestException("Ongeldige JSON invoer");
        }

        em.merge(attitude);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAttitude(Attitude attitude) {
        em.persist(attitude);

        return Response.created(URI.create("/" + attitude.getId())).build();
    }
}
