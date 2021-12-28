package pi.likvidatura.service;

import java.util.List;
import java.util.Optional;
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

    /**
     * Get all the stavkaIzvodas.
     *
     * @return the list of entities.
     */
    List<StavkaIzvodaDTO> findAll();

    /**
     * Get the "id" stavkaIzvoda.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<StavkaIzvodaDTO> findOne(Long id);

    /**
     * Delete the "id" stavkaIzvoda.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
