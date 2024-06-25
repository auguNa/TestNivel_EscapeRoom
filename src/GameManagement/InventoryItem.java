package GameManagement;

public abstract class InventoryItem {

    protected String name;
    protected double price;

    public InventoryItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract double getPriceWithTax();

    public String getName() {
        return name;
    }

        @Override
    public String toString() {
        return "Name: " + name +
                ", Price: " + price;
    }
}
