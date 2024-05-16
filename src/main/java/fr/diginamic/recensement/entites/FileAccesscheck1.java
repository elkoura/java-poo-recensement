package fr.diginamic.recensement.entites;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileAccesscheck1 {
    public static void main(String[] args) {
        Path pathOri = Paths.get("C:/Users/fouad/OneDrive/Documents/Java2024/java-poo-recensement/src/main/resources/recensement1.csv");
        boolean fileExists = Files.exists(pathOri); // Vérifie si le fichier existe
        System.out.println("Le fichier est accessible: " + fileExists);
    }
}
