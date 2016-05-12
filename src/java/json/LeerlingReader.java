package json;

import domein.Attitude;
import domein.EvaluatieGrafiek;
import domein.Icoon;
import domein.Leerling;
import domein.Opmerking;
import domein.SchermType;
import domein.Toestand;
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
public class LeerlingReader implements MessageBodyReader<Leerling> {

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return Leerling.class.isAssignableFrom(type);
    }

    @Override
    public Leerling readFrom(Class<Leerling> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
        try (JsonReader in = Json.createReader(entityStream)) {
            JsonObject jsonLeerling = in.readObject();
            Leerling leerling = new Leerling();

            leerling.setInschrijvingsnummer(jsonLeerling.getString("inschrijvingsnummer"));
            leerling.setFamilienaam(jsonLeerling.getString("familienaam"));
            leerling.setVoornaam(jsonLeerling.getString("voornaam"));
            leerling.setEmail(jsonLeerling.getString("email"));
            leerling.setWachtwoord(jsonLeerling.getString("wachtwoord"));

            JsonObject jsonEvaluatieGrafiek = jsonLeerling.getJsonObject("evaluatiegrafiek");
            EvaluatieGrafiek evaluatieGrafiek = new EvaluatieGrafiek();
            evaluatieGrafiek.setPositie(jsonEvaluatieGrafiek.getInt("positie"));
            evaluatieGrafiek.setVoortgang(jsonEvaluatieGrafiek.getString("voortgang"));
            leerling.setEvaluatieGrafiek(evaluatieGrafiek);

            JsonArray jsonAttituden = jsonLeerling.getJsonArray("attituden");
            if (jsonAttituden != null) {
                for (JsonObject jsonAttitude : jsonAttituden.getValuesAs(JsonObject.class)) {
                    Attitude attitude = new Attitude();
                    attitude.setNaam(jsonAttitude.getString("naam"));
                    attitude.setOpmerking(jsonAttitude.getString("opmerking"));
                    attitude.setUitroeptekenActive(jsonAttitude.getBoolean("uitroeptekenActive"));

                    leerling.getAttituden().add(attitude);
                }
            }

            JsonArray jsonIconen = jsonLeerling.getJsonArray("iconen");
            if (jsonIconen != null) {
                for (JsonObject jsonIcoon : jsonIconen.getValuesAs(JsonObject.class)) {
                    Icoon icoon = new Icoon();
                    icoon.setNaam(jsonIcoon.getString("naam"));
                    icoon.setToestand(Toestand.valueOf(jsonIcoon.getString("toestand").toUpperCase()));
                    icoon.setType(SchermType.valueOf(jsonIcoon.getString("type").toUpperCase()));
                    JsonArray jsonIcoonOpmerkingen = jsonIcoon.getJsonArray("opmerkingen");
                    if (jsonIcoonOpmerkingen != null) {
                        for (JsonObject jsonIcoonOpmerking : jsonIcoonOpmerkingen.getValuesAs(JsonObject.class)) {
                            Opmerking opmerking = new Opmerking();
                            opmerking.setNaam(jsonIcoonOpmerking.getString("naam"));
                            opmerking.setOpmerking(jsonIcoonOpmerking.getString("opmerking"));
                            opmerking.setUitroeptekenactive(jsonIcoonOpmerking.getBoolean("uitroeptekenActive"));
                            icoon.getOpmerkingen().add(opmerking);
                        }
                    }
                    leerling.getIconen().add(icoon);
                }
            }
            
            
//            JsonArray jsonEvaluatiemomenten = jsonLeerling.getJsonArray("evaluatiemomenten");
//            if(jsonEvaluatiemomenten != null){
//                for(JsonObject jsonIcoon : jsonEvaluatiemomenten.getValuesAs(JsonObject.class)){
//                    
//                }
//            }
            return leerling;

        } catch (JsonException | ClassCastException ex) {
            throw new BadRequestException("Ongeldige JSON invoer");
        }
    }
//
//    @Override
//    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
//        return Leerling.class.isAssignableFrom(type);
//    }
//
//    @Override
//    public Leerling readFrom(Class<Leerling> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream) throws IOException, WebApplicationException {
//        try(JsonReader in = Json.createReader(entityStream)){
//            JsonObject jsonLeerling = in.readObject();
//            Leerling leerling = new Leerling();
//            
//            leerling.setInschrijvingsnummer(jsonLeerling.getString("inschrijvingsnummer"));
//            leerling.setFamilienaam(jsonLeerling.getString("familienaam"));
//            leerling.setVoornaam(jsonLeerling.getString("voornaam"));
//            leerling.setEmail(jsonLeerling.getString("email"));
//            leerling.setWachtwoord(jsonLeerling.getString("wachtwoord", null));
//            
//            
////            JsonArray jsonAttituden = jsonLeerling.getJsonArray("attituden");
////            if (jsonAttituden != null){
////                for (JsonObject jsonObject : jsonAttituden.getValuesAs(JsonObject.class)){
////                    Attitude attitude = new Attitude();
////                    attitude.setNaam(jsonObject.getString("naam"));
////                    attitude.setOpmerking(jsonObject.getString("opmerking"));
////                    attitude.setUitroeptekenActive(jsonObject.getBoolean("uitroeptekenActive"));
////                        
////                    leerling.getAttituden().add(attitude);
////                }        
////            }
//            
//            JsonObject jsonEvaluatieGrafiek = jsonLeerling.getJsonObject("evaluatiegrafiek");
//            EvaluatieGrafiek evaGraf = new EvaluatieGrafiek();
//            leerling.getEvaluatieGrafiek().setPositie(jsonEvaluatieGrafiek.getInt("positie"));
////            evaGraf.setVoortgang(jsonEvaluatieGrafiek.getString("voortgang"));
//            leerling.getEvaluatieGrafiek().setVoortgang(jsonEvaluatieGrafiek.getString("voortgang"));
//            
//            leerling.setEvaluatieGrafiek(evaGraf);
//            
//            return leerling;
//            
//        }catch(JsonException | ClassCastException ex){
//            throw new BadRequestException("Ongeldige JSON invoer");
//        }
//    }

}
