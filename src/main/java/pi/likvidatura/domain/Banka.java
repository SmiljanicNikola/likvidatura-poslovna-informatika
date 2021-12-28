package pi.likvidatura.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * A Banka.
 */
@Entity
@Table(name = "banka")
public class Banka implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sifra")
    private String sifra;

    @Column(name = "naziv")
    private String naziv;

    @OneToMany(mappedBy = "banka")
    private Set<BankarskiRacun> bankarskiRacuns = new HashSet<>();


    public Long getId() {
        return this.id;
    }

    public Banka id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSifra() {
        return this.sifra;
    }

    public Banka sifra(String sifra) {
        this.setSifra(sifra);
        return this;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return this.naziv;
    }

    public Banka naziv(String naziv) {
        this.setNaziv(naziv);
        return this;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Set<BankarskiRacun> getBankarskiRacuns() {
        return this.bankarskiRacuns;
    }

    public void setBankarskiRacuns(Set<BankarskiRacun> bankarskiRacuns) {
        if (this.bankarskiRacuns != null) {
            this.bankarskiRacuns.forEach(i -> i.setBanka(null));
        }
        if (bankarskiRacuns != null) {
            bankarskiRacuns.forEach(i -> i.setBanka(this));
        }
        this.bankarskiRacuns = bankarskiRacuns;
    }

    public Banka bankarskiRacuns(Set<BankarskiRacun> bankarskiRacuns) {
        this.setBankarskiRacuns(bankarskiRacuns);
        return this;
    }

    public Banka addBankarskiRacun(BankarskiRacun bankarskiRacun) {
        this.bankarskiRacuns.add(bankarskiRacun);
        bankarskiRacun.setBanka(this);
        return this;
    }

    public Banka removeBankarskiRacun(BankarskiRacun bankarskiRacun) {
        this.bankarskiRacuns.remove(bankarskiRacun);
        bankarskiRacun.setBanka(null);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Banka)) {
            return false;
        }
        return id != null && id.equals(((Banka) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Banka{" +
            "id=" + getId() +
            ", sifra='" + getSifra() + "'" +
            ", naziv='" + getNaziv() + "'" +
            "}";
    }
}
