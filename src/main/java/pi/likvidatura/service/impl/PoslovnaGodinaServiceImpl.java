package pi.likvidatura.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pi.likvidatura.domain.PoslovnaGodina;
import pi.likvidatura.repository.PoslovnaGodinaRepository;
import pi.likvidatura.service.PoslovnaGodinaService;
import pi.likvidatura.service.dto.PoslovnaGodinaDTO;
import pi.likvidatura.service.mapper.PoslovnaGodinaMapper;

/**
 * Service Implementation for managing {@link PoslovnaGodina}.
 */
@Service
@Transactional
public class PoslovnaGodinaServiceImpl implements PoslovnaGodinaService {

    private final Logger log = LoggerFactory.getLogger(PoslovnaGodinaServiceImpl.class);

    private final PoslovnaGodinaRepository poslovnaGodinaRepository;

    private final PoslovnaGodinaMapper poslovnaGodinaMapper;

    public PoslovnaGodinaServiceImpl(PoslovnaGodinaRepository poslovnaGodinaRepository, PoslovnaGodinaMapper poslovnaGodinaMapper) {
        this.poslovnaGodinaRepository = poslovnaGodinaRepository;
        this.poslovnaGodinaMapper = poslovnaGodinaMapper;
    }

    @Override
    public PoslovnaGodinaDTO save(PoslovnaGodinaDTO poslovnaGodinaDTO) {
        log.debug("Request to save PoslovnaGodina : {}", poslovnaGodinaDTO);
        PoslovnaGodina poslovnaGodina = poslovnaGodinaMapper.toEntity(poslovnaGodinaDTO);
        poslovnaGodina = poslovnaGodinaRepository.save(poslovnaGodina);
        return poslovnaGodinaMapper.toDto(poslovnaGodina);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PoslovnaGodina> findAll() {
        log.debug("Request to get all");
        return poslovnaGodinaRepository
            .findAll();
            /*.stream()
            .map(poslovnaGodinaMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));*/
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PoslovnaGodinaDTO> findOne(Long id) {
        log.debug("Request to get PoslovnaGodina : {}", id);
        return poslovnaGodinaRepository.findById(id).map(poslovnaGodinaMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete PoslovnaGodina : {}", id);
        poslovnaGodinaRepository.deleteById(id);
    }
}
