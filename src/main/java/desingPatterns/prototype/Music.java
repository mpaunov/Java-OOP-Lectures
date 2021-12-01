package desingPatterns.prototype;

public class Music extends Item {
    private double duration;

    public Music(String name, String imgUrl, double price) {
        super(name, imgUrl, price);
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}
