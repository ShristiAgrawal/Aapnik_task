package com.example.aapnik_task;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class itemlist {
@SerializedName("is_answered")
private boolean is_answered;
    @SerializedName("score")
    private int score;
    @SerializedName("answer_count")
    private int answer_count;
    @SerializedName("link")
    private String link;
    @SerializedName("creation_date")
    private String creation_date;

    @SerializedName("owner")
    private user u_list;



    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getAnswer_count() {
        return answer_count;
    }

    public void setAnswer_count(int answer_count) {
        this.answer_count = answer_count;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public user getU_list() {
        return u_list;
    }

    public void setU_list(user u_list) {
        this.u_list = u_list;
    }

    public boolean isIs_answered() {
        return is_answered;
    }

    public void setIs_answered(boolean is_answered) {
        this.is_answered = is_answered;
    }
}
