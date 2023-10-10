package edu.neu.management.bean;

public class Lesson {
    private  String code;
    private String lessonname;
    private String applicant;
    private String sdata;
    private String sdata2;
    private String applyreason;
    private String reason1;
    private String reason2;
    private String conform;

    public String getReason1() {
        return reason1;
    }

    public void setReason1(String reason1) {
        this.reason1 = reason1;
    }

    public String getReason2() {
        return reason2;
    }

    public void setReason2(String reason2) {
        this.reason2 = reason2;
    }

    public String getConform() {
        return conform;
    }

    public void setConform(String conform) {
        this.conform = conform;
    }

    public String getSdata2() {
        return sdata2;
    }

    public void setSdata2(String sdata2) {
        this.sdata2 = sdata2;
    }

    public String getApplyreason() {
        return applyreason;
    }

    public void setApplyreason(String applyreason) {
        this.applyreason = applyreason;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLessonname() {
        return lessonname;
    }

    public void setLessonname(String lessonname) {
        this.lessonname = lessonname;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getSdata() {
        return sdata;
    }

    public void setSdata(String sdata) {
        this.sdata = sdata;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "code='" + code + '\'' +
                ", lessonname='" + lessonname + '\'' +
                ", applicant='" + applicant + '\'' +
                ", sdata='" + sdata + '\'' +
                '}';
    }
}
