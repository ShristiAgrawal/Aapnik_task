package com.example.aapnik_task;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class items {
    @SerializedName("items")
    private List<itemlist> list;

    public List<itemlist> getList() {
        return list;
    }

    public void setList(List<itemlist> list) {
        this.list = list;
    }
}
