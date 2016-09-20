package libwy.symbio.com.mybuying.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.common.base.Objects;

/**
 * Created by wilbyang on 26/02/16.
 */

public class Sku implements Parcelable{
    private String title, name, image, largeImage, description;
    private double price;

    public Sku() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sku sku = (Sku) o;
        return Double.compare(sku.price, price) == 0 &&
              Objects.equal(title, sku.title) &&
              Objects.equal(name, sku.name) &&
              Objects.equal(image, sku.image) &&
              Objects.equal(largeImage, sku.largeImage) &&
              Objects.equal(description, sku.description);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title, name, image, largeImage, description, price);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLargeImage() {
        return largeImage;
    }

    public void setLargeImage(String largeImage) {
        this.largeImage = largeImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.name);
        dest.writeString(this.image);
        dest.writeString(this.largeImage);
        dest.writeString(this.description);
        dest.writeDouble(this.price);
    }

    protected Sku(Parcel in) {
        this.title = in.readString();
        this.name = in.readString();
        this.image = in.readString();
        this.largeImage = in.readString();
        this.description = in.readString();
        this.price = in.readDouble();
    }

    public static final Creator<Sku> CREATOR = new Creator<Sku>() {
        @Override
        public Sku createFromParcel(Parcel source) {
            return new Sku(source);
        }

        @Override
        public Sku[] newArray(int size) {
            return new Sku[size];
        }
    };
}
