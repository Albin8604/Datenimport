package ch.meisterschaften.datenimport;

import ch.meisterschaften.datenimport.model.User;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;

public class GsonImport {

    private static final Gson GSON = new Gson();

    public static List<User> importData(File file){
        try {
            Reader reader = Files.newBufferedReader(file.toPath());
            List<User> data = GSON.fromJson(reader, List.class);
            reader.close();
            return data;
        } catch (IOException e) {
            System.err.println("Error occurred");
            return Collections.emptyList();
        }
    }
}
