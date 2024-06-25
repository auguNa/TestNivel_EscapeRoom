package GameManagement;

public class DecorationObject extends InventoryItem {
    private static final double IVA = 0.21;
    private static int counter = 1;
    private final int id;
    private String description;
    private MaterialType materialType;

    public DecorationObject(String name, double price, String description, MaterialType materialType) {
        super(name, price);
        this.description = description;
        this.materialType = materialType;
        this.id = counter++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getPriceWithTax() {
        return price * (1 + IVA);
    }

    @Override
    public String toString() {
        return name + '\'' +
                ", id= " + id +
                ", description= '" + description + '\'' +
                ", materialType= " + materialType +
                ", price + IVA= " + getPriceWithTax();
    }
}
