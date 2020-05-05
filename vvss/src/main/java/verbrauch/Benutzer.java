package verbrauch;

import java.util.ArrayList;

public class Benutzer {

    private String vorName;
    private String nachName;
    private ArrayList <Fahrzeug> fahrzeuge = new ArrayList<>();
    public Benutzer(String vorN, String nachN)//, ArrayList<verbrauch.Fahrzeug> f)
    {
        super();
        vorName = vorN;
        nachName = nachN;
        //fahrzeuge = f;
    }
    public String getVorName() {
        return vorName;
    }

    public void setVorName(String vorName) {
        this.vorName = vorName;
    }

    public String getNachName() {
        return nachName;
    }

    public void setNachName(String nachName) {
        this.nachName = nachName;
    }
    /*
    public void setFahrzeuge(ArrayList<verbrauch.Fahrzeug> newfahrzeug)
    {
        fahrzeuge = newfahrzeug;
    }
    */
    public void addFahrezeug(Fahrzeug newfahrzeug)
    {
        fahrzeuge.add(newfahrzeug);
    }
    public ArrayList <Fahrzeug> getFahrzeuge()
    {
        return fahrzeuge;
    }

    public double kalkuliereDurchschnittVerbrauch(ArrayList<Fahrzeug> f, String idAuto)
    {
        double summe = 0;
        for(Fahrzeug automobile: f)
        {
                if(automobile.getVin().equals(idAuto) && automobile.getModi().size() == 3)
                {
                   ArrayList<Modus> mod = automobile.getModi();
                   summe += mod.get(0).kalkuliereVerbrauch(automobile.getVerbrauch());
                   summe += mod.get(1).kalkuliereVerbrauch(automobile.getVerbrauch());
                   summe += mod.get(2).kalkuliereVerbrauch(automobile.getVerbrauch());
                }
        }
        return summe / 3;
    }
    public double kalkuliereSummeVrebrauchImModus(Modus m, ArrayList<Fahrzeug> f)
    {
        double summeSport = 0, summeNormal = 0, summeEco = 0;
        for(Fahrzeug automobile: f)
        {
            for(Modus modus: automobile.getModi())
            {
                 if(modus instanceof SportModus)
                        summeSport = summeSport + modus.kalkuliereVerbrauch(automobile.getVerbrauch());
                 else if(modus instanceof  EcoModus)
                     summeEco = summeEco + modus.kalkuliereVerbrauch(automobile.getVerbrauch());
                 else if (modus instanceof NormaleModus)
                     summeNormal = summeNormal + modus.kalkuliereVerbrauch(automobile.getVerbrauch());
            }
        }
        if(m instanceof SportModus)
            return summeSport;
        else if(m instanceof  EcoModus)
            return summeEco;
        else if(m instanceof NormaleModus)
            return summeNormal;
        return 0;
    }
}
