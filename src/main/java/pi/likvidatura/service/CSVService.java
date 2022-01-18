package pi.likvidatura.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import pi.likvidatura.domain.CSVHelper;
import pi.likvidatura.domain.StavkaIzvoda;
import pi.likvidatura.repository.StavkaIzvodaRepository;

@Service
public class CSVService {
  @Autowired
  StavkaIzvodaRepository stavkaIzvodaRepository;

  public void save(MultipartFile file) {
    try {
      List<StavkaIzvoda> stavke = CSVHelper.csvToStavke(file.getInputStream());
      stavkaIzvodaRepository.saveAll(stavke);
    } catch (IOException e) {
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
  }

  public ByteArrayInputStream load() {
    List<StavkaIzvoda> stavke = stavkaIzvodaRepository.findAll();

    ByteArrayInputStream in = CSVHelper.StavkeToCSV(stavke);
    return in;
  }

  public List<StavkaIzvoda> getAllStavke() {
    return stavkaIzvodaRepository.findAll();
  }
}