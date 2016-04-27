package domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Opmerking {
    @Id @GeneratedValue
    private int id;
    
    private String naam;
    private String opmerking;
    private boolean uitroeptekenactive;

    @ManyToOne
    private Icoon icoon;
    
    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getOpmerking() {
        return opmerking;
    }

    public void setOpmerking(String opmerking) {
        this.opmerking = opmerking;
    }

    public boolean isUitroeptekenactive() {
        return uitroeptekenactive;
    }

    public void setUitroeptekenactive(boolean uitroeptekenactive) {
        this.uitroeptekenactive = uitroeptekenactive;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
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
        final Opmerking other = (Opmerking) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
