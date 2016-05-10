package json;

import domein.EvaluatieGrafiek;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.json.Json;
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
public class EvaluatieGrafiekReader implements MessageBodyReader<EvaluatieGrafiek> {

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return EvaluatieGrafiek.class.isAssignableFrom(type);
    }

    @Override
    public EvaluatieGrafiek readFrom(Class<EvaluatieGrafiek> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
        try(JsonReader in = Json.createReader(entityStream)){
            JsonObject jsonEvaluatieGrafiek = in.readObject();
            EvaluatieGrafiek evaluatieGrafiek = new EvaluatieGrafiek();
            
            evaluatieGrafiek.setPositie(jsonEvaluatieGrafiek.getInt("positie"));
            evaluatieGrafiek.setVoortgang(jsonEvaluatieGrafiek.getString("voortgang"));
            
            return evaluatieGrafiek;
        }catch (JsonException | ClassCastException ex){
            throw new BadRequestException("Ongeldige JSON invoer");
        }
    }

}
