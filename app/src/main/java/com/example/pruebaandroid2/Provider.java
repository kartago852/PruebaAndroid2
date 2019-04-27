package com.example.pruebaandroid2;

public class Provider {

    String provId ;
    String provName ;
    String provRuc;
    String provEmail;
    String provPass;
    String provService;

    public Provider(String provId, String provName, String provRuc, String provEmail, String provPass, String provService) {
        this.provId = provId;
        this.provName = provName;
        this.provRuc = provRuc;
        this.provEmail = provEmail;
        this.provPass = provPass;
        this.provService = provService;
    }

    public String getProvId() {
        return provId;
    }

    public String getProvName() {
        return provName;
    }

    public String getProvRuc() {
        return provRuc;
    }

    public String getProvEmail() {
        return provEmail;
    }

    public String getProvPass() {
        return provPass;
    }

    public String getProvService() {
        return provService;
    }
}
