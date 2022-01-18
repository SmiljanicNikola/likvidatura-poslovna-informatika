package pi.likvidatura.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pi.likvidatura.domain.DnevnoStanje;
import pi.likvidatura.domain.StavkaIzvoda;
import pi.likvidatura.repository.StavkaIzvodaRepository;
import pi.likvidatura.repository.StavkaIzvodaRepository2;
import pi.likvidatura.repository.StavkaIzvodaRepositoryPaging;
import pi.likvidatura.service.DnevnoStanjeService;
import pi.likvidatura.service.StavkaIzvodaService;
import pi.likvidatura.service.dto.StavkaIzvodaDTO;
import pi.likvidatura.service.mapper.StavkaIzvodaMapper;

/**
 * Service Implementation for managing {@link StavkaIzvoda}.
 */
@Service
@Transactional
public class StavkaIzvodaServiceImpl implements StavkaIzvodaService {

    private final Logger log = LoggerFactory.getLogger(StavkaIzvodaServiceImpl.class);

    private final StavkaIzvodaRepository stavkaIzvodaRepository;
    
    private final StavkaIzvodaRepository2 stavkaIzvodaRepository2;
    
    private final DnevnoStanjeService dnevnoStanjeService;
    
    private final StavkaIzvodaRepositoryPaging stavkaIzvodaRepositoryPaging;

    private final StavkaIzvodaMapper stavkaIzvodaMapper;
    
    String line = "";


    public StavkaIzvodaServiceImpl(StavkaIzvodaRepository stavkaIzvodaRepository, StavkaIzvodaMapper stavkaIzvodaMapper, StavkaIzvodaRepository2 stavkaIzvodaRepository2,DnevnoStanjeService dnevnoStanjeService, StavkaIzvodaRepositoryPaging stavkaIzvodaRepositoryPaging) {
        this.stavkaIzvodaRepository = stavkaIzvodaRepository;
        this.stavkaIzvodaMapper = stavkaIzvodaMapper;
        this.stavkaIzvodaRepository2 = stavkaIzvodaRepository2;
        this.dnevnoStanjeService = dnevnoStanjeService;
        this.stavkaIzvodaRepositoryPaging = stavkaIzvodaRepositoryPaging;
    }

    @Override
    public StavkaIzvodaDTO save(StavkaIzvodaDTO stavkaIzvodaDTO) {
        log.debug("Request to save StavkaIzvoda : {}", stavkaIzvodaDTO);
        StavkaIzvoda stavkaIzvoda = stavkaIzvodaMapper.toEntity(stavkaIzvodaDTO);
        stavkaIzvoda = stavkaIzvodaRepository.save(stavkaIzvoda);
        return stavkaIzvodaMapper.toDto(stavkaIzvoda);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StavkaIzvoda> findAll() {
        log.debug("Request to get all");
        return stavkaIzvodaRepository.findAll();
        		/*.stream()
        		.map(stavkaIzvodaMapper::toDto)
        		.collect(Collectors.toCollection(LinkedList::new));*/
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<StavkaIzvodaDTO> findOne(Long id) {
        log.debug("Request to get StavkaIzvoda : {}", id);
        return stavkaIzvodaRepository.findById(id).map(stavkaIzvodaMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete StavkaIzvoda : {}", id);
        stavkaIzvodaRepository.deleteById(id);
    }

	@Override
	public List<StavkaIzvoda> findByPoziv(String pozivNaBroj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StavkaIzvoda save(StavkaIzvoda stavkaIzvoda) {
		return stavkaIzvoda = stavkaIzvodaRepository.save(stavkaIzvoda);
	}

	@Override
	public StavkaIzvoda get(Long id) {
		return stavkaIzvodaRepository.findById(id).orElse(null);
	}

	@Override
	public void importStavkeIzvoda() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/ZaImportStavkeIzvoda.csv"));
			while((line = br.readLine())!=null){
				String[] data = line.split(",");
				StavkaIzvoda stavkaIzvoda = new StavkaIzvoda();
				Integer brojStavke = Integer.parseInt(data[0]);
				stavkaIzvoda.setBrojStavke(brojStavke);
				stavkaIzvoda.setDuznik(data[1]);
				stavkaIzvoda.setIznos(Double.parseDouble(data[2]));
				stavkaIzvoda.setModel(Integer.parseInt(data[3]));
				stavkaIzvoda.setPozivNaBroj(data[4]);
				stavkaIzvoda.setPrimalac(data[5]);
				stavkaIzvoda.setRacunDuznika(data[6]);
				stavkaIzvoda.setRacunPrimaoca(data[7]);
				stavkaIzvoda.setSvrhaPlacanja(data[8]);
				stavkaIzvoda.setProknjizeno(Boolean.parseBoolean(data[9]));
				long dnevnoStanjeId = Integer.parseInt(data[10]);
				DnevnoStanje dnevnoStanje = dnevnoStanjeService.get(dnevnoStanjeId);
				stavkaIzvoda.setDnevnoStanje(dnevnoStanje);
				stavkaIzvoda = stavkaIzvodaRepository.save(stavkaIzvoda);

			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	@Override
	public Page<StavkaIzvoda> findAll(Pageable pageable) {
		return stavkaIzvodaRepositoryPaging.findAll(pageable);
		
	}

	

}
