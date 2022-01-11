package pi.likvidatura.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * A IzlaznaFaktura.
 */
@Entity
@Table(name = "izlazna_faktura")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class IzlaznaFaktura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "broj_fakture")
    private String brojFakture;

    @Column(name = "pocetni_iznos_za_placanje")
    private Double pocetniIznosZaPlacanje;
    
    @Column(name = "preostali_iznos_za_placanje")
    private Double preostaliIznosZaPlacanje;
    
    @Column(name="poziv_na_broj")
    private String pozivNaBroj;
    
    @Column(name="status_fakture")
    private String statusFakture;

    @ManyToOne
    //@JsonIgnore
    private PoslovnaGodina poslovnaGodina;

    public Long getId() {
        return this.id;
    }

    public IzlaznaFaktura id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrojFakture() {
        return this.brojFakture;
    }

    public IzlaznaFaktura brojFakture(String brojFakture) {
        this.setBrojFakture(brojFakture);
        return this;
    }

    public void setBrojFakture(String brojFakture) {
        this.brojFakture = brojFakture;
    }

    

    public IzlaznaFaktura pocetniIznosZaPlacanje(Double pocetniIznosZaPlacanje) {
        this.setPocetniIznosZaPlacanje(pocetniIznosZaPlacanje);
        return this;
    }

  

    public PoslovnaGodina getPoslovnaGodina() {
        return this.poslovnaGodina;
    }

    public Double getPocetniIznosZaPlacanje() {
		return pocetniIznosZaPlacanje;
	}

	public void setPocetniIznosZaPlacanje(Double pocetniIznosZaPlacanje) {
		this.pocetniIznosZaPlacanje = pocetniIznosZaPlacanje;
	}

	public Double getPreostaliIznosZaPlacanje() {
		return preostaliIznosZaPlacanje;
	}

	public void setPreostaliIznosZaPlacanje(Double preostaliIznosZaPlacanje) {
		this.preostaliIznosZaPlacanje = preostaliIznosZaPlacanje;
	}

	public String getPozivNaBroj() {
		return pozivNaBroj;
	}

	public void setPozivNaBroj(String pozivNaBroj) {
		this.pozivNaBroj = pozivNaBroj;
	}

	public void setPoslovnaGodina(PoslovnaGodina poslovnaGodina) {
        this.poslovnaGodina = poslovnaGodina;
    }

    public IzlaznaFaktura poslovnaGodina(PoslovnaGodina poslovnaGodina) {
        this.setPoslovnaGodina(poslovnaGodina);
        return this;
    }
    
    

    
	public String getStatusFakture() {
		return statusFakture;
	}

	public void setStatusFakture(String statusFakture) {
		this.statusFakture = statusFakture;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IzlaznaFaktura)) {
            return false;
        }
        return id != null && id.equals(((IzlaznaFaktura) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

	@Override
	public String toString() {
		return "IzlaznaFaktura [id=" + id + ", brojFakture=" + brojFakture + ", pocetniIznosZaPlacanje="
				+ pocetniIznosZaPlacanje + ", preostaliIznosZaPlacanje=" + preostaliIznosZaPlacanje + ", pozivNaBroj="
				+ pozivNaBroj + ", statusFakture=" + statusFakture + ", poslovnaGodina=" + poslovnaGodina + "]";
	}

    
}
