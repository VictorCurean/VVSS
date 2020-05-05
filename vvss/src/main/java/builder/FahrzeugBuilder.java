package builder;

import verbrauch.Fahrzeug;
import verbrauch.Modus;

public class FahrzeugBuilder {

    private Fahrzeug fahrzeugInstance;

    private FahrzeugBuilder(Fahrzeug fahrzeug) {
        this.fahrzeugInstance = fahrzeug;
    }

    public static FahrzeugBuilder getInstance() {
        Fahrzeug fahrzeugInstance = new Fahrzeug();
        return new FahrzeugBuilder(fahrzeugInstance);
    }

    public FahrzeugBuilder withVin(String vin) {
        this.fahrzeugInstance.setVin(vin);
        return this;
    }

    public FahrzeugBuilder withFarbe(String farbe) {
        this.fahrzeugInstance.setFarbe(farbe);
        return this;
    }

    public FahrzeugBuilder withVerbrauch(Double verbrauch) {
        this.fahrzeugInstance.setVerbrauch(verbrauch);
        return this;
    }

    public FahrzeugBuilder withMarke(String marke) {
        this.fahrzeugInstance.setMarke(marke);
        return this;
    }

    public FahrzeugBuilder withModus(Modus modus) {
        this.fahrzeugInstance.getModi().add(modus);
        return this;
    }

    public Fahrzeug build() {
        if (this.fahrzeugInstance.getModi().size() != 3) {
            throw new IllegalStateException("Fahrzeug Class must contain 3 individuals Modes");
        }
        return this.fahrzeugInstance;
    }
}
