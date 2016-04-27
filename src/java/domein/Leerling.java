package domein;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
    @NamedQuery(name = "Leerling.findAll", query = "SELECT l.inschrijvingsnummer, l.familienaam, l.voornaam, l.email FROM Leerling l")
})

public class Leerling {
    
    @Id 
    private int inschrijvingsnummer;
    
    private String familienaam;
    private String voornaam;
    private String email;
    private String wachtwoord;
    
    @Lob
    @Column(name = "profielfoto")
    private byte[] foto;
   
    @OneToMany(mappedBy="leerling")
    private List<Evaluatiemoment> evaluatiemomenten;
    
    @OneToMany
    private List<Attitude> attituden;
    
    @OneToMany
    private List<Icoon> iconen;
    
    @OneToOne
    private EvaluatieGrafiek evaluatieGrafiek;
    
    public int getInschrijvingsnummer() {
        return inschrijvingsnummer;
    }

    public void setInschrijvingsnummer(int inschrijvingsnummer) {
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
        int hash = 3;
        hash = 37 * hash + this.inschrijvingsnummer;
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
        if (this.inschrijvingsnummer != other.inschrijvingsnummer) {
            return false;
        }
        return true;
    }
    
    
}
