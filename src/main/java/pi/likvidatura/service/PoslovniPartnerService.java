package pi.likvidatura.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import pi.likvidatura.domain.PoslovniPartner;
import pi.likvidatura.domain.StavkaIzvoda;

public interface PoslovniPartnerService {
	
	PoslovniPartner save(PoslovniPartner poslovniPartner);
	
	List<PoslovniPartner> findAll();
	
	PoslovniPartner get(Long id);
	
    void delete(Long id);

    Page<PoslovniPartner> findAll(Pageable pageable);

}
