/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs45.student;

/**
 *
 * @author kb
 */
public class Student {

    private int id;
    private String name;
    private double gpa;
    private String gender;

    public Student(int id, String name, double gpa, String gender) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public String getGender() {
        return gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

}
