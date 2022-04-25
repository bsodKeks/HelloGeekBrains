package com.als.hellogeekbrains;

import android.os.Parcel;
import android.os.Parcelable;

public class Counters implements Parcelable {
    private int counter;
    private int counter1;

    public Counters() {
        counter = 0;
        counter1 = 0;
    }

    public Counters(int counter, int counter1) {
        this.counter = counter;
        this.counter1 = counter1;
    }

    protected Counters(Parcel in) {
        counter = in.readInt();
        counter1 = in.readInt();
    }

    public static final Creator<Counters> CREATOR = new Creator<Counters>() {
        @Override
        public Counters createFromParcel(Parcel in) {
            return new Counters(in);
        }

        @Override
        public Counters[] newArray(int size) {
            return new Counters[size];
        }
    };

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getCounter1() {
        return counter1;
    }

    public void setCounter1(int counter1) {
        this.counter1 = counter1;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(counter);
        parcel.writeInt(counter1);
    }
}
