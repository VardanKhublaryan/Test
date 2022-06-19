package com.company.swaglabs.constants;

public enum LogInData {
    STANDARD_USER("standard_user"), LOCKED_OUT_USER("locked_out_user"), PROBLEM_USER("problem_user"),
    PERFORMANCE_GLITCH_USER("performance_glitch_user"), PASSWORD("secret_sauce"),
    FOOTER_TEXT("© 2022 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy"),
    TIME_OUT(5);

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