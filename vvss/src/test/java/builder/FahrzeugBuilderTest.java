package builder;

import org.junit.jupiter.api.Test;
import verbrauch.*;

import static org.junit.jupiter.api.Assertions.*;

class FahrzeugBuilderTest {

    @Test
    void getInstance() {
        assertSame(FahrzeugBuilder.getInstance().getClass(), FahrzeugBuilder.class);
    }

    @Test
    void build() {
        Modus eco = new EcoModus();
        Modus normal = new NormaleModus();
        Modus sport = new SportModus();

        Fahrzeug fahrzeugOK = FahrzeugBuilder.getInstance().withVin("AAA").withFarbe("blau").withMarke("audi").withVerbrauch(12.0)
                .withModus(eco)
                .withModus(normal).withModus(sport).build();

        assertEquals(12.0, fahrzeugOK.getVerbrauch());
        assertEquals("blau", fahrzeugOK.getFarbe());
        assertEquals("AAA", fahrzeugOK.getVin());

        assertThrows(IllegalStateException.class, () -> {
            Fahrzeug fahrzeugERROR = FahrzeugBuilder.getInstance().withVin("AAA").withFarbe("blau").withMarke("audi").withVerbrauch(12.0)
                    .withModus(normal).withModus(sport).build();
        });
    }
}