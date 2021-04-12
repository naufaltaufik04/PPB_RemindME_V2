package com.example.remindme;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Comparator;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Content implements Parcelable{
    private int contentId;
    private static AtomicInteger idIncrement = new AtomicInteger(0);
    private String title;
    private String details;
    private Integer difficulty;
    private Date dueDate;
    private Date dateCreated;

    public Content(String title, String details, Integer difficulty, Date dueDate, Date dateCreated) {
        this.contentId = idIncrement.incrementAndGet();
        this.title = title;
        this.details = details;
        this.difficulty = difficulty;
        this.dueDate = dueDate;
        this.dateCreated = dateCreated;
    }

    /*
    * ================================================ Sorting =======================================================
    * */
    //    Urutkan berdasarkan tanggal dibuat (ascending)
    //    Default Sorting
    public static Comparator<Content> byCreated = new Comparator<Content>(){
        @Override
        public int compare(Content c1, Content c2){
            return c2.getDateCreated().compareTo(c1.getDateCreated());
        }
    };

    //    Urutkan berdasarkan tenggat waktu / due date (ascending)
    public static Comparator<Content> byDate = new Comparator<Content>(){
        @Override
        public int compare(Content c1, Content c2){
            return c1.getDueDate().compareTo(c2.getDueDate());
        }
    };

    //    Urutkan berdasarkan tingkat kesulitan (ascending)
    //    dilihat dari nilai String 1 = Sulit, 2 = Sedang, 3 = Mudah 4 = tidak ditentukan atau -
    public static Comparator<Content> byDifficulty = new Comparator<Content>(){
        @Override
        public int compare(Content c1, Content c2){
            return c1.getDificulty().compareTo(c2.getDificulty());
        }
    };


    /*
     * ================================================ Parcelable =======================================================
     * */
    protected Content(Parcel in) {
        contentId = in.readInt();
        title = in.readString();
        details = in.readString();
        difficulty = in.readInt();
        dueDate = (Date) in.readSerializable();
        dateCreated = (Date) in.readSerializable();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(contentId);
        dest.writeString(title);
        dest.writeString(details);
        dest.writeInt(difficulty);
        dest.writeSerializable(dueDate);
        dest.writeSerializable(dateCreated);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Content> CREATOR = new Creator<Content>() {
        @Override
        public Content createFromParcel(Parcel in) {
            return new Content(in);
        }

        @Override
        public Content[] newArray(int size) {
            return new Content[size];
        }
    };


    /*
     * ================================================ Getter & Setter =======================================================
     * */
    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getDificulty() {
        return difficulty;
    }

    public void setDificulty(Integer dificulty) {
        this.difficulty = dificulty;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}