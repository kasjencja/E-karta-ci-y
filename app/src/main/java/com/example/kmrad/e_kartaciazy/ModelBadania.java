package com.example.kmrad.e_kartaciazy;

/**
 * Created by kmrad on 20.12.2018.
 */

public class ModelBadania {

    //fields
    private int idBadania;
    private String dataBadania;
    private String terminNW;
    private String uwagiLekarza;
    private String badaniaKrwi;
    private String RBC;
    private String HCT;
    private String HB;
    private String WBC;
    private String PLT;
    private String badaniaMoczu;
    private String CW;
    private String bialko;
    private String glukoza;
    private String E;
    private String L;
    private String bakterie;
    private String obecnaWaga;
    private String czySaZylaki;

    public ModelBadania() {
    }

    public ModelBadania(String dataBadania, String terminNW, String uwagiLekarza, String badaniaKrwi, String RBC, String HCT, String HB, String WBC, String PLT, String badaniaMoczu, String CW, String bialko, String glukoza, String e, String l, String bakterie, String obecnaWaga, String czySaZylaki) {
        this.dataBadania = dataBadania;
        this.terminNW = terminNW;
        this.uwagiLekarza = uwagiLekarza;
        this.badaniaKrwi = badaniaKrwi;
        this.RBC = RBC;
        this.HCT = HCT;
        this.HB = HB;
        this.WBC = WBC;
        this.PLT = PLT;
        this.badaniaMoczu = badaniaMoczu;
        this.CW = CW;
        this.bialko = bialko;
        this.glukoza = glukoza;
        this.E = e;
        this.L = l;
        this.bakterie = bakterie;
        this.obecnaWaga = obecnaWaga;
        this.czySaZylaki = czySaZylaki;
    }

    public String getGlukoza() {
        return this.glukoza;
    }

    public void setGlukoza(String glukoza) {
        this.glukoza = glukoza;
    }

    public String getE() {
        return this.E;
    }

    public void setE(String e) {
        this.E = e;
    }

    public String getL() {
        return this.L;
    }

    public void setL(String l) {
        this.L = l;
    }

    public String getBakterie() {
        return this.bakterie;
    }

    public void setBakterie(String bakterie) {
        this.bakterie = bakterie;
    }

    public String getObecnaWaga() {
        return this.obecnaWaga;
    }

    public void setObecnaWaga(String obecnaWaga) {
        this.obecnaWaga = obecnaWaga;
    }

    public String getCzySaZylaki() {
        return this.czySaZylaki;
    }

    public void setCzySaZylaki(String czySaZylaki) {
        this.czySaZylaki = czySaZylaki;
    }



    //constructors

    //properties

    public void setID(int id) {
        this.idBadania = id;
    }
    public int getID() {
        return this.idBadania;
    }

    public void setDataBadania(String data){
        this.dataBadania = data;
    }

    public String getDataBadania(){
        return this.dataBadania;
    }

    public void setTerminNW(String data){
        this.terminNW = data;
    }

    public String getTerminNW(){
        return this.terminNW;
    }

    public void setUwagiLekarza(String uwagi){
        this.uwagiLekarza = uwagi;
    }

    public String getUwagiLekarza(){
        return this.uwagiLekarza;
    }

    public void setBadaniaKrwi(String wynik){
        this.badaniaKrwi = wynik;
    }

    public String getBadaniaKrwi(){
        return this.badaniaKrwi;
    }

    public void setRBC(String wynik){
        this.RBC = wynik;
    }

    public String getRBC(){
        return this.RBC;
    }

    public void setHCT(String wynik){
        this.HCT = wynik;
    }

    public String getHCT(){
        return this.HCT;
    }

    public void setHB(String wynik){
        this.HB = wynik;
    }

    public String getHB(){
        return this.HB;
    }

    public void setWBC(String wynik){
        this.WBC = wynik;
    }

    public String getWBC(){
        return this.WBC;
    }

    public void setPLT(String wynik){
        this.PLT = wynik;
    }

    public String getPLT(){
        return this.PLT;
    }

    public void setBadaniaMoczu(String wynik){
        this.badaniaMoczu = wynik;
    }

    public String getBadaniaMoczu(){
        return this.badaniaMoczu;
    }

    public void setCW(String wynik){
        this.CW = wynik;
    }

    public String getCW(){
        return this.CW;
    }

    public void setBialko(String wynik){
        this.bialko = wynik;
    }

    public String getBialko(){
        return this.bialko;
    }

}
