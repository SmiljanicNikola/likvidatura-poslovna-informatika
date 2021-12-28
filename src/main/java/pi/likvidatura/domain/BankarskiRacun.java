package pi.likvidatura.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * A BankarskiRacun.
 */
@Entity
@Table(name = "bankarski_racun")
public class BankarskiRacun implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "broj_racuna")
    private String brojRacuna;

    @OneToMany(mappedBy = "bankarskiRacun")
    private Set<DnevnoStanje> dnevnaStanja = new HashSet<>();

    @ManyToOne
    private Preduzece preduzece;

    @ManyToOne
    private Banka banka;

    public Long getId() {
        return this.id;
    }

    public BankarskiRacun id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrojRacuna() {
        return this.brojRacuna;
    }

    public BankarskiRacun brojRacuna(String brojRacuna) {
        this.setBrojRacuna(brojRacuna);
        return this;
    }

    public void setBrojRacuna(String brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public Set<DnevnoStanje> getDnevnoStanjes() {
        return this.dnevnaStanja;
    }

    public void setDnevnoStanjes(Set<DnevnoStanje> dnevnoStanjes) {
        if (this.dnevnaStanja != null) {
            this.dnevnaStanja.forEach(i -> i.setBankarskiRacun(null));
        }
        if (dnevnoStanjes != null) {
            dnevnoStanjes.forEach(i -> i.setBankarskiRacun(this));
        }
        this.dnevnaStanja = dnevnoStanjes;
    }

    public BankarskiRacun dnevnoStanjes(Set<DnevnoStanje> dnevnoStanjes) {
        this.setDnevnoStanjes(dnevnoStanjes);
        return this;
    }

    public BankarskiRacun addDnevnoStanje(DnevnoStanje dnevnoStanje) {
        this.dnevnaStanja.add(dnevnoStanje);
        dnevnoStanje.setBankarskiRacun(this);
        return this;
    }

    public BankarskiRacun removeDnevnoStanje(DnevnoStanje dnevnoStanje) {
        this.dnevnaStanja.remove(dnevnoStanje);
        dnevnoStanje.setBankarskiRacun(null);
        return this;
    }

    public Preduzece getPreduzece() {
        return this.preduzece;
    }

    public void setPreduzece(Preduzece preduzece) {
        this.preduzece = preduzece;
    }

    public BankarskiRacun preduzece(Preduzece preduzece) {
        this.setPreduzece(preduzece);
        return this;
    }

    public Banka getBanka() {
        return this.banka;
    }

    public void setBanka(Banka banka) {
        this.banka = banka;
    }

    public BankarskiRacun banka(Banka banka) {
        this.setBanka(banka);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BankarskiRacun)) {
            return false;
        }
        return id != null && id.equals(((BankarskiRacun) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BankarskiRacun{" +
            "id=" + getId() +
            ", brojRacuna='" + getBrojRacuna() + "'" +
            "}";
    }
}
