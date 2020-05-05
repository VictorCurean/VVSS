package verbrauch;

import java.util.ArrayList;

public class Fahrzeug {
    private String vin;
    private String farbe;
    private double verbrauch;
    private String marke;
    private ArrayList<Modus> modi = new ArrayList<Modus>();
    public Fahrzeug(String id, String f, double v, String m, ArrayList<Modus> mod)
    {
        vin = id;
        farbe = f;
        verbrauch = v;
        marke = m;
        modi = mod;
    }

    public Fahrzeug()
    {
        vin = "";
        farbe = "";
        verbrauch = -1;
        marke = "";
        modi = new ArrayList<Modus>();
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public double getVerbrauch() {
        return verbrauch;
    }

    public void setVerbrauch(double verbrauch) {
        this.verbrauch = verbrauch;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public ArrayList<Modus> getModi() {
        return modi;
    }
    /*
    public void setModi(ArrayList<verbrauch.Modus> modi) {
        this.modi = modi;

    }
    */
    public void addModi(Modus modus)
    {
        this.modi.add(modus);
    }
}
