/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package effectivejava.chapter11;

import java.io.Serializable;

/**
 *
 * @author pguan
 */
public class Entity implements Serializable{
    private static final long serialVersionUID = 40L;
    private int x = 0;
    public void add(){
        x++;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    
}
