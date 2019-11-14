package com.fc.andriod.newcptdemo3.entity;


import android.os.Parcel;
import android.os.Parcelable;

public class ClassManagement implements Parcelable {

    private  int student_count;
    private  String class_name ;


    public ClassManagement(String class_name) {
        this.class_name = class_name;
    }

    protected ClassManagement(Parcel in) {
        student_count = in.readInt();
        class_name = in.readString();
    }

    public static final Creator<ClassManagement> CREATOR = new Creator<ClassManagement>() {
        @Override
        public ClassManagement createFromParcel(Parcel in) {
            return new ClassManagement(in);
        }

        @Override
        public ClassManagement[] newArray(int size) {
            return new ClassManagement[size];
        }
    };

    public int getStudent_count() {
        return student_count;
    }

    public void setStudent_count(int student_count) {
        this.student_count = student_count;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(student_count);
        dest.writeString(class_name);
    }
}
