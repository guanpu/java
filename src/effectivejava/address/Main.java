/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package effectivejava.address;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pguan
 */
public class Main {
    public Book book;
    Main() {
        try {
            book = Book.getInstance();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        Main mainJob = new Main();

        while(true) {
            try{
            ui.showMenu();
            int i = 0;
            int j = 0;
            i = ui.prompt();
            if(i==1) {
                Address address = new Address();
                String s = ui.promptFor("First Name:");
                address.setFn(s);
                s= ui.promptFor("Last Name:");
                address.setLn(s);
                s=ui.promptFor("Phone Number:");
                address.setPhoneNum(s);
                s=ui.promptFor("Email:");
                address.setEmail(s);
                mainJob.book.add(address);
            }
            if(i==2) {//find
                ui.showSubMenu(i-1);
                j = ui.prompt();
                Optional<Address> address = null;
                switch (j) {
                    case 1:
                        address = mainJob.book.getBy((Address ads)->{
                            String s = ui.promptFor("First Name:");
                            return ads.getFn().equals(s);
                        });
                        System.out.println(address.get());
                        break;
                    case 2:
                        address =mainJob.book.getBy((Address ads) -> {
                            String s = ui.promptFor("Last Name:");
                            return ads.getLn().equals(s);
                        });
                        System.out.println(address.get());
                        break;
                    case 3:
                        address = mainJob.book.getBy((Address ads) -> {
                            String s = ui.promptFor("Phone Num:");
                            return ads.getPhoneNum().equals(s);
                        });
                        System.out.println(address.get());
                        break;
                    default://default to be 4
                        String s = ui.promptFor("Email:");
                        address = mainJob.book.getBy((Address ads) -> {
                            return ads.getEmail().equals(s);
                        });
                        System.out.println(address.get());
                        
                }
                if(j==5) {
                    continue;
                }
                
            }else if(i==3) {//delete from
                ui.showSubMenu(i-1);
                j = ui.prompt();
                switch (j) {
                    case 1:
                        mainJob.book.removeBy((Address ads) -> {
                            String s = ui.promptFor("First Name:");
                            return ads.getFn().equals(s);
                        });
                        break;
                    case 2:
                        mainJob.book.removeBy((Address ads) -> {
                            String s = ui.promptFor("Last Name:");
                            return ads.getLn().equals(s);
                        });
                        break;
                    case 3:
                        mainJob.book.removeBy((Address ads) -> {
                            String s = ui.promptFor("Phone Num:");
                            return ads.getPhoneNum().equals(s);
                        });
                        break;
                    default://default to be 4
                        mainJob.book.removeBy((Address ads) -> {
                            String s =ui.promptFor("Email:");
                            return ads.getEmail().equals(s);
                        });

                }
                if (j == 5) {
                    continue;
                }
            }else if(i==4) {//sort by
                ui.showSubMenu(i-1);
                j = ui.prompt();
                switch (j) {
                    case 1:
                        mainJob.book.sortBy(Address::getFn);
                        break;
                    case 2:
                        mainJob.book.sortBy(Address::getLn);
                        break;
                    case 3:
                        mainJob.book.sortBy(Address::getPhoneNum);

                        break;
                    default://default to be 4
                        mainJob.book.sortBy(Address::getEmail);

                }
                if (j == 5) {
                    continue;
                }
            }else if(i==5){
                mainJob.printall();
            }else{
                System.exit(0);
            }
            } catch(Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
    }

    public void printall() {
        book.show();
    }
}
