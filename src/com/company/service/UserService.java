package com.company.service;

import com.company.Driver;
import com.company.model.Document;
import com.company.model.GrantType;
import com.company.model.User;
import com.sun.xml.internal.ws.util.StringUtils;

import javax.jws.soap.SOAPBinding;
import javax.print.Doc;
import java.util.List;
import java.util.Optional;

public class UserService {
    public String grantAccess(List<User> users, String documentName,User owner){
        Optional<Document> documentOptional=owner.getDocuments().stream().filter(document1 -> document1.getName()!="" && document1.getName()!=null &&  document1.getName().equals(documentName)).findFirst();
        if(documentOptional.isPresent()){
            Document document=documentOptional.get();
            List<User> accessors= document.getAccessors();
            document.setGrantType(GrantType.CUSTOM);
            accessors.addAll(users);
            users.forEach(user -> {
                user.getDocuments().add(document);
            });
         return "OWNER HAS GRANTED ACCESS";
        }

        return "USER IS NOT OWNER OF THE DOCUMENT";
    }

    public String grantGlobalAccess(String documentName,User owner){
        List<User> allUsers=Driver.getUsers();
        Optional<Document> documentOptional=owner.getDocuments().stream().filter(document1 -> document1.getName()!="" && document1.getName()!=null &&  document1.getName().equals(documentName)).findFirst();
        if(documentOptional.isPresent()) {
            Document document=documentOptional.get();
            List<User> accessors= document.getAccessors();
            accessors.addAll(allUsers);
            document.setGrantType(GrantType.GLOBAL);
            allUsers.forEach(user -> {
                user.getDocuments().add(document);
            });
            return "OWNER HAS GRANTED ACCESS";
        }
        return "USER IS NOT OWNER OF THE DOCUMENT";
    }
}
