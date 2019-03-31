package com.example.materialdesignapp.activities;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableDataModel implements Parcelable {

    String firstName;

    protected ParcelableDataModel(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        degree = in.readString();
    }

    public static final Creator<ParcelableDataModel> CREATOR = new Creator<ParcelableDataModel>() {
        @Override
        public ParcelableDataModel createFromParcel(Parcel in) {
            return new ParcelableDataModel(in);
        }

        @Override
        public ParcelableDataModel[] newArray(int size) {
            return new ParcelableDataModel[size];
        }
    };

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public ParcelableDataModel(String firstName, String lastName, String degree) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.degree = degree;
    }

    String lastName;
    String degree;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(degree);
    }
}

