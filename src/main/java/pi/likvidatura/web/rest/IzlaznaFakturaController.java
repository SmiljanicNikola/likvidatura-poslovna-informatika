package pi.likvidatura.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pi.likvidatura.domain.IzlaznaFaktura;
import pi.likvidatura.domain.PoslovnaGodina;
import pi.likvidatura.domain.StavkaIzvoda;
import pi.likvidatura.repository.IzlaznaFakturaRepository;
import pi.likvidatura.repository.PoslovnaGodinaRepository;
import pi.likvidatura.service.IzlaznaFakturaService;
import pi.likvidatura.service.PoslovnaGodinaService;
import pi.likvidatura.service.dto.IzlaznaFakturaDTO;

/**
 * REST controller for managing {@link pi.likvidatura.domain.IzlaznaFaktura}.
 */
@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/izlazne-fakture")
public class IzlaznaFakturaController {

    private final Logger log = LoggerFactory.getLogger(IzlaznaFakturaController.class);

    private final IzlaznaFakturaService izlaznaFakturaService;
    private final PoslovnaGodinaService poslovnaGodinaService;
    private final IzlaznaFakturaRepository izlaznaFakturaRepository;
    private final PoslovnaGodinaRepository poslovnaGodinaRepository;

    public IzlaznaFakturaController(IzlaznaFakturaService izlaznaFakturaService, IzlaznaFakturaRepository izlaznaFakturaRepository, PoslovnaGodinaRepository poslovnaGodinaRepository, PoslovnaGodinaService poslovnaGodinaService) {
        this.izlaznaFakturaService = izlaznaFakturaService;
        this.izlaznaFakturaRepository = izlaznaFakturaRepository;
        this.poslovnaGodinaRepository = poslovnaGodinaRepository;
        this.poslovnaGodinaService = poslovnaGodinaService;
    }

    @PostMapping()
    public ResponseEntity<IzlaznaFakturaDTO> createIzlaznaFaktura(@RequestBody IzlaznaFakturaDTO izlaznaFakturaDTO)
        throws URISyntaxException {
        log.debug("REST request to save IzlaznaFaktura : {}", izlaznaFakturaDTO);
        if (izlaznaFakturaDTO.getId() != null) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);        
        }
        IzlaznaFakturaDTO result = izlaznaFakturaService.save(izlaznaFakturaDTO);
        return ResponseEntity
            .created(new URI("/api/izlazne-fakture/" + result.getId()))
            .body(result);
    }

    /*@PutMapping("/{id}")
    public ResponseEntity<IzlaznaFaktura> updateIzlaznaFaktura( //IzlaznaFakturaDTO promenjeno u IzlaznFaktura
        @PathVariable(value = "id", required = false) final Long id,
        //@RequestBody IzlaznaFakturaDTO izlaznaFakturaDTO
        @RequestBody IzlaznaFaktura izlaznaFaktura
    ) throws URISyntaxException {
        log.debug("REST request to update IzlaznaFaktura : {}, {}", id, izlaznaFaktura);
        if (izlaznaFaktura.getId() == null) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!Objects.equals(id, izlaznaFaktura.getId())) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (!izlaznaFakturaRepository.existsById(id)) {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        	izlaznaFaktura.setBrojFakture(izlaznaFaktura.getBrojFakture());
        	izlaznaFaktura.setPocetniIznosZaPlacanje(izlaznaFaktura.getPocetniIznosZaPlacanje());
        	izlaznaFaktura.setPreostaliIznosZaPlacanje(izlaznaFaktura.getPreostaliIznosZaPlacanje());
        	izlaznaFaktura.setPozivNaBroj(izlaznaFaktura.getPozivNaBroj());
        	izlaznaFaktura.setStatusFakture(izlaznaFaktura.getStatusFakture());
        	//Long poslovnaGodinaId = izlaznaFaktura.getPoslovnaGodina().getId();
        	//PoslovnaGodina poslovnaGodina = poslovnaGodinaService.findOne2(poslovnaGodinaId);
        	//izlaznaFaktura.setPoslovnaGodina(poslovnaGodina);
        	
        
       
	        //IzlaznaFakturaDTO result = izlaznaFakturaService.save(izlaznaFakturaDTO); SA DTO-om !!!!!!!!!
	        IzlaznaFaktura result = izlaznaFakturaService.save(izlaznaFaktura);
	        return ResponseEntity
	            .ok()
	            .body(result);
    }*/
    
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody IzlaznaFaktura faktura, @PathVariable Long id){
    	try {
    		IzlaznaFaktura postojanaFaktura = izlaznaFakturaService.findOne2(id);
    		if(postojanaFaktura != null) {
    			/*postojanaStavka.setBrojStavke(stavka.getBrojStavke());
    			postojanaStavka.setIznos(stavka.getIznos());
    			postojanaStavka.setDuznik(stavka.getDuznik());
    			postojanaStavka.setSvrhaPlacanja(stavka.getSvrhaPlacanja());
    			postojanaStavka.setPrimalac(stavka.getPrimalac());
    			postojanaStavka.setRacunDuznika(stavka.getRacunDuznika());*/
    			postojanaFaktura.setPreostaliIznosZaPlacanje(faktura.getPreostaliIznosZaPlacanje());
    			postojanaFaktura.setStatusFakture("zatvorena");;
    			
    			izlaznaFakturaService.save(postojanaFaktura);
    		}
		return new ResponseEntity<>(HttpStatus.OK);
    }catch(NoSuchElementException e) {
    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    }


    @GetMapping()
    public List<IzlaznaFaktura> getAllIzlazneFakture() {
        log.debug("REST request to get all");
        return izlaznaFakturaService.findAll();
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<IzlaznaFakturaDTO> getIzlaznaFaktura(@PathVariable Long id) {
        log.debug("REST request to get IzlaznaFaktura : {}", id);
        Optional<IzlaznaFakturaDTO> izlaznaFakturaDTO = izlaznaFakturaService.findOne(id);
        Ovde komif(izlaznaFakturaDTO.isEmpty()) {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } ovde kraj kom
        return ResponseEntity
                .ok()
                .body(izlaznaFakturaDTO.get());
    }*/
    @GetMapping("/{id}")
    public ResponseEntity<IzlaznaFaktura> getIzlaznaFaktura(@PathVariable Long id) {
        log.debug("REST request to get IzlaznaFaktura : {}", id);
        IzlaznaFaktura izlaznaFaktura = izlaznaFakturaService.findOne2(id);
        /*if(izlaznaFakturaDTO.isEmpty()) {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }*/
        return ResponseEntity
                .ok()
                .body(izlaznaFaktura);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIzlaznaFaktura(@PathVariable Long id) {
        log.debug("REST request to delete IzlaznaFaktura : {}", id);
        izlaznaFakturaService.delete(id);
        return ResponseEntity
            .noContent()
            .build();
    }
}
