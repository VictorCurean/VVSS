package verbrauch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import verbrauch.*;

import java.util.ArrayList;

class BenutzerTest {
    @Test
    void kalkuliereDurchschnittVerbrauch() {
         Benutzer benutzer1 = new Benutzer("Otto","Rausch");

         ArrayList<Modus> audi = new ArrayList<Modus>();
         audi.add(new SportModus());
         audi.add(new EcoModus());
         audi.add(new NormaleModus());
         Fahrzeug Audi = new Fahrzeug("cj-30-pop","schwarz",8,"Audi",audi);

         benutzer1.addFahrezeug(Audi);

         ArrayList<Modus> reno = new ArrayList<Modus>();
         reno.add(new SportModus());
         reno.add(new EcoModus());
         reno.add(new NormaleModus());
         Fahrzeug Reno = new Fahrzeug("cj-99-ren","blau",5,"Reno",reno);

         benutzer1.addFahrezeug(Reno);

         double antwort = benutzer1.kalkuliereDurchschnittVerbrauch(benutzer1.getFahrzeuge(),"cj-30-pop");
         Assertions.assertEquals(8.533333333333333, antwort);

         double ant1 = benutzer1.kalkuliereDurchschnittVerbrauch(benutzer1.getFahrzeuge(),"cj-99-ren");
         Assertions.assertEquals(5.333333333333333, ant1);
    }
    @Test
    void kalkuliereSummeVrebrauchImModus() {
         Benutzer benutzer2 = new Benutzer("Remus","Lup");
         ArrayList<Modus> tesla = new ArrayList<Modus>();
         tesla.add(new SportModus());
         tesla.add(new EcoModus());
         Fahrzeug Tesla = new Fahrzeug("cj-30-abc","rot",12.3,"Tesla",tesla);

         ArrayList<Modus> rangeRover = new ArrayList<Modus>();
         rangeRover.add(new EcoModus());
         rangeRover.add(new NormaleModus());
         Fahrzeug RangeRover = new Fahrzeug("cj-100-mkl","grun",10,"Range Rover",rangeRover);

         benutzer2.addFahrezeug(RangeRover);
         benutzer2.addFahrezeug(Tesla);


         double antwort = benutzer2.kalkuliereSummeVrebrauchImModus(new EcoModus(), benutzer2.getFahrzeuge());
         Assertions.assertEquals(15.61, antwort);

         antwort = benutzer2.kalkuliereSummeVrebrauchImModus(new SportModus(), benutzer2.getFahrzeuge());
         Assertions.assertEquals(18.450000000000003, antwort);

         antwort = benutzer2.kalkuliereSummeVrebrauchImModus(new NormaleModus(), benutzer2.getFahrzeuge());
         Assertions.assertEquals(10, antwort);
    }
}