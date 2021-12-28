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

import pi.likvidatura.repository.BankarskiRacunRepository;
import pi.likvidatura.service.BankarskiRacunService;
import pi.likvidatura.service.dto.BankarskiRacunDTO;
/**
 * REST controller for managing {@link pi.likvidatura.domain.BankarskiRacun}.
 */
@RestController
@RequestMapping("/api/bankarski-racuni")
public class BankarskiRacunController {

    private final Logger log = LoggerFactory.getLogger(BankarskiRacunController.class);

    private final BankarskiRacunService bankarskiRacunService;
    private final BankarskiRacunRepository bankarskiRacunRepository;

    public BankarskiRacunController(BankarskiRacunService bankarskiRacunService, BankarskiRacunRepository bankarskiRacunRepository) {
        this.bankarskiRacunService = bankarskiRacunService;
        this.bankarskiRacunRepository = bankarskiRacunRepository;
    }


    @PostMapping()
    public ResponseEntity<BankarskiRacunDTO> createBankarskiRacun(@RequestBody BankarskiRacunDTO bankarskiRacunDTO)
        throws URISyntaxException {
        log.debug("REST request to save BankarskiRacun : {}", bankarskiRacunDTO);
        if (bankarskiRacunDTO.getId() != null) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        BankarskiRacunDTO result = bankarskiRacunService.save(bankarskiRacunDTO);
        return ResponseEntity
            .created(new URI("/api/bankarski-racuni/" + result.getId()))
            .body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BankarskiRacunDTO> updateBankarskiRacun(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody BankarskiRacunDTO bankarskiRacunDTO
    ) throws URISyntaxException {
        log.debug("REST request to update BankarskiRacun : {}, {}", id, bankarskiRacunDTO);
        if (bankarskiRacunDTO.getId() == null) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!Objects.equals(id, bankarskiRacunDTO.getId())) {
        	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (!bankarskiRacunRepository.existsById(id)) {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        BankarskiRacunDTO result = bankarskiRacunService.save(bankarskiRacunDTO);
        return ResponseEntity
            .ok()
            .body(result);
    }

    @GetMapping()
    public List<BankarskiRacunDTO> getAllBankarskiRacuni() {
        log.debug("REST request to get all BankarskiRacuns");
        return bankarskiRacunService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankarskiRacunDTO> getBankarskiRacun(@PathVariable Long id) {
        log.debug("REST request to get BankarskiRacun : {}", id);
        Optional<BankarskiRacunDTO> bankarskiRacunDTO = bankarskiRacunService.findOne(id);
        /*if(bankarskiRacunDTO.isEmpty()) {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }*/
        return ResponseEntity
                .ok()
                .body(bankarskiRacunDTO.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBankarskiRacun(@PathVariable Long id) {
        log.debug("REST request to delete BankarskiRacun : {}", id);
        bankarskiRacunService.delete(id);
        return ResponseEntity
            .noContent()
            .build();
    }
}
