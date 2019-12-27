package com.cp.model;

public class Teacher {
    private int id;
    private String tid;
    private String tname;
    private String tpwd;
    private int tclass;
    private int tclass2;
    private String tclassVal;
    private String tclassVal2;

    public Teacher() {
    }

    public Teacher(String tid, String tpwd) {
        this.tid = tid;
        this.tpwd = tpwd;
    }

    public Teacher(String tid, String tname, String tpwd) {
        this.tid = tid;
        this.tname = tname;
        this.tpwd = tpwd;
    }

    public Teacher(int id, String tid, String tname, String tpwd) {
        this.id = id;
        this.tid = tid;
        this.tname = tname;
        this.tpwd = tpwd;
    }

    public Teacher(String tid, String tname, String tpwd, int tclass, int tclass2) {
        this.tid = tid;
        this.tname = tname;
        this.tpwd = tpwd;
        this.tclass = tclass;
        this.tclass2 = tclass2;
    }

    public Teacher(int id, String tid, String tname, String tpwd, int tclass, int tclass2) {
        this.id = id;
        this.tid = tid;
        this.tname = tname;
        this.tpwd = tpwd;
        this.tclass = tclass;
        this.tclass2 = tclass2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTpwd() {
        return tpwd;
    }

    public void setTpwd(String tpwd) {
        this.tpwd = tpwd;
    }

    public int getTclass() {
        return tclass;
    }

    public void setTclass(int tclass) {
        this.tclass = tclass;
    }

    public int getTclass2() {
        return tclass2;
    }

    public void setTclass2(int tclass2) {
        this.tclass2 = tclass2;
    }

    public String getTclassVal() {
        return tclassVal;
    }

    public void setTclassVal(String tclassVal) {
        this.tclassVal = tclassVal;
    }

    public String getTclassVal2() {
        return tclassVal2;
    }

    public void setTclassVal2(String tclassVal2) {
        this.tclassVal2 = tclassVal2;
    }
}
