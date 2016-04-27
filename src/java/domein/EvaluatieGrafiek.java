package domein;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EvaluatieGrafiek {
    @Id @GeneratedValue
    private int id;
    
    private int positie;
    private String voortgang;

    public int getId() {
        return id;
    }

    public int getPositie() {
        return positie;
    }

    public void setPositie(int positie) {
        this.positie = positie;
    }

    public String getVoortgang() {
        return voortgang;
    }

    public void setVoortgang(String voortgang) {
        this.voortgang = voortgang;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id;
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
        final EvaluatieGrafiek other = (EvaluatieGrafiek) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
