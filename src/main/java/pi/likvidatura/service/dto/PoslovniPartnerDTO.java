package pi.likvidatura.service.dto;

import java.io.Serializable;

public class PoslovniPartnerDTO implements Serializable {

	private Long id;
	
	private String naziv;
	
	private String email;
	
	private String telefon;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	@Override
	public String toString() {
		return "PoslovniPartnerDTO [id=" + id + ", naziv=" + naziv + ", email=" + email + ", telefon=" + telefon + "]";
	}
	
	
	
}
