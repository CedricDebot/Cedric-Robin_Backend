package json;

import domein.Attitude;
import domein.Leerling;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class LeerlingWriter implements MessageBodyWriter<Leerling> {

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return Leerling.class.isAssignableFrom(type);
    }

    @Override
    public long getSize(Leerling t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(Leerling leerling, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
       try (JsonWriter out = Json.createWriter(entityStream)) {
           JsonObjectBuilder jsonLeerling = Json.createObjectBuilder();
           jsonLeerling.add("inschrijvingsnummer", leerling.getInschrijvingsnummer());
           jsonLeerling.add("familienaam", leerling.getFamilienaam());
           jsonLeerling.add("voornaam", leerling.getVoornaam());
           jsonLeerling.add("email", leerling.getEmail());
           jsonLeerling.add("wachtwoord", leerling.getWachtwoord());
           
//           JsonArrayBuilder jsonAttitude = Json.createArrayBuilder();
//           for (Attitude attitude : leerling.getAttituden()) {
//               JsonObjectBuilder object = Json.createObjectBuilder();
//               object.add("id", attitude.getId());
//               object.add("naam", attitude.getNaam());
//               object.add("opmerking", attitude.getOpmerking());
//               jsonAttitude.add(object);
//           }
//           jsonLeerling.add("attituden", jsonAttitude);
           
           out.writeObject(jsonLeerling.build());
       }
    }
        
}
