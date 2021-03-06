package com.example.ezclassapp.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by victorlee95 on 8/26/2017.
 */

public class Course {
    private String id;
    private String courseName;
    private String courseNumber;
    private String fullCourseName;
    private String imageUrl;
    private List<String> reviewID_list;

    public Course() {

    }


    public Course(String courseNumber, String courseName,String id) {
        this.courseName = courseName;
        setReviewID_list(new ArrayList<String>());
        this.courseNumber = courseNumber;
        this.fullCourseName = courseNumber + " " + courseName;
        this.id = id;
    }

    public static ArrayList<Course> getDummyCourseList() {
        ArrayList<Course> classList = new ArrayList<Course>();
//        classList.add(new Course("CS354", "Operating System"));
//        classList.add(new Course("CS448", "Database System"));
//        classList.add(new Course("CS333", "Java Programming"));
//        classList.add(new Course("CS240", "C Programming"));
        return classList;
//        butto.setonclicSiter {
//
//            List<Class> classes = Class.getDummyClassList();
//            for(Class class: classes) {
//                String key = database.getReference("Class").push().getKey();
//                String id = generateID;
//                class.setID(id);
//
//            }
//        }
    }

    public String getFullCourseName() {
        return fullCourseName;
    }

    public void setFullCourseName(String fullCourseName) {
        this.fullCourseName = fullCourseName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getReviewID_list() {
        return reviewID_list;
    }

    public void setReviewID_list(List<String> reviewID_list) {
        this.reviewID_list = reviewID_list;
    }
}