package pi.likvidatura.web.rest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pi.likvidatura.domain.CSVHelper;
import pi.likvidatura.domain.DnevnoStanje;
import pi.likvidatura.domain.ResponseMessage;
import pi.likvidatura.domain.StavkaIzvoda;
import pi.likvidatura.service.CSVService;

/*@CrossOrigin("http://localhost:8080")*/
@CrossOrigin(origins="http://localhost:3000")
@Controller
@RequestMapping("/api/csv")
public class CSVController {

  @Autowired
  CSVService fileService;

  @PostMapping("/upload")
  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
    String message = "";

    if (CSVHelper.hasCSVFormat(file)) {
      try {
        fileService.save(file);

        message = "Uploaded the file successfully: " + file.getOriginalFilename();
        
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/csv/download/")
                .path(file.getOriginalFilename())
                .toUriString();

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message,fileDownloadUri));
      } catch (Exception e) {
        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message,""));
      }
    }

    message = "Please upload a csv file!";
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message,""));
  }

  @GetMapping("/stavke")
  public ResponseEntity<List<StavkaIzvoda>> getAllStavke() {
    try {
      List<StavkaIzvoda> stavke = fileService.getAllStavke();

      if (stavke.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(stavke, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/download/{fileName:.+}")
  public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) {
    InputStreamResource file = new InputStreamResource(fileService.load());

    /*try {
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
	}*/
    
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
        .contentType(MediaType.parseMediaType("application/csv"))
        .body(file);
  }
}