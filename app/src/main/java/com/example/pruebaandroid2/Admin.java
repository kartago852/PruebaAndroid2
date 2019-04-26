package com.example.pruebaandroid2;

public class Admin {

    String adminId;
    String admindName;
    int adminRuc;
    String adminEmail;
    String adminPass;

    public Admin(String id, String name, String ruc, String email, String password)
    {

    }

    public Admin(String adminId, String admindName, int adminRuc, String adminEmail, String adminPass) {
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

    public int getAdminRuc() {
        return adminRuc;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public String getAdminPass() {
        return adminPass;
    }
}
