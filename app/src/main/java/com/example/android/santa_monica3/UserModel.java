package com.example.android.santa_monica3;

import java.io.Serializable;

/**
 * Created by exalogic on 14/3/18.
 */

public class UserModel implements Serializable {

    private String name, hobby;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
