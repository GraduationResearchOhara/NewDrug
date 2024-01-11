package com.example.newdrug;

import android.os.Parcel;
import android.os.Parcelable;

public class MailItem implements Parcelable {
    private String title;
    private String body;
    private String sender;
    private String date;

    public MailItem(String title, String body, String sender, String date) {
        this.title = title;
        this.body = body;
        this.sender = sender;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getSender() {
        return sender;
    }

    public String getDate() {
        return date;
    }

    // Parcelableの実装
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(body);
        dest.writeString(sender);
        dest.writeString(date);
    }

    // ParcelableのCreator
    public static final Parcelable.Creator<MailItem> CREATOR = new Parcelable.Creator<MailItem>() {
        @Override
        public MailItem createFromParcel(Parcel in) {
            return new MailItem(in);
        }

        @Override
        public MailItem[] newArray(int size) {
            return new MailItem[size];
        }
    };

    // Parcelからデータを読み込むコンストラクタ
    private MailItem(Parcel in) {
        title = in.readString();
        body = in.readString();
        sender = in.readString();
        date = in.readString();
    }
    // NoticeItemを文字列に変換するためのオーバーライド
    @Override
    public String toString() {
        return title; // タイトルを表示
    }
}
