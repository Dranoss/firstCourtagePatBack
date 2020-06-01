package com.patrimoine.website.repository;

import com.patrimoine.website.entity.Address;
import com.patrimoine.website.entity.BankAccount;
import com.patrimoine.website.entity.Type;
import com.patrimoine.website.entity.User;
import com.patrimoine.website.config.interfaces.ConnectDatabase;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class UserRepository {



    private ConnectDatabase connection;

    public UserRepository() {
        this.connection = new ConnectDatabase();
    }

    public User selectUser(int id ) throws SQLException {


        if (!connection.isConnected())
               throw new SQLException();



        User u= null;
        // on prepare la requete
        // on execute la requet
        try {

            String query = "select * from users where id = "+id;
            String firstname= "";
            String lastname= "";
            String role= "";

            PreparedStatement statement = connection.getConnection().prepareStatement(query );

            ResultSet resultat = statement.executeQuery();


            id = resultat.getInt("id");
            firstname = resultat.getString("firstname");
            lastname = resultat.getString("lastname");
            role = resultat.getString("role");

            u =  new User(id, 2,2,firstname,lastname,
                    "","","",role,new Type(1,"toto"),new Address(),
                    new BankAccount(1,"test"));

        }
        catch (SQLException e) {
            System.out.println(e);
        }

        return  u;


    }
    public List<User> selectUsers() throws SQLException{

        if (!connection.isConnected())
            throw new SQLException();

        List<User> listUsers = new ArrayList<>();


        // on prepare la requete
        // on execute la requete
        try {

            String query = "select * from users;";
            String firstname= "";
            String lastname= "";
            String role= "";
            int id ;
            String password= "";
            int phoneNumber;
            String email= "";

            PreparedStatement statement = connection.getConnection().prepareStatement(query );

            ResultSet resultat = statement.executeQuery();
            while (resultat.next()) {

                id = resultat.getInt("id");
                firstname = resultat.getString("firstname");
                lastname = resultat.getString("lastname");
                role = resultat.getString("role");
                password = resultat.getString("password");
                phoneNumber = resultat.getInt("phone_number");
                email = resultat.getString("email");
                role = resultat.getString("role");



                User u =  new User(id, phoneNumber,2,firstname,lastname,
                        email,password,"",role,new Type(1,"toto"),new Address(),
                        new BankAccount(1,"test"));

                listUsers.add(u);

            }



        }
        catch (SQLException e) {
            System.out.println(e);
        }

        return  listUsers;

    }

    public void  insertUser(User user){

// atention faut gerer doublons  des noms prenoms ;


        // on prepare la requete
        // on execute la requete
        try {

            String query = "insert into users (firstname,lastname,role,phone_number,password) values (?,?,?,?,?)";
            String firstname= user.getFirstName();
            String lastname= user.getLastName();
            String role= user.getRole();
            int phoneNumber= user.getPhoneNumber();
            String password= user.getPassword();

            PreparedStatement statement = connection.getConnection().prepareStatement(query);


            statement.setString(1,firstname);
            statement.setString(2,lastname);
            statement.setString(3,role);
            statement.setInt(4,phoneNumber);
            statement.setString(5,password);

            statement.executeUpdate();
            statement.close();
        }
        catch (SQLException se)
        {
            System.out.println(se);
        }


    }

    public void  deleteUser(User user){


        // on prepare la requete
        // on execute la requete
        try {

            String query = "delete from users  where id = ?";

            int id= user.getId();


            PreparedStatement statement = connection.getConnection().prepareStatement(query);
            statement.setInt(1,id);
            statement.execute();
            statement.close();
        }
        catch (SQLException se)
        {
            System.out.println(se);
        }



    }
    public void  updateUser(User user){


        // on a recuperer un user par son id et on met a jour

        int id = user.getId();
        // on prepare la requete
        // on execute la requete
        try {
 /*
            int id, int phoneNumber, int siretNumber,
                     String firstName, String lastName,
                     String email, String password,
                     String companyName, String role, Type type, Address address, BankAccount account)
             */
            String query = "update users set firstname= ?,lastname=?,email=?,password=?,society_name =?,role=?,"+
                    "phone_number = ?,siret_number=? where id = ? ;";

            String firstname= user.getFirstName();
            String lastname= user.getLastName();
            String role= user.getRole();
            String siret = "" + user.getSiretNumber();  //  siret en  varchar !
            String email= user.getEmail();
            String password= user.getPassword();
            String companyName= user.getCompanyName();
            int phoneNumber= user.getPhoneNumber();

            PreparedStatement statement = connection.getConnection().prepareStatement(query);


            statement.setString(1,firstname);
            statement.setString(2,lastname);
            statement.setString(3,email);
            statement.setString(4,password);
            statement.setString(5,companyName);
            statement.setString(6,role);
            statement.setInt(7,phoneNumber);
            statement.setString(8,siret);
            statement.setInt(9,id);



            statement.execute();
            statement.close();
        }
        catch (SQLException se)
        {
            System.out.println(se);
        }




    }



}
