package verbrauch;

public class SportModus implements Modus{
    @Override
    public double kalkuliereVerbrauch(double v)
    {
        return v * 1.5;
    }
}
