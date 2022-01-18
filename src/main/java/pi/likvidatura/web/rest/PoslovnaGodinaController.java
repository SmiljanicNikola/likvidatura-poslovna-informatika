package pi.likvidatura.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pi.likvidatura.domain.PoslovnaGodina;
import pi.likvidatura.repository.PoslovnaGodinaRepository;
import pi.likvidatura.service.PoslovnaGodinaService;
import pi.likvidatura.service.dto.PoslovnaGodinaDTO;

/**
 * REST controller for managing {@link pi.likvidatura.domain.PoslovnaGodina}.
 */
@RestController
@RequestMapping("/api/poslovne-godine")
@CrossOrigin(origins="http://localhost:3000")

public class PoslovnaGodinaController {

    private final Logger log = LoggerFactory.getLogger(PoslovnaGodinaController.class);

    private final PoslovnaGodinaService poslovnaGodinaService;

    private final PoslovnaGodinaRepository poslovnaGodinaRepository;

    public PoslovnaGodinaController(PoslovnaGodinaService poslovnaGodinaService, PoslovnaGodinaRepository poslovnaGodinaRepository) {
        this.poslovnaGodinaService = poslovnaGodinaService;
        this.poslovnaGodinaRepository = poslovnaGodinaRepository;
    }

    @PostMapping()
    public ResponseEntity<PoslovnaGodinaDTO> createPoslovnaGodina(@RequestBody PoslovnaGodinaDTO poslovnaGodinaDTO)
        throws URISyntaxException {
        log.debug("REST request to save PoslovnaGodina : {}", poslovnaGodinaDTO);
        if (poslovnaGodinaDTO.getId() != null) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);    
        }
        PoslovnaGodinaDTO result = poslovnaGodinaService.save(poslovnaGodinaDTO);
        return ResponseEntity
            .created(new URI("/api/poslovna-godinas/" + result.getId()))
            .body(result);
    }

    /*@PutMapping("/{id}")
    public ResponseEntity<PoslovnaGodinaDTO> updatePoslovnaGodina(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody PoslovnaGodinaDTO poslovnaGodinaDTO
    ) throws URISyntaxException {
        log.debug("REST request to update PoslovnaGodina : {}, {}", id, poslovnaGodinaDTO);
        if (poslovnaGodinaDTO.getId() == null) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!Objects.equals(id, poslovnaGodinaDTO.getId())) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (!poslovnaGodinaRepository.existsById(id)) {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        PoslovnaGodinaDTO result = poslovnaGodinaService.save(poslovnaGodinaDTO);
        return ResponseEntity
            .ok()
            .body(result);
    }*/

    @GetMapping()
    public List<PoslovnaGodina> getAllPoslovneGodine() {
        log.debug("REST request to get all");
        return poslovnaGodinaService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<PoslovnaGodinaDTO> getPoslovnaGodina(@PathVariable Long id) {
        log.debug("REST request to get PoslovnaGodina : {}", id);
        Optional<PoslovnaGodinaDTO> poslovnaGodinaDTO = poslovnaGodinaService.findOne(id);
        /*if(poslovnaGodinaDTO.isEmpty()) {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }*/
        return ResponseEntity
                .ok()
                .body(poslovnaGodinaDTO.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePoslovnaGodina(@PathVariable Long id) {
        log.debug("REST request to delete PoslovnaGodina : {}", id);
        poslovnaGodinaService.delete(id);
        return ResponseEntity
            .noContent()
            .build();
    }
}
