package com.example.e15gestitb;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class MissedAttendanceModel implements Parcelable {
    String studentName;
    String moduleName;
    Date date;
    boolean isJustified;


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isJustified() {
        return isJustified;
    }

    public void setJustified(boolean justified) {
        isJustified = justified;
    }

    public MissedAttendanceModel() {
        this.studentName = "";
        this.moduleName = "";
        this.date = new Date();
        this.isJustified = false;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(studentName);
        dest.writeString(moduleName);
        dest.writeByte((byte) (isJustified ? 1 : 0));
    }

    @Override
    public String toString() {
        return "MissedAttendanceModel{" +
                "studentName='" + studentName + '\'' +
                ", moduleName='" + moduleName + '\'' +
                ", date=" + date +
                ", isJustified=" + isJustified +
                '}';
    }

    protected MissedAttendanceModel(Parcel in) {
        studentName = in.readString();
        moduleName = in.readString();
        isJustified = in.readByte() != 0;
    }

    public static final Creator<MissedAttendanceModel> CREATOR = new Creator<MissedAttendanceModel>() {
        @Override
        public MissedAttendanceModel createFromParcel(Parcel in) {
            return new MissedAttendanceModel(in);
        }

        @Override
        public MissedAttendanceModel[] newArray(int size) {
            return new MissedAttendanceModel[size];
        }
    };
}
