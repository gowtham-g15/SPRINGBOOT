package com.example.Springbootfirstproject.Models;

public class Employee {
    private int empid;
    private String ename;
    private String job;
    private String salary;


    public Employee(int empid, String ename, String job, String salary) {
        this.empid = empid;
        this.ename = ename;
        this.job = job;
        this.salary = salary;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }



}
