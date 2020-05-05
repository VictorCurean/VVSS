package benutzer;

import verbrauch.Benutzer;
import verbrauch.Fahrzeug;
import verbrauch.Modus;

import java.util.ArrayList;

public class AdvancedBenutzer extends Benutzer {

    ExperienceLevel experienceLevel;

    public AdvancedBenutzer(String vorN, String nachN, ExperienceLevel experienceLevel) {
        super(vorN, nachN);
        this.experienceLevel = experienceLevel;
    }

    @Override
    public double kalkuliereDurchschnittVerbrauch(ArrayList<Fahrzeug> f, String idAuto)
    {
        double summe_total = 0;

        for(Fahrzeug automobile : f) {

            if(automobile.getVin().equals(idAuto) && automobile.getModi().size() == 3) {

                ArrayList<Modus> mod = automobile.getModi();

                summe_total += mod.get(0).kalkuliereVerbrauch(automobile.getVerbrauch());
                summe_total += mod.get(1).kalkuliereVerbrauch(automobile.getVerbrauch());
                summe_total += mod.get(2).kalkuliereVerbrauch(automobile.getVerbrauch());
            }
        }

        return (summe_total / 3)*(experienceLevel.getFuelEfficiency()/100);
    }



}
