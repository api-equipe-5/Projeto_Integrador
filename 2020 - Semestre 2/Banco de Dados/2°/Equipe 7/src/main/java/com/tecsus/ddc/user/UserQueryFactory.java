package com.tecsus.ddc.user;

public class UserQueryFactory {
    public static String select() {
        return "SELECT * FROM DDC_USER WHERE LOGIN=? AND PASS=?";
    }

    public static String selectRole() {
        return "SELECT DDC_ROLE FROM DDC_ROLES WHERE LOGIN=?";
    }
}
