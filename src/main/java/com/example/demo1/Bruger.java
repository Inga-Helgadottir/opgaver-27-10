package com.example.demo1;

import java.util.Set;

public class Bruger {
    String navn;
    String password;
    Set<String> brugerHuskeListe;

    public Bruger(String navn, String password) {
        this.navn = navn;
        this.password = password;
    }

    public String getNavn() {
        return navn;
    }

    public String getPassword() {
        return password;
    }

    public Set<String> getBrugerHuskeListe() {
        return brugerHuskeListe;
    }

    public void setBrugerHuskeListe(Set<String> brugerHuskeListe) {
        this.brugerHuskeListe = brugerHuskeListe;
    }
}
