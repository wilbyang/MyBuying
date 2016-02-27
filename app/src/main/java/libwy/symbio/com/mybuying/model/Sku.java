package libwy.symbio.com.mybuying.model;

import com.google.common.base.Objects;

/**
 * Created by wilbyang on 26/02/16.
 */
public class Sku {
    private String name, description, picture;
    private boolean available;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sku sku = (Sku) o;
        return Objects.equal(available, sku.available) &&
                Objects.equal(price, sku.price) &&
                Objects.equal(name, sku.name) &&
                Objects.equal(description, sku.description) &&
                Objects.equal(picture, sku.picture);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, description, picture, available, price);
    }
}
