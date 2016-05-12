package domein;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
    @NamedQuery(name = "Leerling.findAll", query = "SELECT l FROM Leerling l ")
})

public class Leerling{
    
    @Id 
    private String inschrijvingsnummer;
    
    private String familienaam;
    private String voornaam;
    private String email;
    private String wachtwoord;
       
    @OneToMany(mappedBy="leerling")
    private List<Evaluatiemoment> evaluatiemomenten = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Attitude> attituden = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Icoon> iconen = new ArrayList<>();
    
    @OneToOne(cascade = CascadeType.PERSIST)
    private EvaluatieGrafiek evaluatieGrafiek;

    public void setAttituden(List<Attitude> attituden) {
        this.attituden = attituden;
    }

    public EvaluatieGrafiek getEvaluatieGrafiek() {
        return evaluatieGrafiek;
    }

    public void setEvaluatieGrafiek(EvaluatieGrafiek evaluatieGrafiek) {
        this.evaluatieGrafiek = evaluatieGrafiek;
    }

    public List<Evaluatiemoment> getEvaluatiemomenten() {
        return evaluatiemomenten;
    }

    public void setEvaluatiemomenten(List<Evaluatiemoment> evaluatiemomenten) {
        this.evaluatiemomenten = evaluatiemomenten;
    }

    public List<Icoon> getIconen() {
        return iconen;
    }

    public void setIconen(List<Icoon> iconen) {
        this.iconen = iconen;
    }
    
    
    public String getInschrijvingsnummer() {
        return inschrijvingsnummer;
    }

    public void setInschrijvingsnummer(String inschrijvingsnummer) {
        this.inschrijvingsnummer = inschrijvingsnummer;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public void setFamilienaam(String familienaam) {
        this.familienaam = familienaam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.inschrijvingsnummer);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Leerling other = (Leerling) obj;
        if (!Objects.equals(this.inschrijvingsnummer, other.inschrijvingsnummer)) {
            return false;
        }
        return true;
    }   

    public List<Attitude> getAttituden() {
        return attituden;
    }
    
    
}
