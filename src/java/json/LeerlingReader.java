package json;

import domein.Attitude;
import domein.Leerling;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class LeerlingReader implements MessageBodyReader<Leerling>{

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return Leerling.class.isAssignableFrom(type);
    }

    @Override
    public Leerling readFrom(Class<Leerling> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
        try(JsonReader in = Json.createReader(entityStream)){
            JsonObject jsonLeerling = in.readObject();
            Leerling leerling = new Leerling();
            
            leerling.setInschrijvingsnummer(jsonLeerling.getString("inschrijvingsnummer"));
            leerling.setFamilienaam(jsonLeerling.getString("familienaam"));
            leerling.setVoornaam(jsonLeerling.getString("voornaam"));
            leerling.setEmail(jsonLeerling.getString("email"));
            leerling.setWachtwoord(jsonLeerling.getString("wachtwoord", null));
            
            
            JsonArray jsonAttituden = jsonLeerling.getJsonArray("attituden");
            if (jsonAttituden != null){
                for (JsonObject jsonObject : jsonAttituden.getValuesAs(JsonObject.class)){
                    Attitude attitude = new Attitude();
                    attitude.setNaam(jsonObject.getString("naam"));
                    attitude.setOpmerking(jsonObject.getString("opmerking"));
                    attitude.setUitroeptekenActive(jsonObject.getBoolean("uitroeptekenActive"));
                        
                    leerling.getAttituden().add(attitude);
                }        
            }
           
            return leerling;
            
        }catch(JsonException | ClassCastException ex){
            throw new BadRequestException("Ongeldige JSON invoer");
        }
    }
    
}
