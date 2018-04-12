package Lab5;

import java.util.Random;

public class Toy {
    /** child's minimum age allowed */
    public int minAge;
    /** USDs */
    public float prize;
    public Size size;
    public Color color;
    private Random random = new Random();

    public Toy(int minAge, float prize, Size size, Color color) {
        this.minAge = minAge;
        this.prize = prize;
        this.size = size;
        this.color = color;
    }

    public Toy(){
        initAge();
        initPrize();
        initSize();
        initColor();
    }

    /**
     * randomly initialize minAge
     */
    private void initAge(){
        this.minAge = random.nextInt(12);
    }

    /**
     * randomly initialize prize
     */
    private void initPrize(){
        this.prize = random.nextFloat() * 10;
    }

    /**
     * randomly initialize size
     */
    private void initSize(){
        Size[] sizes = Size.values();
        this.size = sizes[random.nextInt(sizes.length)];
    }

    /**
     * randomly initialize color
     */
    private void initColor(){
        Color[] colors = Color.values();
        this.color = colors[random.nextInt(colors.length)];
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getPrize() {
        return prize;
    }

    public void setPrize(float prize) {
        this.prize = prize;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "type=" + this.getClass().getSimpleName() +
                ", minAge=" + minAge +
                ", prize=" + prize +
                ", size=" + size +
                ", color=" + color +
                '}';
    }
}
