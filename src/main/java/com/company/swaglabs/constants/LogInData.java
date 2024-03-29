package com.company.swaglabs.constants;

public enum LogInData {
    STANDARD_USER("standard_user"),
    LOCKED_OUT_USER("locked_out_user"),
    PROBLEM_USER("problem_user"),
    PERFORMANCE_GLITCH_USER("performance_glitch_user"),
    PASSWORD("secret_sauce"),
    FOOTER_TEXT(" 2022 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy"),
    TIME_OUT(5),
    INVALID_LOGIN("SSS"),
    INVALID_PASS("AAAA"),
    INVALID_USER_ERROR("Epic sadface: Username and password do not match any user in this service"),
    WITH_OUT_PASS_ERROR("Epic sadface: Password is required"),
    WITH_OUT_USER_NAME_ERROR("Epic sadface: Username is required");

    private String userName;
    private Integer time;

    LogInData(String userName) {
        this.userName = userName;
    }

    LogInData(Integer time) {
        this.time = time;
    }

    public String toString() {
        return userName;
    }

    public Integer toInteger() {
        return time;
    }
}