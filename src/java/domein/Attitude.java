package domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Attitude {
    @Id @GeneratedValue
    private int id;
    
    private String naam;
    private String opmerking;
    private boolean uitroeptekenActive;

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

    public boolean isUitroeptekenActive() {
        return uitroeptekenActive;
    }

    public void setUitroeptekenActive(boolean uitroeptekenActive) {
        this.uitroeptekenActive = uitroeptekenActive;
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
        final Attitude other = (Attitude) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
