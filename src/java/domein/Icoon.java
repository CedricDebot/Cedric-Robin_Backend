package domein;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Icoon {
    @Id @GeneratedValue
    private int id;
    
    private String naam;
    
    @Enumerated(EnumType.STRING)
    private Toestand toestand;
    
    @Enumerated(EnumType.STRING)
    private SchermType type;
    
    @OneToMany(mappedBy="icoon")
    private List<Opmerking> opmerkingen;

    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Toestand getToestand() {
        return toestand;
    }

    public void setToestand(Toestand toestand) {
        this.toestand = toestand;
    }

    public SchermType getType() {
        return type;
    }

    public void setType(SchermType type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id;
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
        final Icoon other = (Icoon) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
