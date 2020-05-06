package app;

import benutzer.AdvancedBenutzer;
import benutzer.Beginner;
import benutzer.Proficient;
import builder.FahrzeugBuilder;
import org.junit.jupiter.api.Test;
import verbrauch.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main() {
        Modus eco = new EcoModus();
        Modus normal = new NormaleModus();
        Modus sport = new SportModus();

        Fahrzeug fahrzeug1 = FahrzeugBuilder.getInstance().withVin("AAA").withFarbe("blau").withMarke("audi").withVerbrauch(12.0)
                .withModus(eco)
                .withModus(normal).withModus(sport).build();

        Fahrzeug fahrzeug2 = FahrzeugBuilder.getInstance().withVin("BBB").withFarbe("gelb").withMarke("mercedes").withVerbrauch(10.0)
                .withModus(eco)
                .withModus(normal).withModus(sport).build();

        AdvancedBenutzer benutzer1 = new AdvancedBenutzer("Thomas", "Hilde", new Proficient());
        benutzer1.getFahrzeuge().add(fahrzeug1);
        benutzer1.getFahrzeuge().add(fahrzeug2);
        AdvancedBenutzer benutzer2 = new AdvancedBenutzer("Helmuth", "Lagerfeld", new Beginner());
        benutzer2.getFahrzeuge().add(fahrzeug1);
        benutzer2.getFahrzeuge().add(fahrzeug2);

        assertEquals(12.799999999999999, benutzer1.kalkuliereDurchschnittVerbrauch(benutzer1.getFahrzeuge(), "AAA"));
        assertEquals(10.666666666666666, benutzer1.kalkuliereDurchschnittVerbrauch(benutzer1.getFahrzeuge(), "BBB"));

        assertEquals(9.6, benutzer2.kalkuliereDurchschnittVerbrauch(benutzer1.getFahrzeuge(), "AAA"));
        assertEquals(8.0, benutzer2.kalkuliereDurchschnittVerbrauch(benutzer1.getFahrzeuge(), "BBB"));
    }

    @Test void mainTopDown() {
        Modus eco = new EcoModus();
        Modus normal = new NormaleModus();
        Modus sport = new SportModus();

        Fahrzeug fahrzeug1 = FahrzeugBuilder.getInstance().withVin("AAA").withFarbe("blau").withMarke("audi").withVerbrauch(12.0)
                .withModus(eco)
                .withModus(normal).withModus(sport).build();

        Fahrzeug fahrzeug2 = FahrzeugBuilder.getInstance().withVin("BBB").withFarbe("gelb").withMarke("mercedes").withVerbrauch(10.0)
                .withModus(eco)
                .withModus(normal).withModus(sport).build();

        Benutzer benutzer1 = new Benutzer("Thomas", "Hilde");
        benutzer1.getFahrzeuge().add(fahrzeug1);
        benutzer1.getFahrzeuge().add(fahrzeug2);
        Benutzer benutzer2 = new Benutzer("Helmuth", "Lagerfeld");
        benutzer2.getFahrzeuge().add(fahrzeug1);
        benutzer2.getFahrzeuge().add(fahrzeug2);

        assertEquals(12.799999999999999, benutzer1.kalkuliereDurchschnittVerbrauch(benutzer1.getFahrzeuge(), "AAA"));
        assertEquals(10.666666666666666, benutzer1.kalkuliereDurchschnittVerbrauch(benutzer1.getFahrzeuge(), "BBB"));

        assertEquals(12.799999999999999, benutzer2.kalkuliereDurchschnittVerbrauch(benutzer1.getFahrzeuge(), "AAA"));
        assertEquals(10.666666666666666, benutzer2.kalkuliereDurchschnittVerbrauch(benutzer1.getFahrzeuge(), "BBB"));


        Modus eco2 = new EcoModus();
        Modus normal2 = new NormaleModus();
        Modus sport2 = new SportModus();

        Fahrzeug fahrzeug3 = FahrzeugBuilder.getInstance().withVin("AAA").withFarbe("blau").withMarke("audi").withVerbrauch(12.0)
                .withModus(eco2)
                .withModus(normal2).withModus(sport2).build();

        Fahrzeug fahrzeug4 = FahrzeugBuilder.getInstance().withVin("BBB").withFarbe("gelb").withMarke("mercedes").withVerbrauch(10.0)
                .withModus(eco2)
                .withModus(normal2).withModus(sport2).build();

        AdvancedBenutzer benutzer3 = new AdvancedBenutzer("Thomas", "Hilde", new Proficient());
        benutzer3.getFahrzeuge().add(fahrzeug1);
        benutzer3.getFahrzeuge().add(fahrzeug2);
        AdvancedBenutzer benutzer4 = new AdvancedBenutzer("Helmuth", "Lagerfeld", new Beginner());
        benutzer4.getFahrzeuge().add(fahrzeug1);
        benutzer4.getFahrzeuge().add(fahrzeug2);

        assertEquals(12.799999999999999, benutzer1.kalkuliereDurchschnittVerbrauch(benutzer1.getFahrzeuge(), "AAA"));
        assertEquals(10.666666666666666, benutzer1.kalkuliereDurchschnittVerbrauch(benutzer1.getFahrzeuge(), "BBB"));

        assertEquals(12.799999999999999, benutzer2.kalkuliereDurchschnittVerbrauch(benutzer1.getFahrzeuge(), "AAA"));
        assertEquals(10.666666666666666, benutzer2.kalkuliereDurchschnittVerbrauch(benutzer1.getFahrzeuge(), "BBB"));

    }


}