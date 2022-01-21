package pi.likvidatura.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import pi.likvidatura.domain.StavkaIzvoda;
import pi.likvidatura.service.dto.StavkaIzvodaDTO;

/**
 * Service Interface for managing {@link pi.likvidatura.domain.StavkaIzvoda}.
 */
public interface StavkaIzvodaService {
    /**
     * Save a stavkaIzvoda.
     *
     * @param stavkaIzvodaDTO the entity to save.
     * @return the persisted entity.
     */
    StavkaIzvodaDTO save(StavkaIzvodaDTO stavkaIzvodaDTO);
    
    StavkaIzvoda save(StavkaIzvoda stavkaIzvoda);

    /**
     * Get all the stavkaIzvodas.
     *
     * @return the list of entities.
     */
    List<StavkaIzvoda> findAll();

    /**
     * Get the "id" stavkaIzvoda.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<StavkaIzvodaDTO> findOne(Long id);
    
    StavkaIzvoda get(Long id);

    /**
     * Delete the "id" stavkaIzvoda.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
    
    void importStavkeIzvoda();
    
    List<StavkaIzvoda> findByPoziv(String pozivNaBroj);
    
    Page<StavkaIzvoda> findAll(Pageable pageable);
    
    Page<StavkaIzvoda> findAll(Pageable pageable, String searchText);

        
}
