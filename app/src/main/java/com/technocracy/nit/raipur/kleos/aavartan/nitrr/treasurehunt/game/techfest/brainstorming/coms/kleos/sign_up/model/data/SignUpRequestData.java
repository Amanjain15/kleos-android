package com.technocracy.nit.raipur.kleos.aavartan.nitrr.treasurehunt.game.techfest.brainstorming.coms.kleos.sign_up.model.data;

import java.util.List;

/**
 * Created by aman on 6/9/17.
 */

public class SignUpRequestData {

    private boolean success;
    private String message;
    private String access_token;
    private String name;
    private String[] college_list;

    public SignUpRequestData(boolean success, String message, String access_token, String name,
                             String[] college_list) {
        this.success = success;
        this.message = message;
        this.access_token = access_token;
        this.name = name;
        this.college_list = college_list;

    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getName() {
        return name;
    }

    public String[] getCollegeDetailsList() {
        return college_list;
    }
}

