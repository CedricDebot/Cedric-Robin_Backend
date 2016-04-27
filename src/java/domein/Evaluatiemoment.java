package domein;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class Evaluatiemoment {

    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.STRING)
    private Status zithouding;
    @Enumerated(EnumType.STRING)
    private Status koppeling;
    @Enumerated(EnumType.STRING)
    private Status remtechniek;
    @Enumerated(EnumType.STRING)
    private Status schakelen;
    @Enumerated(EnumType.STRING)
    private Status stuurtechniek;
    @Enumerated(EnumType.STRING)
    private Status kijken;
    @Enumerated(EnumType.STRING)
    private Status helling;
    @Enumerated(EnumType.STRING)
    private Status parkeren;
    @Enumerated(EnumType.STRING)
    private Status keren;
    @Enumerated(EnumType.STRING)
    private Status garage;
    @Enumerated(EnumType.STRING)
    private Status achteruit;
    @Enumerated(EnumType.STRING)
    private Status acht;

    @Enumerated(EnumType.STRING)
    private Status voorrang;
    @Enumerated(EnumType.STRING)
    private Status orderOpvolgen;
    @Enumerated(EnumType.STRING)
    private Status snelheid;
    @Enumerated(EnumType.STRING)
    private Status afstand;
    @Enumerated(EnumType.STRING)
    private Status inhalen;
    @Enumerated(EnumType.STRING)
    private Status kruisen;
    @Enumerated(EnumType.STRING)
    private Status linksaf;
    @Enumerated(EnumType.STRING)
    private Status rechtsaf;
    @Enumerated(EnumType.STRING)
    private Status pinkers;
    @Enumerated(EnumType.STRING)
    private Status openbareWeg;

    @Enumerated(EnumType.STRING)
    private Status rotonde;
    @Enumerated(EnumType.STRING)
    private Status rijbaan;
    @Enumerated(EnumType.STRING)
    private Status stad;
    @Enumerated(EnumType.STRING)
    private Status autosnelweg;

    @Enumerated(EnumType.STRING)
    private Status attitude;

    @ManyToOne
    private Leerling leerling;
    
    @OneToMany
    private List<Attitude> attituden;
    
    public int getId() {
        return id;
    }

    public Status getZithouding() {
        return zithouding;
    }

    public void setZithouding(Status zithouding) {
        this.zithouding = zithouding;
    }

    public Status getKoppeling() {
        return koppeling;
    }

    public void setKoppeling(Status koppeling) {
        this.koppeling = koppeling;
    }

    public Status getRemtechniek() {
        return remtechniek;
    }

    public void setRemtechniek(Status remtechniek) {
        this.remtechniek = remtechniek;
    }

    public Status getSchakelen() {
        return schakelen;
    }

    public void setSchakelen(Status schakelen) {
        this.schakelen = schakelen;
    }

    public Status getStuurtechniek() {
        return stuurtechniek;
    }

    public void setStuurtechniek(Status stuurtechniek) {
        this.stuurtechniek = stuurtechniek;
    }

    public Status getKijken() {
        return kijken;
    }

    public void setKijken(Status kijken) {
        this.kijken = kijken;
    }

    public Status getHelling() {
        return helling;
    }

    public void setHelling(Status helling) {
        this.helling = helling;
    }

    public Status getParkeren() {
        return parkeren;
    }

    public void setParkeren(Status parkeren) {
        this.parkeren = parkeren;
    }

    public Status getKeren() {
        return keren;
    }

    public void setKeren(Status keren) {
        this.keren = keren;
    }

    public Status getGarage() {
        return garage;
    }

    public void setGarage(Status garage) {
        this.garage = garage;
    }

    public Status getAchteruit() {
        return achteruit;
    }

    public void setAchteruit(Status achteruit) {
        this.achteruit = achteruit;
    }

    public Status getAcht() {
        return acht;
    }

    public void setAcht(Status acht) {
        this.acht = acht;
    }

    public Status getVoorrang() {
        return voorrang;
    }

    public void setVoorrang(Status voorrang) {
        this.voorrang = voorrang;
    }

    public Status getOrderOpvolgen() {
        return orderOpvolgen;
    }

    public void setOrderOpvolgen(Status orderOpvolgen) {
        this.orderOpvolgen = orderOpvolgen;
    }

    public Status getSnelheid() {
        return snelheid;
    }

    public void setSnelheid(Status snelheid) {
        this.snelheid = snelheid;
    }

    public Status getAfstand() {
        return afstand;
    }

    public void setAfstand(Status afstand) {
        this.afstand = afstand;
    }

    public Status getInhalen() {
        return inhalen;
    }

    public void setInhalen(Status inhalen) {
        this.inhalen = inhalen;
    }

    public Status getKruisen() {
        return kruisen;
    }

    public void setKruisen(Status kruisen) {
        this.kruisen = kruisen;
    }

    public Status getLinksaf() {
        return linksaf;
    }

    public void setLinksaf(Status linksaf) {
        this.linksaf = linksaf;
    }

    public Status getRechtsaf() {
        return rechtsaf;
    }

    public void setRechtsaf(Status rechtsaf) {
        this.rechtsaf = rechtsaf;
    }

    public Status getPinkers() {
        return pinkers;
    }

    public void setPinkers(Status pinkers) {
        this.pinkers = pinkers;
    }

    public Status getOpenbareWeg() {
        return openbareWeg;
    }

    public void setOpenbareWeg(Status openbareWeg) {
        this.openbareWeg = openbareWeg;
    }

    public Status getRotonde() {
        return rotonde;
    }

    public void setRotonde(Status rotonde) {
        this.rotonde = rotonde;
    }

    public Status getRijbaan() {
        return rijbaan;
    }

    public void setRijbaan(Status rijbaan) {
        this.rijbaan = rijbaan;
    }

    public Status getStad() {
        return stad;
    }

    public void setStad(Status stad) {
        this.stad = stad;
    }

    public Status getAutosnelweg() {
        return autosnelweg;
    }

    public void setAutosnelweg(Status autosnelweg) {
        this.autosnelweg = autosnelweg;
    }

    public Status getAttitude() {
        return attitude;
    }

    public void setAttitude(Status attitude) {
        this.attitude = attitude;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
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
        final Evaluatiemoment other = (Evaluatiemoment) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
}
