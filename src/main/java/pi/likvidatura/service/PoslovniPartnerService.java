package pi.likvidatura.service;

import java.util.List;

import pi.likvidatura.domain.PoslovniPartner;

public interface PoslovniPartnerService {
	
	PoslovniPartner save(PoslovniPartner poslovniPartner);
	
	List<PoslovniPartner> findAll();
	
	PoslovniPartner get(Long id);
	
    void delete(Long id);


}
