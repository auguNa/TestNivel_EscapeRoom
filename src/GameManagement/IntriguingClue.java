package GameManagement;

public class IntriguingClue extends InventoryItem {

    protected static final double IVA = 0.10;
    protected static int counter = 1;
    protected final int id;
    protected double estimatedTime;
    protected String theme;

    public IntriguingClue(String name, double price, double estimatedTime, String theme) {
        super(name, price);
        this.estimatedTime = estimatedTime;
        this.theme = theme;
        this.id = counter++;
    }

    @Override
    public double getPriceWithTax() {
        return price * (1 + IVA);
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name + '\'' +
                ", id=" + id + '\'' +
                ", theme='" + theme + '\'' +
                ", estimatedTime='" + estimatedTime + '\'' +
                ", price + IVA= " + getPriceWithTax();
    }
}


