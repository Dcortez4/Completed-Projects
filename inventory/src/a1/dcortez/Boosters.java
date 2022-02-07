package a1.dcortez;

public class Boosters extends Consumable{
    float bonus;

    public Boosters() {
        super();
        this.bonus = 0;
    }

    public Boosters(String name, double price, int qty, int usesLeft, float bonus) {
        super(name, price, qty, usesLeft);
        this.bonus = bonus;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString(){
        return String.format("%s %20.2f |", super.toString(), this.bonus);
    }
}
