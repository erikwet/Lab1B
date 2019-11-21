public class Transportable implements ITransportable {

    private final double widthMeter;
    private final double heightMeter;
    private final double lengthMeter;

    public Transportable(double widthMeter, double heightMeter, double lengthMeter) {
        this.widthMeter = widthMeter;
        this.heightMeter = heightMeter;
        this.lengthMeter = lengthMeter;
    }

    @Override
    public double getWidth() {
        return widthMeter;
    }

    @Override
    public double getHeight() {
        return heightMeter;
    }

    @Override
    public double getLength() {
        return lengthMeter;
    }
}
