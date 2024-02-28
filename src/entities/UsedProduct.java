package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product {
    private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private LocalDate manufactureDate;

    public UsedProduct(String name, Double price, String manufactureDate) {
        super(name, price);
        this.manufactureDate = LocalDate.parse(manufactureDate, fmt);
    }

    public String getManufactureDate() {
        return manufactureDate.format(fmt);
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = LocalDate.parse(manufactureDate, fmt);
    }

    @Override
    public String priceTag() {
        return name + " (used) $ " + String.format("%.2f", price) + "( Manufacture date: " + manufactureDate.format(fmt) + ")";
    }
}
