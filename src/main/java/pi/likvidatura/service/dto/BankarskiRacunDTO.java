package pi.likvidatura.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link pi.likvidatura.domain.BankarskiRacun} entity.
 */
public class BankarskiRacunDTO implements Serializable {

	private Long id;

    private String brojRacuna;

    private PreduzeceDTO preduzece;

    private BankaDTO banka;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(String brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public PreduzeceDTO getPreduzece() {
        return preduzece;
    }

    public void setPreduzece(PreduzeceDTO preduzece) {
        this.preduzece = preduzece;
    }

    public BankaDTO getBanka() {
        return banka;
    }

    public void setBanka(BankaDTO banka) {
        this.banka = banka;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BankarskiRacunDTO)) {
            return false;
        }

        BankarskiRacunDTO bankarskiRacunDTO = (BankarskiRacunDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, bankarskiRacunDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BankarskiRacunDTO{" +
            "id=" + getId() +
            ", brojRacuna='" + getBrojRacuna() + "'" +
            ", preduzece=" + getPreduzece() +
            ", banka=" + getBanka() +
            "}";
    }
}
