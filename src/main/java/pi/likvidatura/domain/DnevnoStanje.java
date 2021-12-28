package pi.likvidatura.domain;

import java.io.Serializable;
import java.time.LocalDate;
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
 * A DnevnoStanje.
 */
@Entity
@Table(name = "dnevno_stanje")
public class DnevnoStanje implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "broj_izvoda")
    private Integer brojIzvoda;

    @Column(name = "datum_izvoda")
    private LocalDate datumIzvoda;

    @Column(name = "prethodno_stanje")
    private Double prethodnoStanje;

    @Column(name = "promet_u_korist")
    private Double prometUKorist;

    @Column(name = "promet_na_teret")
    private Double prometNaTeret;

    @Column(name = "novo_stanje")
    private Double novoStanje;

    @Column(name = "rezervisano")
    private Double rezervisano;

    @OneToMany(mappedBy = "dnevnoStanje")
    private Set<StavkaIzvoda> stavkeIzvoda = new HashSet<>();

    @ManyToOne
    private BankarskiRacun bankarskiRacun;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public DnevnoStanje id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBrojIzvoda() {
        return this.brojIzvoda;
    }

    public DnevnoStanje brojIzvoda(Integer brojIzvoda) {
        this.setBrojIzvoda(brojIzvoda);
        return this;
    }

    public void setBrojIzvoda(Integer brojIzvoda) {
        this.brojIzvoda = brojIzvoda;
    }

    public LocalDate getDatumIzvoda() {
        return this.datumIzvoda;
    }

    public DnevnoStanje datumIzvoda(LocalDate datumIzvoda) {
        this.setDatumIzvoda(datumIzvoda);
        return this;
    }

    public void setDatumIzvoda(LocalDate datumIzvoda) {
        this.datumIzvoda = datumIzvoda;
    }

    public Double getPrethodnoStanje() {
        return this.prethodnoStanje;
    }

    public DnevnoStanje prethodnoStanje(Double prethodnoStanje) {
        this.setPrethodnoStanje(prethodnoStanje);
        return this;
    }

    public void setPrethodnoStanje(Double prethodnoStanje) {
        this.prethodnoStanje = prethodnoStanje;
    }

    public Double getPrometUKorist() {
        return this.prometUKorist;
    }

    public DnevnoStanje prometUKorist(Double prometUKorist) {
        this.setPrometUKorist(prometUKorist);
        return this;
    }

    public void setPrometUKorist(Double prometUKorist) {
        this.prometUKorist = prometUKorist;
    }

    public Double getPrometNaTeret() {
        return this.prometNaTeret;
    }

    public DnevnoStanje prometNaTeret(Double prometNaTeret) {
        this.setPrometNaTeret(prometNaTeret);
        return this;
    }

    public void setPrometNaTeret(Double prometNaTeret) {
        this.prometNaTeret = prometNaTeret;
    }

    public Double getNovoStanje() {
        return this.novoStanje;
    }

    public DnevnoStanje novoStanje(Double novoStanje) {
        this.setNovoStanje(novoStanje);
        return this;
    }

    public void setNovoStanje(Double novoStanje) {
        this.novoStanje = novoStanje;
    }

    public Double getRezervisano() {
        return this.rezervisano;
    }

    public DnevnoStanje rezervisano(Double rezervisano) {
        this.setRezervisano(rezervisano);
        return this;
    }

    public void setRezervisano(Double rezervisano) {
        this.rezervisano = rezervisano;
    }

    public Set<StavkaIzvoda> getStavkaIzvodas() {
        return this.stavkeIzvoda;
    }

    public void setStavkaIzvodas(Set<StavkaIzvoda> stavkaIzvodas) {
        if (this.stavkeIzvoda != null) {
            this.stavkeIzvoda.forEach(i -> i.setDnevnoStanje(null));
        }
        if (stavkaIzvodas != null) {
            stavkaIzvodas.forEach(i -> i.setDnevnoStanje(this));
        }
        this.stavkeIzvoda = stavkaIzvodas;
    }

    public DnevnoStanje stavkaIzvodas(Set<StavkaIzvoda> stavkaIzvodas) {
        this.setStavkaIzvodas(stavkaIzvodas);
        return this;
    }

    public DnevnoStanje addStavkaIzvoda(StavkaIzvoda stavkaIzvoda) {
        this.stavkeIzvoda.add(stavkaIzvoda);
        stavkaIzvoda.setDnevnoStanje(this);
        return this;
    }

    public DnevnoStanje removeStavkaIzvoda(StavkaIzvoda stavkaIzvoda) {
        this.stavkeIzvoda.remove(stavkaIzvoda);
        stavkaIzvoda.setDnevnoStanje(null);
        return this;
    }

    public BankarskiRacun getBankarskiRacun() {
        return this.bankarskiRacun;
    }

    public void setBankarskiRacun(BankarskiRacun bankarskiRacun) {
        this.bankarskiRacun = bankarskiRacun;
    }

    public DnevnoStanje bankarskiRacun(BankarskiRacun bankarskiRacun) {
        this.setBankarskiRacun(bankarskiRacun);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DnevnoStanje)) {
            return false;
        }
        return id != null && id.equals(((DnevnoStanje) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DnevnoStanje{" +
            "id=" + getId() +
            ", brojIzvoda=" + getBrojIzvoda() +
            ", datumIzvoda='" + getDatumIzvoda() + "'" +
            ", prethodnoStanje=" + getPrethodnoStanje() +
            ", prometUKorist=" + getPrometUKorist() +
            ", prometNaTeret=" + getPrometNaTeret() +
            ", novoStanje=" + getNovoStanje() +
            ", rezervisano=" + getRezervisano() +
            "}";
    }
}
