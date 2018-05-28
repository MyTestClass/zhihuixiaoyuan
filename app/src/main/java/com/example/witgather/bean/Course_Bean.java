package com.example.witgather.bean;

/**
 * 代表的是一个课程的实体
 */
public class Course_Bean {

    private String course_name;
    private String course_place;
    private String course_teacher;
    //代表上课的起始节数和节数
    private int start_position=0;
    private int length=0;
    //课程所用的背景颜色的ID
    private int colorId=0;

    //    使用字符串来保存课程所在的周数，这样就不需要保存单周和双周的
    private String week;
    //    周数之间使用    ，   进行划分
    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public String getWeek() {
        return week;
    }
    public void setWeek(String week) {
        this.week = week;
    }
    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_place() {
        return course_place;
    }

    public void setCourse_place(String course_place) {
        this.course_place = course_place;
    }

    public String getCourse_teacher() {
        return course_teacher;
    }

    public void setCourse_teacher(String course_teacher) {
        this.course_teacher = course_teacher;
    }

    public int getStart_position() {
        return start_position;
    }

    public void setStart_position(int start_position) {
        this.start_position = start_position;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }





}
