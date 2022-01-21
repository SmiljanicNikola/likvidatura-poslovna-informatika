package pi.likvidatura.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * A StavkaIzvoda.
 */
@Entity
@Table(name = "stavka_izvoda")
public class StavkaIzvoda implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "broj_stavke")
    private Integer brojStavke;

    @Column(name = "iznos")
    private Double iznos;
    
    @Column(name = "preostali_iznos")
    private Double preostaliIznos;

    @Column(name = "duznik")
    private String duznik;

    @Column(name = "svrha_placanja")
    private String svrhaPlacanja;

    @Column(name = "primalac")
    private String primalac;

    @Column(name = "racun_duznika")
    private String racunDuznika;

    @Column(name = "racun_primaoca")
    private String racunPrimaoca;

    @Column(name = "model")
    private Integer model;

    @Column(name = "poziv_na_broj")
    private String pozivNaBroj;
    
    @Column(name = "proknjizeno")
    private boolean proknjizeno;

    @ManyToOne
    @JsonIgnore
    private DnevnoStanje dnevnoStanje;
    
    //@Version
    //private Long version;

    public Long getId() {
        return this.id;
    }

    public StavkaIzvoda id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBrojStavke() {
        return this.brojStavke;
    }

    public StavkaIzvoda brojStavke(Integer brojStavke) {
        this.setBrojStavke(brojStavke);
        return this;
    }

    public void setBrojStavke(Integer brojStavke) {
        this.brojStavke = brojStavke;
    }

    public Double getIznos() {
        return this.iznos;
    }

    public StavkaIzvoda iznos(Double iznos) {
        this.setIznos(iznos);
        return this;
    }

    public void setIznos(Double iznos) {
        this.iznos = iznos;
    }
    
    

    public double getPreostaliIznos() {
		return preostaliIznos;
	}

	public void setPreostaliIznos(double preostaliIznos) {
		this.preostaliIznos = preostaliIznos;
	}

	public String getDuznik() {
        return this.duznik;
    }

    public StavkaIzvoda duznik(String duznik) {
        this.setDuznik(duznik);
        return this;
    }

    public void setDuznik(String duznik) {
        this.duznik = duznik;
    }

    public String getSvrhaPlacanja() {
        return this.svrhaPlacanja;
    }

    public StavkaIzvoda svrhaPlacanja(String svrhaPlacanja) {
        this.setSvrhaPlacanja(svrhaPlacanja);
        return this;
    }

    public void setSvrhaPlacanja(String svrhaPlacanja) {
        this.svrhaPlacanja = svrhaPlacanja;
    }

    public String getPrimalac() {
        return this.primalac;
    }

    public StavkaIzvoda primalac(String primalac) {
        this.setPrimalac(primalac);
        return this;
    }

    public void setPrimalac(String primalac) {
        this.primalac = primalac;
    }

    public String getRacunDuznika() {
        return this.racunDuznika;
    }

    public StavkaIzvoda racunDuznika(String racunDuznika) {
        this.setRacunDuznika(racunDuznika);
        return this;
    }

    public void setRacunDuznika(String racunDuznika) {
        this.racunDuznika = racunDuznika;
    }

    public String getRacunPrimaoca() {
        return this.racunPrimaoca;
    }

    public StavkaIzvoda racunPrimaoca(String racunPrimaoca) {
        this.setRacunPrimaoca(racunPrimaoca);
        return this;
    }

    public void setRacunPrimaoca(String racunPrimaoca) {
        this.racunPrimaoca = racunPrimaoca;
    }

    public Integer getModel() {
        return this.model;
    }

    public StavkaIzvoda model(Integer model) {
        this.setModel(model);
        return this;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

    public String getPozivNaBroj() {
        return this.pozivNaBroj;
    }

    public StavkaIzvoda pozivNaBroj(String pozivNaBroj) {
        this.setPozivNaBroj(pozivNaBroj);
        return this;
    }

    public void setPozivNaBroj(String pozivNaBroj) {
        this.pozivNaBroj = pozivNaBroj;
    }

    
    
    
    public StavkaIzvoda(Integer brojStavke, String duznik, Double iznos,Integer model, String pozivNaBroj,
			String primalac, String racunDuznika, String racunPrimaoca, String svrhaPlacanja,
			boolean proknjizeno, DnevnoStanje dnevnoStanje) {
		super();
		this.brojStavke = brojStavke;
		this.duznik = duznik;
		this.iznos = iznos;
		this.model = model;
		this.pozivNaBroj = pozivNaBroj;
		this.primalac = primalac;
		this.racunDuznika = racunDuznika;
		this.racunPrimaoca = racunPrimaoca;
		this.svrhaPlacanja = svrhaPlacanja;
		this.proknjizeno = proknjizeno;
		this.dnevnoStanje = dnevnoStanje;
	}
    
  

	

	public StavkaIzvoda(Integer brojStavke, Double iznos, Double preostaliIznos, String duznik, String svrhaPlacanja,
			String primalac, String racunDuznika, String racunPrimaoca, Integer model, String pozivNaBroj,
			boolean proknjizeno, DnevnoStanje dnevnoStanje) {
		super();
		this.brojStavke = brojStavke;
		this.iznos = iznos;
		this.preostaliIznos = preostaliIznos;
		this.duznik = duznik;
		this.svrhaPlacanja = svrhaPlacanja;
		this.primalac = primalac;
		this.racunDuznika = racunDuznika;
		this.racunPrimaoca = racunPrimaoca;
		this.model = model;
		this.pozivNaBroj = pozivNaBroj;
		this.proknjizeno = proknjizeno;
		this.dnevnoStanje = dnevnoStanje;
	}

	public StavkaIzvoda(Integer brojStavke, Double iznos, Double preostaliIznos, String duznik, String svrhaPlacanja,
			String primalac, String racunDuznika, String racunPrimaoca, Integer model, String pozivNaBroj,
			boolean proknjizeno) {
		super();
		this.brojStavke = brojStavke;
		this.iznos = iznos;
		this.preostaliIznos = preostaliIznos;
		this.duznik = duznik;
		this.svrhaPlacanja = svrhaPlacanja;
		this.primalac = primalac;
		this.racunDuznika = racunDuznika;
		this.racunPrimaoca = racunPrimaoca;
		this.model = model;
		this.pozivNaBroj = pozivNaBroj;
		this.proknjizeno = proknjizeno;
	}
	
	

	public StavkaIzvoda(Long id, Integer brojStavke, Double iznos, Double preostaliIznos, String duznik,
			String svrhaPlacanja, String primalac, String racunDuznika, String racunPrimaoca, Integer model,
			String pozivNaBroj, boolean proknjizeno, DnevnoStanje dnevnoStanje) {
		super();
		this.id = id;
		this.brojStavke = brojStavke;
		this.iznos = iznos;
		this.preostaliIznos = preostaliIznos;
		this.duznik = duznik;
		this.svrhaPlacanja = svrhaPlacanja;
		this.primalac = primalac;
		this.racunDuznika = racunDuznika;
		this.racunPrimaoca = racunPrimaoca;
		this.model = model;
		this.pozivNaBroj = pozivNaBroj;
		this.proknjizeno = proknjizeno;
		this.dnevnoStanje = dnevnoStanje;
	}

	public StavkaIzvoda() {
		// TODO Auto-generated constructor stub
	}

	public boolean isProknjizeno() {
		return proknjizeno;
	}

	public void setProknjizeno(boolean proknjizeno) {
		this.proknjizeno = proknjizeno;
	}

	public DnevnoStanje getDnevnoStanje() {
        return this.dnevnoStanje;
    }

    public void setDnevnoStanje(DnevnoStanje dnevnoStanje) {
        this.dnevnoStanje = dnevnoStanje;
    }

    public StavkaIzvoda dnevnoStanje(DnevnoStanje dnevnoStanje) {
        this.setDnevnoStanje(dnevnoStanje);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StavkaIzvoda)) {
            return false;
        }
        return id != null && id.equals(((StavkaIzvoda) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "StavkaIzvoda{" +
            "id=" + getId() +
            ", brojStavke=" + getBrojStavke() +
            ", iznos=" + getIznos() +
            ", preostaliIznos=" + getPreostaliIznos() +
            ", duznik='" + getDuznik() + "'" +
            ", svrhaPlacanja='" + getSvrhaPlacanja() + "'" +
            ", primalac='" + getPrimalac() + "'" +
            ", racunDuznika='" + getRacunDuznika() + "'" +
            ", racunPrimaoca='" + getRacunPrimaoca() + "'" +
            ", model=" + getModel() +
            ", pozivNaBroj='" + getPozivNaBroj() + "'" +
            "}";
    }
}
