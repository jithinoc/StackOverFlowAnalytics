package com.qburst.stackOverFlowAnalytics.helpers;

import com.qburst.stackOverFlowAnalytics.models.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

public class XMLEntityExtractor {
    public void extract_attribute(String xmlPath, String writeTo) {
        HashSet<String> locations = new HashSet<String >();
        try (BufferedReader br = new BufferedReader(new FileReader(xmlPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim().replaceFirst("^([\\W]+)<","<");
                User user = (User)XMLObjectBuilder.xmlToObject(line, User.class);
                System.out.println(user.getAccountId());
                if(user.getLocation()!=null)
                    locations.add(user.getLocation().toLowerCase());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            PrintWriter writer = new PrintWriter(writeTo, "UTF-16");
            for(String line: locations) {
                writer.println(line);
            }
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        XMLEntityExtractor xmlEntityExtractor = new XMLEntityExtractor();
        xmlEntityExtractor.extract_attribute("/home/jithinoc/Fatboy/stackoverflow/Users.xml", "/home/jithinoc/Fatboy/stackoverflow/locations.txt");
    }
}
