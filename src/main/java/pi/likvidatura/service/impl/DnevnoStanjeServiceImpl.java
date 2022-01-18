package pi.likvidatura.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.text.DateFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pi.likvidatura.domain.BankarskiRacun;
import pi.likvidatura.domain.DnevnoStanje;
import pi.likvidatura.repository.DnevnoStanjeRepository;
import pi.likvidatura.service.BankarskiRacunService;
import pi.likvidatura.service.DnevnoStanjeService;
import pi.likvidatura.service.dto.DnevnoStanjeDTO;
import pi.likvidatura.service.mapper.DnevnoStanjeMapper;

/**
 * Service Implementation for managing {@link DnevnoStanje}.
 */
@Service
@Transactional
public class DnevnoStanjeServiceImpl implements DnevnoStanjeService {

    private final Logger log = LoggerFactory.getLogger(DnevnoStanjeServiceImpl.class);

    private final DnevnoStanjeRepository dnevnoStanjeRepository;

    private final DnevnoStanjeMapper dnevnoStanjeMapper;
    
    private final BankarskiRacunService bankarskiRacunService;

    
    
    String line = "";

    public DnevnoStanjeServiceImpl(DnevnoStanjeRepository dnevnoStanjeRepository, DnevnoStanjeMapper dnevnoStanjeMapper, BankarskiRacunService bankarskiRacunService) {
        this.dnevnoStanjeRepository = dnevnoStanjeRepository;
        this.dnevnoStanjeMapper = dnevnoStanjeMapper;
        this.bankarskiRacunService = bankarskiRacunService;
    }

    /*@Override
    public DnevnoStanjeDTO save(DnevnoStanjeDTO dnevnoStanjeDTO) {
        log.debug("Request to save DnevnoStanje : {}", dnevnoStanjeDTO);
        DnevnoStanje dnevnoStanje = dnevnoStanjeMapper.toEntity(dnevnoStanjeDTO);
        dnevnoStanje = dnevnoStanjeRepository.save(dnevnoStanje);
        return dnevnoStanjeMapper.toDto(dnevnoStanje);
    }*/
    
    @Override
    public DnevnoStanje save(DnevnoStanje dnevnoStanje) {
        log.debug("Request to save DnevnoStanje : {}", dnevnoStanje);
        return dnevnoStanje = dnevnoStanjeRepository.save(dnevnoStanje);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DnevnoStanje> findAll() {
        log.debug("Request to get all");
        return dnevnoStanjeRepository.findAll();
        		/*.stream().map(dnevnoStanjeMapper::toDto).collect(Collectors.toCollection(LinkedList::new));*/
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DnevnoStanjeDTO> findOne(Long id) {
        log.debug("Request to get DnevnoStanje : {}", id);
        return dnevnoStanjeRepository.findById(id).map(dnevnoStanjeMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete DnevnoStanje : {}", id);
        dnevnoStanjeRepository.deleteById(id);
    }

	@Override
	public void importDnevnoStanjeData() {
		try {
		BufferedReader br = new BufferedReader(new FileReader("src/main/resources/ZaImport.csv"));
		while((line = br.readLine())!=null) {
			String [] data = line.split(",");
			//DnevnoStanjeDTO dnevnoStanjeDTO = new DnevnoStanjeDTO();
			//DnevnoStanje dnevnoStanje = dnevnoStanjeMapper.toEntity(dnevnoStanjeDTO);
			DnevnoStanje dnevnoStanje = new DnevnoStanje();
			Integer brojIzvoda = Integer.parseInt(data[0]);
			dnevnoStanje.setBrojIzvoda(brojIzvoda);
			dnevnoStanje.setDatumIzvoda(LocalDate.parse(data[1]));
			dnevnoStanje.setNovoStanje(Double.parseDouble(data[2]));
			dnevnoStanje.setPrethodnoStanje(Double.parseDouble(data[3]));
			dnevnoStanje.setPrometNaTeret(Double.parseDouble(data[4]));
			dnevnoStanje.setPrometUKorist(Double.parseDouble(data[5]));
			dnevnoStanje.setRezervisano(Double.parseDouble(data[6]));
			long bankarskiRacunId = Integer.parseInt(data[7]);
			BankarskiRacun bankarskiRacun = bankarskiRacunService.findOne3(bankarskiRacunId);
			dnevnoStanje.setBankarskiRacun(bankarskiRacun);
			dnevnoStanje = dnevnoStanjeRepository.save(dnevnoStanje);

		}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public DnevnoStanjeDTO save(DnevnoStanjeDTO dnevnoStanjeDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DnevnoStanje get(Long id) {
		return dnevnoStanjeRepository.findById(id).orElse(null);

	}
	
	
}
