//1. Написать функцию, создающую резервную копию всех файлов в директории во вновь созданную папку ./backup

import jdk.javadoc.internal.doclets.toolkit.util.DocFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;



public class Main {
    public static void main(String[] args) {
        Path route = Paths.get("./backup");
        Path directory = Paths.get("./files");
        createBackup(directory, route);
    }

    static void createBackup(Path directory, Path route) {
        try {
            Files.createDirectories(route);
        } catch (IOException e) {
            e.printStackTrace();
        }

        File sourceDir = new File(directory.toString());
        File[] filesToBackup = directory.toFile().listFiles();

        for (File file : filesToBackup) {
            if (file.isFile()) {
                try {
                    Files.copy(file.toPath(), route.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Резервная копия создана!");
    }
}


