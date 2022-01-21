package pi.likvidatura.domain;

import static javax.persistence.CascadeType.ALL;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "zatvaranje_faktura")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ZatvaranjeFaktura implements Serializable {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Long id;
	 	
	 	@ManyToOne
	 	private IzlaznaFaktura izlaznaFaktura;
	 	
	 	@ManyToOne
	 	private StavkaIzvoda stavkaIzvoda; 
	 	
	 	@Column(name="iznos_zatvaranja")
	 	private Double iznosZatvaranja;
	 	
	 	//@Version
	    //private Long version;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public IzlaznaFaktura getIzlaznaFaktura() {
			return izlaznaFaktura;
		}

		public void setIzlaznaFaktura(IzlaznaFaktura izlaznaFaktura) {
			this.izlaznaFaktura = izlaznaFaktura;
		}

		public StavkaIzvoda getStavkaIzvoda() {
			return stavkaIzvoda;
		}

		public void setStavkaIzvoda(StavkaIzvoda stavkaIzvoda) {
			this.stavkaIzvoda = stavkaIzvoda;
		}

		public Double getIznosZatvaranja() {
			return iznosZatvaranja;
		}

		public void setIznosZatvaranja(Double iznosZatvaranja) {
			this.iznosZatvaranja = iznosZatvaranja;
		}

		@Override
		public String toString() {
			return "ZatvaranjeFaktura [id=" + id + ", izlaznaFaktura=" + izlaznaFaktura + ", stavkaIzvoda="
					+ stavkaIzvoda + ", iznosZatvaranja=" + iznosZatvaranja + "]";
		}

	
	
}
