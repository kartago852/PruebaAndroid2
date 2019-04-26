package com.example.pruebaandroid2;

public class Admin {

    String adminId;
    String admindName;
    String adminRuc;
    String adminEmail;
    String adminPass;

    public Admin(String adminId, String admindName, String adminRuc, String adminEmail, String adminPass) {
        this.adminId = adminId;
        this.admindName = admindName;
        this.adminRuc = adminRuc;
        this.adminEmail = adminEmail;
        this.adminPass = adminPass;
    }

    public String getAdminId() {
        return adminId;
    }

    public String getAdmindName() {
        return admindName;
    }

    public String getAdminRuc() {
        return adminRuc;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public String getAdminPass() {
        return adminPass;
    }
}
