package benutzer;

import builder.FahrzeugBuilder;
import org.junit.jupiter.api.Test;
import verbrauch.*;

import static org.junit.jupiter.api.Assertions.*;

class AdvancedBenutzerTest {

    @Test
    void kalkuliereDurchschnittVerbrauch() {
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
}