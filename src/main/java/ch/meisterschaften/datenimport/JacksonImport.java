package ch.meisterschaften.datenimport;

import ch.meisterschaften.datenimport.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;

public class JacksonImport {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static List<User> importData(File file){
        try {
            byte[] bytesOfFile = Files.readAllBytes(file.toPath());
            return OBJECT_MAPPER.readValue(
                    bytesOfFile, OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, User.class)
            );
        } catch (IOException e) {
            System.err.println("Error occurred");
            return Collections.emptyList();
        }
    }
}
