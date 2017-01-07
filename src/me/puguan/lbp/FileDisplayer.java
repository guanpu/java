/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author pguan
 */
public class FileDisplayer {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        JFileChooser jfc = new JFileChooser();
        jfc.setCurrentDirectory(new File("."));
        int returnVal = jfc.showOpenDialog(null);
        String filename = null;
        if(returnVal==JFileChooser.APPROVE_OPTION) {
            filename = jfc.getSelectedFile().getPath();
        }
        FileReader fr = new FileReader(filename);
        char[] cbuf = new char[3];
        while (fr.read(cbuf)== 3) {
            System.out.print(cbuf[2]);
        }
    }
}
