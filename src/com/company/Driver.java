package com.company;

import com.company.model.Document;
import com.company.model.Tier;
import com.company.model.User;
import java.util.*;
import com.company.service.DocumentService;
import com.company.service.UserService;

import javax.jws.soap.SOAPBinding;

public class Driver {
    static List<User> users=new ArrayList<>();

    static  List<User> generateUsers(){
        for (int i=0;i<10;i++){
            User u=new User();
            u.setId(i);
            u.setName("user"+i);
            users.add(u);
        }
        return users;
    }

    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(List<User> users) {
        Driver.users = users;
    }

    public static void main(String[] args) {
        List<User> users=generateUsers();
        DocumentService documentService=new DocumentService();
        UserService userService=new UserService();
        User testUser=users.get(0);
        documentService.createDocument(testUser,"test","content", Tier.COLD);

        String document=documentService.fetchDocument("test",Tier.COLD,testUser);
        System.out.println(document);
      //  userService.grantGlobalAccess("test",testUser);
        List<User> testList=new ArrayList<>();
        testList.add(users.get(1));

        userService.grantGlobalAccess("test",testUser);

        String document1=documentService.fetchDocument("test",Tier.COLD,users.get(2));
        System.out.println(document1);
    }
}
