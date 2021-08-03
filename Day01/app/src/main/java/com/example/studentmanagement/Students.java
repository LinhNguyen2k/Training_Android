package com.example.studentmanagement;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

public class Students implements Serializable, Parcelable {
    String name,  level, dOfBirth, major;
    int phoneNumber;

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public Students(String name, int phoneNumber, String level, String dOfBirth, String major) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.level = level;
        this.dOfBirth = dOfBirth;
        this.major = major;
    }

    protected Students(Parcel in) {
        name = in.readString();
        phoneNumber = in.readInt();
        level = in.readString();
        dOfBirth = in.readString();
        major = in.readString();
    }

    public static final Creator<Students> CREATOR = new Creator<Students>() {
        @Override
        public Students createFromParcel(Parcel in) {
            return new Students(in);
        }

        @Override
        public Students[] newArray(int size) {
            return new Students[size];
        }
    };

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setdOfBirth(String dOfBirth) {
        this.dOfBirth = dOfBirth;
    }

    public String getName() {
        return name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getLevel() {
        return level;
    }

    public String getdOfBirth() {
        return dOfBirth;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(phoneNumber);
        dest.writeString(level);
        dest.writeString(dOfBirth);
        dest.writeString(major);
    }
}
