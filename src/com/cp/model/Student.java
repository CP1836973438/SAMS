package com.cp.model;

public class Student {
    private int id;
    private String sid;
    private String sname;
    private String spwd;
    private int sclass;
    private String sclassVal;
    private double chinese;
    private double math;
    private double english;
    private int sgrade;

    public Student() {
    }

    public Student(int sgrade) {
        this.sgrade = sgrade;
    }

    public Student(String sid, String spwd) {
        this.sid = sid;
        this.spwd = spwd;
    }

    public Student(int id, String sid, String sname, int sclass) {
        this.id = id;
        this.sid = sid;
        this.sname = sname;
        this.sclass = sclass;
    }

    public Student(int id, String sid, String sname, String spwd, int sclass) {
        this.id = id;
        this.sid = sid;
        this.sname = sname;
        this.spwd = spwd;
        this.sclass = sclass;
    }

    public Student(String sid, String sname, String spwd, int sclass) {
        this.sid = sid;
        this.sname = sname;
        this.spwd = spwd;
        this.sclass = sclass;
    }

    public Student(String sid, String sname, String spwd, int sclass, int sgrade) {
        this.sid = sid;
        this.sname = sname;
        this.spwd = spwd;
        this.sclass = sclass;
        this.sgrade = sgrade;
    }

    public Student(int id, String sid, String sname, String sclassVal) {
        this.id = id;
        this.sid = sid;
        this.sname = sname;
        this.sclassVal = sclassVal;
    }

    public Student(int id, double chinese, double math, double english, int sgrade) {
        this.id = id;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
        this.sgrade = sgrade;
    }

    public Student(int id, String sid, String sname, String spwd, int sclass, String sclassVal, double chinese, double math, double english) {
        this.id = id;
        this.sid = sid;
        this.sname = sname;
        this.spwd = spwd;
        this.sclass = sclass;
        this.sclassVal = sclassVal;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSpwd() {
        return spwd;
    }

    public void setSpwd(String spwd) {
        this.spwd = spwd;
    }

    public int getSclass() {
        return sclass;
    }

    public void setSclass(int sclass) {
        this.sclass = sclass;
    }

    public String getSclassVal() {
        return sclassVal;
    }

    public void setSclassVal(String sclassVal) {
        this.sclassVal = sclassVal;
    }

    public double getChinese() {
        return chinese;
    }

    public void setChinese(double chinese) {
        this.chinese = chinese;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getEnglish() {
        return english;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

    public int getSgrade() {
        return sgrade;
    }

    public void setSgrade(int sgrade) {
        this.sgrade = sgrade;
    }
}
