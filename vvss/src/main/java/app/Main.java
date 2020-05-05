package app;

import benutzer.AdvancedBenutzer;
import benutzer.Beginner;
import benutzer.Proficient;
import verbrauch.*;
import builder.FahrzeugBuilder;

public class Main {
    public static void main(String[] args) {

        Modus eco = new EcoModus();
        Modus normal = new NormaleModus();
        Modus sport = new SportModus();

        Fahrzeug fahrzeug1 = FahrzeugBuilder.getInstance().withVin("AAA").withFarbe("blau").withMarke("audi").withVerbrauch(12.0)
                .withModus(eco)
                .withModus(normal).withModus(sport).build();

        Fahrzeug fahrzeug2 = FahrzeugBuilder.getInstance().withVin("BBB").withFarbe("gelb").withMarke("mercedes").withVerbrauch(10.0)
                .withModus(eco)
                .withModus(normal).withModus(sport).build();

        AdvancedBenutzer benutzer = new AdvancedBenutzer("Thomas", "Hilde", new Proficient());
        benutzer.getFahrzeuge().add(fahrzeug1);
        benutzer.getFahrzeuge().add(fahrzeug2);

        System.out.println(benutzer.kalkuliereDurchschnittVerbrauch(benutzer.getFahrzeuge(), "BBB"));



    }
}
