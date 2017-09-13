package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.profile.model.data;

import java.util.List;

/**
 * Created by aman on 11/9/17.
 */

public class ProfileRequestData {
    private boolean success;
    private String message;
    private String name;
    private String college_name;
    private String email;
    private String mobile;
    private String rank;
    private String[] college_list;

    public ProfileRequestData(boolean success, String message, String name,
                              String college_name, String email, String mobile,
                              String rank, String[] college_list) {
        this.success = success;
        this.message = message;
        this.name = name;
        this.college_name = college_name;
        this.email = email;
        this.mobile = mobile;
        this.rank = rank;
        this.college_list = college_list;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    public String getCollege_name() {
        return college_name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getRank() {
        return rank;
    }

    public String[] getCollege_list() {
        return college_list;
    }
}
