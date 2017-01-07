/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package effectivejava.address;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author pguan
 */
public class UserInterface {
    public int prompt() {
        Scanner sc = new Scanner(System.in);

        return sc.nextInt();        
    }
    public String promptFor(String s) {
        Scanner sc = new Scanner(System.in);

        System.out.println(s);
        return sc.nextLine();
    }
    public void showMenu() {
        String[] menu = new String[] {
            "1) add address",
            "2) find address",
            "3) delete address",
            "4) sort address",
            "5) list address",
            "6) quit"
        };
        Arrays.asList(menu).stream().forEachOrdered(s->System.out.println(s));
    }
    public void showSubMenu(int i) {
        String[][] submenu = new String[][]{
            {
                "Please enter First Name",
                "Please enter Last Name",
                "Please enter phone number",
                "Please enter email address"
            },
            {
                "find by First Name",
                "find by Last Name",
                "find by Phone Number",
                "find by Email address"
            }, {
                "delete by First Name",
                "delete by Last Name",
                "delete by Phone Number",
                "delete by Email address"
            }, {
                "sort by First Name",
                "sort by Last Name",
                "sort by Phone Number",
                "sort by Email address"
            }
        };
        for(int j = 0; j<submenu[i].length;j++) {
            System.out.print(j + ") ");
            System.out.println(submenu[i][j]);
        }
        System.out.println("5) cancel");
    }
}
