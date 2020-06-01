/*
package com.patrimoine.website;

import com.patrimoine.website.ObjetsMetier.Address;
import com.patrimoine.website.ObjetsMetier.BankAccount;
import com.patrimoine.website.ObjetsMetier.Type;
import com.patrimoine.website.ObjetsMetier.User;
import com.patrimoine.website.config.interfaces.ConnectDatabase;

public class testConnection {

    public static void main(String[] args) {

        // connection bdd
        ConnectDatabase connection = new ConnectDatabase();
        if (connection.isConnected())
        {

            System.out.println("cool !! on est connecte ");

            // selection list users

            // on affiche les users
//            for(User user : connection.selectUsers())
//                System.out.println(user);


            // insertion un  user
//
//            User privateUser = new User();
//
            User individualUser = new User(3,032466,4566,"existe deja ","Fares","aefve",
                    "azef","coco","USER",
                    new Type(2,"PARTICULIER"), new Address(),new BankAccount(2,"BNP PARIBAS") );

//            User adminUser = new User(032466,4566,"Glenn","Patrimoine","aefve",
//                    "azef","coco","ADMINISTRATOR",
//                    new Type(2,"PARTICULIER"), new Address(),new BankAccount(2,"BNP PARIBAS") );
//
//
            User adminUser = new User(20,111,12345,"moi3","moi3 ","aefve",
                    "azef","coco","ADMINISTRATOR",
                    new Type(2,"PARTICULIER"), new Address(),new BankAccount(2,"BNP PARIBAS") );





            // on supprime


//
//           connection.insertUser(adminUser);
         connection.deleteUser(adminUser);


           //on update

         //   connection.updateUser(adminUser);


            // select un user





        }





    }







}
*/
