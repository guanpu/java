/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package effectivejava.address;

/**
 *
 * @author pguan
 */
public class MyException extends Exception {

    public MyException(String message) {
        super(message);
    }
    
    public MyException(Throwable t) {
        super(t);
    }
    
    public void abc(String s) {
        
    }
    public void abc(int s) {
        
    }
    
}
