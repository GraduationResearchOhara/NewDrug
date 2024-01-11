package com.example.newdrug;

import android.os.Parcel;
import android.os.Parcelable;

public class NoticeItem implements Parcelable {
    private String date;
    private String title;
    private String content;

    public NoticeItem(String date, String title, String content) {
        this.date = date;
        this.title = title;
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    // Parcelableインターフェースのメソッド

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeString(title);
        dest.writeString(content);
    }

    // ParcelableインターフェースのCreator
    public static final Creator<NoticeItem> CREATOR = new Creator<NoticeItem>() {
        @Override
        public NoticeItem createFromParcel(Parcel in) {
            return new NoticeItem(in);
        }

        @Override
        public NoticeItem[] newArray(int size) {
            return new NoticeItem[size];
        }
    };

    // Parcelableインターフェースのコンストラクタ
    protected NoticeItem(Parcel in) {
        date = in.readString();
        title = in.readString();
        content = in.readString();
    }

    // NoticeItemを文字列に変換するためのオーバーライド
    @Override
    public String toString() {
        return title; // タイトルを表示
    }
}
