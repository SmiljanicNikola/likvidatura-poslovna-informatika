package pi.likvidatura.service;

import java.util.List;
import java.util.Optional;
import pi.likvidatura.service.dto.PreduzeceDTO;

/**
 * Service Interface for managing {@link pi.likvidatura.domain.Preduzece}.
 */
public interface PreduzeceService {
    /**
     * Save a preduzece.
     *
     * @param preduzeceDTO the entity to save.
     * @return the persisted entity.
     */
    PreduzeceDTO save(PreduzeceDTO preduzeceDTO);

    /**
     * Get all the preduzeces.
     *
     * @return the list of entities.
     */
    List<PreduzeceDTO> findAll();

    /**
     * Get the "id" preduzece.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PreduzeceDTO> findOne(Long id);

    /**
     * Delete the "id" preduzece.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
