package verbrauch;

public class EcoModus implements Modus {
    @Override
    public double kalkuliereVerbrauch(double v)
    {
        return v * 0.7;
    }
}
