package json;

import domein.Attitude;
import domein.EvaluatieGrafiek;
import domein.Icoon;
import domein.Leerling;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
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
public class LeerlingListWriter implements MessageBodyWriter<List<Leerling>> {

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        if (!List.class.isAssignableFrom(type)) {
            return false;
        }

        if (genericType instanceof ParameterizedType) {
            Type[] arguments = ((ParameterizedType) genericType).getActualTypeArguments();
            return arguments.length == 1 && arguments[0].equals(Leerling.class);
        } else {
            return false;
        }
    }

    @Override
    public long getSize(List<Leerling> t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(List<Leerling> leerlingen, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
        JsonArrayBuilder jsonLeerlingen = Json.createArrayBuilder();

        for (Leerling leerling : leerlingen) {
            JsonObjectBuilder jsonLeerling = Json.createObjectBuilder();

            jsonLeerling.add("inschrijvingsnummer", leerling.getInschrijvingsnummer());
            jsonLeerling.add("familienaam", leerling.getFamilienaam());
            jsonLeerling.add("voornaam", leerling.getVoornaam());
            jsonLeerling.add("email", leerling.getEmail());
            jsonLeerling.add("wachtwoord", leerling.getWachtwoord());

//            JsonArrayBuilder jsonEvamoment = Json.createArrayBuilder();
//            for (Evaluatiemoment evaluatiemoment : leerling.getEvaluatiemomenten()) {
//                JsonObjectBuilder object = Json.createObjectBuilder();
//                object.add(evaluatiemoment.)
//            }
//
//            JsonArrayBuilder jsonIcoon = Json.createArrayBuilder();
//            for (Icoon icoon : leerling.getIconen()) {
//                JsonObjectBuilder object = Json.createObjectBuilder();
//                object.add("id", icoon.getId());
//                object.add("naam", icoon.getNaam());
//                object.add("toestand", icoon.getToestand().toString());
//                object.add("type", (String) icoon.getType().toString());
//            }
//            jsonLeerling.add("iconen", jsonIcoon);
//            
//            JsonArrayBuilder jsonAttitude = Json.createArrayBuilder();
//            for (Attitude attitude : leerling.getAttituden()) {
//                JsonObjectBuilder object = Json.createObjectBuilder();
//                object.add("id", attitude.getId());
//                object.add("naam", attitude.getNaam());
//                object.add("opmerking", attitude.getOpmerking());
//                jsonAttitude.add(object);
//            }
//            jsonLeerling.add("attituden", jsonAttitude);
//
//            JsonObjectBuilder evaGraf = Json.createObjectBuilder();
//            EvaluatieGrafiek evaGrafiek = new EvaluatieGrafiek();
//            evaGraf.add("id", evaGrafiek.getId());
//            evaGraf.add("positie", evaGrafiek.getPositie());
//            if (evaGrafiek.getVoortgang() != null) {
//                evaGraf.add("voortgang", evaGrafiek.getVoortgang());
//            }
//            jsonLeerling.add("evaluatiegrafiek", evaGraf);
//
            jsonLeerlingen.add(jsonLeerling);
//
        }

        try (JsonWriter out = Json.createWriter(entityStream)) {
            out.writeArray(jsonLeerlingen.build());
        }
    }

}
