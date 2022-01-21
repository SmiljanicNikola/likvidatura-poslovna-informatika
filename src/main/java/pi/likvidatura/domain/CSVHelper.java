package pi.likvidatura.domain;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;


public class CSVHelper {
  public static String TYPE = "text/csv";
  static String[] HEADERs = { "BrojStavke", "Iznos", "PreostaliIznos", "Duznik", "Primalac", "RacunDuznika", "RacunPrimaoca", "SvrhaPlacanja", "Model", "PozivNaBroj", "Proknjizeno"};

  public static boolean hasCSVFormat(MultipartFile file) {
    if (TYPE.equals(file.getContentType())
    		|| file.getContentType().equals("application/vnd.ms-excel")) {
      return true;
    }

    return false;
  }

  public static List<StavkaIzvoda> csvToStavke(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

      List<StavkaIzvoda> stavkeList = new ArrayList<>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      for (CSVRecord csvRecord : csvRecords) {
    	  StavkaIzvoda stavka = new StavkaIzvoda(
              //Long.parseLong(csvRecord.get("Id")),
              Integer.parseInt(csvRecord.get("BrojStavke")),
              Double.parseDouble(csvRecord.get("Iznos")),
              Double.parseDouble(csvRecord.get("PreostaliIznos")),
              csvRecord.get("Duznik"),
              csvRecord.get("Primalac"),
              csvRecord.get("RacunDuznika"),
              csvRecord.get("RacunPrimaoca"),
              csvRecord.get("SvrhaPlacanja"),
              Integer.parseInt(csvRecord.get("Model")),
              csvRecord.get("PozivNaBroj"),
              Boolean.parseBoolean(csvRecord.get("Proknjizeno"))
            );

    	  stavkeList.add(stavka);
      }

      return stavkeList;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }

  public static ByteArrayInputStream StavkeToCSV(List<StavkaIzvoda> stavkeList) {
    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
      for (StavkaIzvoda stavka : stavkeList) {
        List<String> data = Arrays.asList(
        	  String.valueOf(stavka.getBrojStavke()),
        	  String.valueOf(stavka.getIznos()),
              String.valueOf(stavka.getPreostaliIznos()),
              stavka.getDuznik(),
              stavka.getPrimalac(),
              stavka.getRacunDuznika(),
              stavka.getRacunPrimaoca(),
              stavka.getSvrhaPlacanja(),
              String.valueOf(stavka.getModel()),
              stavka.getPozivNaBroj(),
              String.valueOf(stavka.isProknjizeno())
            );

        csvPrinter.printRecord(data);
      }

      csvPrinter.flush();
      return new ByteArrayInputStream(out.toByteArray());
    } catch (IOException e) {
      throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
    }
  }
}
