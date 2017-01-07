/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package effectivejava.chapter11;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author pguan
 */
public class Composer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Entity entity = new Entity();
        entity.add();
        FileOutputStream fos = new FileOutputStream("t.tmp");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(entity);
        oos.close();
        FileInputStream fis = new FileInputStream("t.tmp");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Entity et2 = (Entity)ois.readObject();
        ois.close();
        et2.add();
        System.out.println(et2.getX());       
        
    }
}
