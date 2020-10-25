package com.cg.stateanalyser;

public class StateNumber {
    private String srno,name,TIN,statecode;

    public String getSrno() {
        return srno;
    }

    public void setSrno(String srno) {
        this.srno = srno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTIN() {
        return TIN;
    }

    public void setTIN(String TIN) {
        this.TIN = TIN;
    }

    public String getStatecode() {
        return statecode;
    }

    public void setStatecode(String statecode) {
        this.statecode = statecode;
    }
    public String toString(){
        return "Sr no : " + getSrno() + ", Name : " + getName() + ", TIN : " + getTIN() + ", StateCode : " + getStatecode();
    }
}
