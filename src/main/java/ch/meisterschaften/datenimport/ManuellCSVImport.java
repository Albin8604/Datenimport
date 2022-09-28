package ch.meisterschaften.datenimport;

import ch.meisterschaften.datenimport.model.User;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManuellCSVImport {
    private static final String DELIMITER = ",";
    private static final boolean SKIP_FIRST_LINE = true;

    public static List<?> importData(File file) {
        try {
            List<User> result = new ArrayList<>();

            List<String> fileLines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);

            for (String line : fileLines) {
                if (SKIP_FIRST_LINE && fileLines.indexOf(line) == 0) {
                    continue;
                }
                String[] values = line.split(DELIMITER);

                User user = new User();
                user.setUsername(values[0]);
                user.setPassword(values[1]);
                result.add(user);
            }

            return result;
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }
}
