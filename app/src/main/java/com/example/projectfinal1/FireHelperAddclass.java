package com.example.projectfinal1;

public class FireHelperAddclass {

    String ID,FNAME,LNAME,PROF,STAT,GEN,DOB,PAR;

    public FireHelperAddclass(){

    }

    public FireHelperAddclass(String ID,String FNAME,String LNAME,String PROF,String STAT,String GEN,String DOB,String PAR){
        this.ID=ID;
        this.FNAME=FNAME;
        this.LNAME=LNAME;
        this.PROF=PROF;
        this.STAT=STAT;
        this.GEN=GEN;
        this.DOB=DOB;
        this.PAR=PAR;



    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFNAME() {
        return FNAME;
    }

    public void setFNAME(String FNAME) {
        this.FNAME = FNAME;
    }

    public String getLNAME() {
        return LNAME;
    }

    public void setLNAME(String LNAME) {
        this.LNAME = LNAME;
    }

    public String getPROF() {
        return PROF;
    }

    public void setPROF(String PROF) {
        this.PROF = PROF;
    }

    public String getSTAT() {
        return STAT;
    }

    public void setSTAT(String STAT) {
        this.STAT = STAT;
    }

    public String getGEN() {
        return GEN;
    }

    public void setGEN(String GEN) {
        this.GEN = GEN;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getPAR() {
        return PAR;
    }

    public void setPAR(String PAR) {
        this.PAR = PAR;
    }
}
