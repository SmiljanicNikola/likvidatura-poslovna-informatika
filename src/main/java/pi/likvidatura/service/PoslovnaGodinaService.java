package pi.likvidatura.service;

import java.util.List;
import java.util.Optional;

import pi.likvidatura.domain.PoslovnaGodina;
import pi.likvidatura.service.dto.PoslovnaGodinaDTO;

/**
 * Service Interface for managing {@link pi.likvidatura.domain.PoslovnaGodina}.
 */
public interface PoslovnaGodinaService {
    /**
     * Save a poslovnaGodina.
     *
     * @param poslovnaGodinaDTO the entity to save.
     * @return the persisted entity.
     */
    PoslovnaGodinaDTO save(PoslovnaGodinaDTO poslovnaGodinaDTO);

    /**
     * Get all the poslovnaGodinas.
     *
     * @return the list of entities.
     */
    List<PoslovnaGodina> findAll();

    /**
     * Get the "id" poslovnaGodina.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PoslovnaGodinaDTO> findOne(Long id);

    /**
     * Delete the "id" poslovnaGodina.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
