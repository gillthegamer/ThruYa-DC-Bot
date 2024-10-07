package eu.ygames;

import eu.ygames.jda.JDABuild;
import eu.ygames.utils.Settings;

public class Main {
    public static void main(String[] args) {
        // Variablen für Parameter
        String configFilePath = null;

        // Übergebene Parameter verarbeiten
        for (int i = 0; i < args.length; i++) {
            if ("-s".equals(args[i]) && i + 1 < args.length) {
                configFilePath = args[i + 1];  // Nächstes Argument ist der Pfad zur Konfigurationsdatei
                i++;  // Überspringe das nächste Argument, da es der Wert von "-s" ist
            }
        }

        // Beispielhafte Ausgabe
        if (configFilePath == null) {
            configFilePath = "config.properties";
        }

        new Settings(configFilePath);
        JDABuild.JDAConfigure();
    }
}
