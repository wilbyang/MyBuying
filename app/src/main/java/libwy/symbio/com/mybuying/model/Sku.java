package libwy.symbio.com.mybuying.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.common.base.Objects;

/**
 * Created by wilbyang on 26/02/16.
 */

public class Sku implements Parcelable{
    private String name, description, picture;
    private boolean available;
    private double price;

    public Sku() {
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.picture);
        dest.writeByte(available ? (byte) 1 : (byte) 0);
        dest.writeDouble(this.price);
    }

    protected Sku(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
        this.picture = in.readString();
        this.available = in.readByte() != 0;
        this.price = in.readDouble();
    }

    public static final Creator<Sku> CREATOR = new Creator<Sku>() {
        public Sku createFromParcel(Parcel source) {
            return new Sku(source);
        }

        public Sku[] newArray(int size) {
            return new Sku[size];
        }
    };
}
