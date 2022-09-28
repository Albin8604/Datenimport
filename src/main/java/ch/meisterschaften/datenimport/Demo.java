package ch.meisterschaften.datenimport;

import ch.meisterschaften.datenimport.model.User;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Demo {
    public static final File JSON_IMPORT_FILE = new File("src/main/resources/ImportTest.json");
    public static final File CSV_IMPORT_FILE = new File("src/main/resources/ImportTest.csv");

    public static void main(String[] args) {
        new Demo().run();
    }

    private void run(){
        System.out.println(JSON_IMPORT_FILE.getAbsolutePath());

        System.out.println("Jackson:");
        printList(JacksonImport.importData(JSON_IMPORT_FILE));

        System.out.println("Gson:");
        printList(GsonImport.importData(JSON_IMPORT_FILE));

        System.out.println("CommonsCSV:");
        printList(CommonsCSVImport.importData(CSV_IMPORT_FILE));

        System.out.println("ManuellCSV:");
        printList(ManuellCSVImport.importData(CSV_IMPORT_FILE));
    }

    private void printList (List<?> list){
        System.out.println(Arrays.toString(list.toArray()));
    }
}