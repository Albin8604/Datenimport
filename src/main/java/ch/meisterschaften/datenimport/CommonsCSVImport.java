package ch.meisterschaften.datenimport;

import ch.meisterschaften.datenimport.model.User;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommonsCSVImport {

    public static List<?> importData(File file){
        try {
            List<User> result = new ArrayList<>();

            Reader reader = Files.newBufferedReader(file.toPath());
            CSVParser parser = new CSVParser(reader,CSVFormat.DEFAULT.withHeader());
            List<CSVRecord> csvRecords = parser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                User user = new User();
                user.setUsername(csvRecord.get("username"));
                user.setPassword(csvRecord.get("password"));
                result.add(user);
            }

            return result;
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }
}
