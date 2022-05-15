package a12.dcortez.currencyconverter;

public class CurrencyModel {    // Defines only the result variable when using JSON objects
    private double result, rate;
    private String update;

    public CurrencyModel() {

    }
    // List of Generated Getter/Setters for variables above
    public double getResult() { return result; }

    public void setResult(double result) { this.result = result; }

    public double getRate() { return rate; }

    public void setRate(double rate) { this.rate = rate; }

    public String getUpdate() { return update; }

    public void setUpdate(String update) { this.update = update; }
}
