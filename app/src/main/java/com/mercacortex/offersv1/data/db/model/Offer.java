package com.mercacortex.offersv1.data.db.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Comparator;

public class Offer implements Parcelable {
    public static final String TAG = "Offer";
    private String name;
    private String shop;
    private String date;
    private int image;
    private int importance;

    public static final Comparator<Offer> ASC = new Comparator<Offer>() {
        @Override
        public int compare(Offer offer, Offer t1) {
            return offer.getName().compareToIgnoreCase(t1.getName());
        }
    };
    public static final Comparator<Offer> DESC = new Comparator<Offer>() {
        @Override
        public int compare(Offer offer, Offer t1) {
            return t1.getName().compareToIgnoreCase(offer.getName());
        }
    };
    public static final Comparator<Offer> TYPE = new Comparator<Offer>() {
        @Override
        public int compare(Offer offer, Offer t1) {
            if(offer.getImage() < t1.getImage()) return -1;
            if(offer.getImage() > t1.getImage()) return 1;
            return 0;
        }
    };

    public Offer(String name, String shop, String date, int image, int importance) {
        this.name = name;
        this.shop = shop;
        this.date = date;
        this.image = image;
        this.importance = importance;
    }

    protected Offer(Parcel in) {
        name = in.readString();
        shop = in.readString();
        date = in.readString();
        image = in.readInt();
        importance = in.readInt();
    }

    public static final Creator<Offer> CREATOR = new Creator<Offer>() {
        @Override
        public Offer createFromParcel(Parcel in) {
            return new Offer(in);
        }

        @Override
        public Offer[] newArray(int size) {
            return new Offer[size];
        }
    };

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getShop() {
        return shop;
    }
    public void setShop(String shop) {
        this.shop = shop;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public int getImage() {
        return image;
    }
    public void setImage(int image) {
        this.image = image;
    }
    public int getImportance() {
        return importance;
    }
    public void setImportance(int importance) {
        this.importance = importance;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(shop);
        parcel.writeString(date);
        parcel.writeInt(image);
        parcel.writeInt(importance);
    }
}
