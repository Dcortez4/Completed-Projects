package a1.dcortez;

public class Clothing extends Item{
    private String type;

    public Clothing() {
        super();
        this.type = "";
    }

    public Clothing(String name, double price, int qty, String type) {
        super(name, price, qty);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("%s %7s %-20s|", super.toString(), "|", this.type);
    }
}
