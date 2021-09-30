package com.company.service;

import com.company.model.Document;
import com.company.model.GrantType;
import com.company.model.Tier;
import com.company.model.User;

import javax.print.Doc;
import javax.rmi.CORBA.Tie;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;

public class DocumentService {

    public Document createDocument(User user, String nameOfDocument, String contentOfDocument, Tier tier) {
        if (tier.equals(Tier.HOT)) {
            Document document = new Document();
            document.setName(nameOfDocument);
            document.setContent(contentOfDocument);
            document.setOwner(user);
            document.getAccessors().add(user);
            document.setGrantType(GrantType.PRIVATE);
            document.setTier(tier);
            user.getDocuments().add(document);
            return document;
        } else if (tier.equals(Tier.COLD)) {
            String error = "";
            Document document = new Document();
            document.setName(nameOfDocument);
            document.setContent(contentOfDocument);
            document.setOwner(user);
            document.getAccessors().add(user);
            document.setGrantType(GrantType.PRIVATE);
            document.setTier(tier);
            String fileName = "";
            try {
                File file = new File( nameOfDocument);
                fileName = file.getCanonicalPath();
                FileOutputStream fos = new FileOutputStream(fileName, false);
                byte[] b = contentOfDocument.getBytes();       //converts string into bytes
                fos.write(b);           //writes bytes into file
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
                error = e.getMessage();
            }

            if ("".equals(error)) {
                document.setNameOfFile(fileName);
            }
            user.getDocuments().add(document);
            return document;
        }
        return null;
    }

    public String fetchDocument(String nameOfDocument, Tier tier, User u) {
        if (tier.equals(Tier.HOT)) {
            Optional<Document> documents = u.getDocuments().stream().filter(document1 -> document1.getName().equals(nameOfDocument)).findFirst();
            if (documents.isPresent()) {
                return documents.get().getContent();
            }
        } else if (tier.equals(Tier.COLD)) {
            Optional<Document> documents = u.getDocuments().stream().filter(document1 -> document1.getName().equals(nameOfDocument)).findFirst();
            if (documents.isPresent()) {
                Document document = documents.get();
                String fileName = document.getNameOfFile();
                String content="";
                try{
                    FileInputStream fin=new FileInputStream(fileName);
                    int i=0;
                    while((i=fin.read())!=-1){
                        content+=String.valueOf((char)i);
                    }
                    fin.close();
                }catch(Exception e){System.out.println(e);}
                return content;
            }

            }
        return "NO DOCUMENT FOUND";
        }

    }



