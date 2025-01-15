/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aus;

import java.io.Serializable;

/**
 *
 * @author Winston
 */
public class Student implements Serializable{

    public Student(String reg, String name, int age) {
        this.reg = reg;
        this.name = name;
        this.age = age;
    }

    public Student() {
    }
    

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    private String reg;
    private String name;
    private int age;
    
    
}
