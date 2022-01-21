package pi.likvidatura.web.rest;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pi.likvidatura.domain.IzlaznaFaktura;
import pi.likvidatura.domain.PoslovniPartner;
import pi.likvidatura.repository.PoslovniPartnerRepository;
import pi.likvidatura.service.PoslovniPartnerService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/poslovni-partneri")
public class PoslovniPartnerController {
	
	private final PoslovniPartnerRepository poslovniPartnerRepository;
	
	private final PoslovniPartnerService poslovniPartnerService;

	public PoslovniPartnerController(PoslovniPartnerRepository poslovniPartnerRepository,
			PoslovniPartnerService poslovniPartnerService) {
		super();
		this.poslovniPartnerRepository = poslovniPartnerRepository;
		this.poslovniPartnerService = poslovniPartnerService;
	}
	
	@GetMapping()
	public List<PoslovniPartner> getAllPoslovnePartnere(){
		return poslovniPartnerService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PoslovniPartner> getPoslovniPartner(@PathVariable Long id){
		PoslovniPartner poslovniPartner = poslovniPartnerService.get(id);
		return ResponseEntity.ok().body(poslovniPartner);
	}
	
	@GetMapping("/paginirano")
    public ResponseEntity<Page<PoslovniPartner>> findAll(Pageable pageable){
    	return new ResponseEntity<>(poslovniPartnerService.findAll(pageable), HttpStatus.OK);
    }	
}
