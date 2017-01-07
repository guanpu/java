/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package effectivejava.chapter10;

/**
 *
 * @author pguan
 */
public class Child extends Father{
    private String age = "19";    

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    
}
