package json;

import domein.EvaluatieGrafiek;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.json.Json;
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
public class EvaluatieGrafiekWriter implements MessageBodyWriter<EvaluatieGrafiek>{

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return EvaluatieGrafiek.class.isAssignableFrom(type);
    }

    @Override
    public long getSize(EvaluatieGrafiek t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(EvaluatieGrafiek evaluatieGrafiek, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
        JsonObjectBuilder jsonEvaluatieGrafiek = Json.createObjectBuilder();
        
        jsonEvaluatieGrafiek.add("positie", evaluatieGrafiek.getPositie());
        jsonEvaluatieGrafiek.add("voortgang", evaluatieGrafiek.getVoortgang());
        
        try(JsonWriter out = Json.createWriter(entityStream)){
            out.writeObject(jsonEvaluatieGrafiek.build());
        }
    }
    
}
