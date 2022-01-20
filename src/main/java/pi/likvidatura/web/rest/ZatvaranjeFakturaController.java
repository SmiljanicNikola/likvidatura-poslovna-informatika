package pi.likvidatura.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pi.likvidatura.domain.IzlaznaFaktura;
import pi.likvidatura.domain.ZatvaranjeFaktura;
import pi.likvidatura.repository.ZatvaranjeFakturaRepository;
import pi.likvidatura.service.ZatvaranjeFakturaService;
import pi.likvidatura.service.dto.StavkaIzvodaDTO;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("api/zatvaranje-faktura")
public class ZatvaranjeFakturaController {
	
	private final ZatvaranjeFakturaService zatvaranjeFakturaService;
	
	private final ZatvaranjeFakturaRepository zatvaranjeFakturaRepository;

	public ZatvaranjeFakturaController(ZatvaranjeFakturaService zatvaranjeFakturaService,
			ZatvaranjeFakturaRepository zatvaranjeFakturaRepository) {
		super();
		this.zatvaranjeFakturaService = zatvaranjeFakturaService;
		this.zatvaranjeFakturaRepository = zatvaranjeFakturaRepository;
	}
	
	@PostMapping()
	public ResponseEntity<ZatvaranjeFaktura> createZatvaranjeFaktura(@RequestBody ZatvaranjeFaktura zatvaranjeFaktura) throws URISyntaxException{
		ZatvaranjeFaktura result = zatvaranjeFakturaService.save(zatvaranjeFaktura);
		return ResponseEntity
				.created(new URI("/api/zatvaranje-faktura/"+result.getId()))
				.body(result);
	}
	
	@GetMapping()
	public List<ZatvaranjeFaktura> getAllZatvaranjeFaktura(){
		return zatvaranjeFakturaService.findAll();
	}
	
	
	@GetMapping("/{id}")
    public ResponseEntity<ZatvaranjeFaktura> getZatvaranjeFaktura(@PathVariable Long id) {
		
		ZatvaranjeFaktura zatvaranjeFaktura = zatvaranjeFakturaService.findOne(id);
        return ResponseEntity
                .ok()
                .body(zatvaranjeFaktura);
    }
	
	@GetMapping("/paginirano")
	   public ResponseEntity<Page<ZatvaranjeFaktura>> findAll(Pageable pageable){
	    return new ResponseEntity<>(zatvaranjeFakturaService.findAll(pageable), HttpStatus.OK);
	}

}
