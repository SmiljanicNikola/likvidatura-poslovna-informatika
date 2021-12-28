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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * A PoslovnaGodina.
 */
@Entity
@Table(name = "poslovna_godina")
public class PoslovnaGodina implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "godina")
    private Integer godina;

    @Column(name = "zakljucena")
    private Boolean zakljucena;

    @OneToMany(mappedBy = "poslovnaGodina",fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<IzlaznaFaktura> izlaznaFakturas = new HashSet<>();

    @ManyToOne(cascade= {ALL},fetch = FetchType.EAGER)
    //@JsonIgnore
    private Preduzece preduzece;

    public Long getId() {
        return this.id;
    }
    
    

    public PoslovnaGodina id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGodina() {
        return this.godina;
    }

    public PoslovnaGodina godina(Integer godina) {
        this.setGodina(godina);
        return this;
    }

    public void setGodina(Integer godina) {
        this.godina = godina;
    }

    public Boolean getZakljucena() {
        return this.zakljucena;
    }

    public PoslovnaGodina zakljucena(Boolean zakljucena) {
        this.setZakljucena(zakljucena);
        return this;
    }

    public void setZakljucena(Boolean zakljucena) {
        this.zakljucena = zakljucena;
    }

    public Set<IzlaznaFaktura> getIzlaznaFakturas() {
        return this.izlaznaFakturas;
    }

    public void setIzlaznaFakturas(Set<IzlaznaFaktura> izlaznaFakturas) {
        if (this.izlaznaFakturas != null) {
            this.izlaznaFakturas.forEach(i -> i.setPoslovnaGodina(null));
        }
        if (izlaznaFakturas != null) {
            izlaznaFakturas.forEach(i -> i.setPoslovnaGodina(this));
        }
        this.izlaznaFakturas = izlaznaFakturas;
    }

    public PoslovnaGodina izlaznaFakturas(Set<IzlaznaFaktura> izlaznaFakturas) {
        this.setIzlaznaFakturas(izlaznaFakturas);
        return this;
    }

    public PoslovnaGodina addIzlaznaFaktura(IzlaznaFaktura izlaznaFaktura) {
        this.izlaznaFakturas.add(izlaznaFaktura);
        izlaznaFaktura.setPoslovnaGodina(this);
        return this;
    }

    public PoslovnaGodina removeIzlaznaFaktura(IzlaznaFaktura izlaznaFaktura) {
        this.izlaznaFakturas.remove(izlaznaFaktura);
        izlaznaFaktura.setPoslovnaGodina(null);
        return this;
    }

    public Preduzece getPreduzece() {
        return this.preduzece;
    }

    public void setPreduzece(Preduzece preduzece) {
        this.preduzece = preduzece;
    }

    public PoslovnaGodina preduzece(Preduzece preduzece) {
        this.setPreduzece(preduzece);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PoslovnaGodina)) {
            return false;
        }
        return id != null && id.equals(((PoslovnaGodina) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PoslovnaGodina{" +
            "id=" + getId() +
            ", godina=" + getGodina() +
            ", zakljucena='" + getZakljucena() + "'" +
            "}";
    }
}
