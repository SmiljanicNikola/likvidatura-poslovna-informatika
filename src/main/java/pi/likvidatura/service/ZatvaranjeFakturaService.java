package pi.likvidatura.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import pi.likvidatura.domain.ZatvaranjeFaktura;

public interface ZatvaranjeFakturaService {

	
	    
	    ZatvaranjeFaktura save(ZatvaranjeFaktura zatvaranjeFaktura);
 
	    List<ZatvaranjeFaktura> findAll();   
	  
	    Optional<ZatvaranjeFaktura> findOne2(Long id);
	    
	    ZatvaranjeFaktura findOne(Long id);

	    void delete(Long id);
	    
	    Page<ZatvaranjeFaktura> findAll(Pageable pageable);
	    
	
}
