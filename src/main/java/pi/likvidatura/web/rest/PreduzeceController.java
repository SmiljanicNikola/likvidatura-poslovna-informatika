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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pi.likvidatura.repository.PreduzeceRepository;
import pi.likvidatura.service.PreduzeceService;
import pi.likvidatura.service.dto.PreduzeceDTO;
/**
 * REST controller for managing {@link pi.likvidatura.domain.Preduzece}.
 */
@RestController
@RequestMapping("/api/preduzeca")
public class PreduzeceController {

    private final Logger log = LoggerFactory.getLogger(PreduzeceController.class);

    private final PreduzeceService preduzeceService;

    private final PreduzeceRepository preduzeceRepository;

    public PreduzeceController(PreduzeceService preduzeceService, PreduzeceRepository preduzeceRepository) {
        this.preduzeceService = preduzeceService;
        this.preduzeceRepository = preduzeceRepository;
    }

    @PostMapping()
    public ResponseEntity<PreduzeceDTO> createPreduzece(@RequestBody PreduzeceDTO preduzeceDTO) throws URISyntaxException {
        log.debug("REST request to save Preduzece : {}", preduzeceDTO);
        if (preduzeceDTO.getId() != null) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        PreduzeceDTO result = preduzeceService.save(preduzeceDTO);
        return ResponseEntity
            .created(new URI("/api/preduzeca/" + result.getId()))
            .body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PreduzeceDTO> updatePreduzece(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody PreduzeceDTO preduzeceDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Preduzece : {}, {}", id, preduzeceDTO);
        if (preduzeceDTO.getId() == null) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!Objects.equals(id, preduzeceDTO.getId())) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (!preduzeceRepository.existsById(id)) {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        PreduzeceDTO result = preduzeceService.save(preduzeceDTO);
        return ResponseEntity
            .ok()
            .body(result);
    }

    @GetMapping()
    public List<PreduzeceDTO> getAllPreduzeca() {
        log.debug("REST request to get all");
        return preduzeceService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PreduzeceDTO> getPreduzece(@PathVariable Long id) {
        Optional<PreduzeceDTO> preduzeceDTO = preduzeceService.findOne(id);
        /*if(preduzeceDTO.isEmpty()) {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }*/
        return ResponseEntity
                .ok()
                .body(preduzeceDTO.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePreduzece(@PathVariable Long id) {
        log.debug("REST request to delete Preduzece : {}", id);
        preduzeceService.delete(id);
        return ResponseEntity
            .noContent()
            .build();
    }
}
