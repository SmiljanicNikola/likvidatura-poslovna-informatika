package pi.likvidatura.domain;

import static javax.persistence.CascadeType.ALL;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * A Preduzece.
 */
@Entity
@Table(name = "preduzece")
public class Preduzece implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "pib")
    private String pib;

    @Column(name = "maticni_broj")
    private String maticniBroj;

    @OneToMany(mappedBy = "preduzece")
    @JsonIgnore
    private Set<BankarskiRacun> bankarskiRacuns = new HashSet<>();

    @OneToMany(mappedBy="preduzece")
    @JsonIgnore
    private Set<PoslovnaGodina> poslovnaGodinas = new HashSet<>();

    public Long getId() {
        return this.id;
    }

    public Preduzece id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return this.naziv;
    }

    public Preduzece naziv(String naziv) {
        this.setNaziv(naziv);
        return this;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getPib() {
        return this.pib;
    }

    public Preduzece pib(String pib) {
        this.setPib(pib);
        return this;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getMaticniBroj() {
        return this.maticniBroj;
    }

    public Preduzece maticniBroj(String maticniBroj) {
        this.setMaticniBroj(maticniBroj);
        return this;
    }

    public void setMaticniBroj(String maticniBroj) {
        this.maticniBroj = maticniBroj;
    }

    public Set<BankarskiRacun> getBankarskiRacuns() {
        return this.bankarskiRacuns;
    }

    public void setBankarskiRacuns(Set<BankarskiRacun> bankarskiRacuns) {
        if (this.bankarskiRacuns != null) {
            this.bankarskiRacuns.forEach(i -> i.setPreduzece(null));
        }
        if (bankarskiRacuns != null) {
            bankarskiRacuns.forEach(i -> i.setPreduzece(this));
        }
        this.bankarskiRacuns = bankarskiRacuns;
    }

    public Preduzece bankarskiRacuns(Set<BankarskiRacun> bankarskiRacuns) {
        this.setBankarskiRacuns(bankarskiRacuns);
        return this;
    }

    public Preduzece addBankarskiRacun(BankarskiRacun bankarskiRacun) {
        this.bankarskiRacuns.add(bankarskiRacun);
        bankarskiRacun.setPreduzece(this);
        return this;
    }

    public Preduzece removeBankarskiRacun(BankarskiRacun bankarskiRacun) {
        this.bankarskiRacuns.remove(bankarskiRacun);
        bankarskiRacun.setPreduzece(null);
        return this;
    }

    public Set<PoslovnaGodina> getPoslovnaGodinas() {
        return this.poslovnaGodinas;
    }

    public void setPoslovnaGodinas(Set<PoslovnaGodina> poslovnaGodinas) {
        if (this.poslovnaGodinas != null) {
            this.poslovnaGodinas.forEach(i -> i.setPreduzece(null));
        }
        if (poslovnaGodinas != null) {
            poslovnaGodinas.forEach(i -> i.setPreduzece(this));
        }
        this.poslovnaGodinas = poslovnaGodinas;
    }

    public Preduzece poslovnaGodinas(Set<PoslovnaGodina> poslovnaGodinas) {
        this.setPoslovnaGodinas(poslovnaGodinas);
        return this;
    }

    public Preduzece addPoslovnaGodina(PoslovnaGodina poslovnaGodina) {
        this.poslovnaGodinas.add(poslovnaGodina);
        poslovnaGodina.setPreduzece(this);
        return this;
    }

    public Preduzece removePoslovnaGodina(PoslovnaGodina poslovnaGodina) {
        this.poslovnaGodinas.remove(poslovnaGodina);
        poslovnaGodina.setPreduzece(null);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Preduzece)) {
            return false;
        }
        return id != null && id.equals(((Preduzece) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Preduzece{" +
            "id=" + getId() +
            ", naziv='" + getNaziv() + "'" +
            ", pib='" + getPib() + "'" +
            ", maticniBroj='" + getMaticniBroj() + "'" +
            "}";
    }
}
