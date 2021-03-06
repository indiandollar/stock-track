package com.udacity.stockhawk.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Indian Dollar on 1/15/2017.
 */

public class QuoteHistory implements Parcelable {

    private Float mHigh;
    private Float mLow;
    private String mDate;
    private String mFormattedDate;

    public String getFormattedDate() {
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-DD");
        //Date newDate = format.parse(mDate.getTime().toString());

        SimpleDateFormat date = new SimpleDateFormat("dd MMM");
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(Long.parseLong(mDate));
        mFormattedDate = date.format(cal.getTime());
        return mFormattedDate;

    }

    private void setFormattedDate(String formattedDate) {
        mFormattedDate = formattedDate;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public Float getLow() {
        return mLow;
    }

    public void setLow(Float low) {
        mLow = low;
    }

    public Float getHigh() {
        return mHigh;
    }

    public void setHigh(Float high) {
        mHigh = high;
    }


    public QuoteHistory(float a, float b, String date) {
        setHigh(a);
        setLow(b);
        setDate(date);
    }

    protected QuoteHistory(Parcel in) {
        mHigh = (Float) in.readValue(BigDecimal.class.getClassLoader());
        mLow = (Float) in.readValue(BigDecimal.class.getClassLoader());
        mDate = (String) in.readValue(String.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(mHigh);
        dest.writeValue(mLow);
        dest.writeValue(mDate);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<QuoteHistory> CREATOR = new Parcelable.Creator<QuoteHistory>() {
        @Override
        public QuoteHistory createFromParcel(Parcel in) {
            return new QuoteHistory(in);
        }

        @Override
        public QuoteHistory[] newArray(int size) {
            return new QuoteHistory[size];
        }
    };
}