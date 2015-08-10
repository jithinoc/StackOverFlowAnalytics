package com.qburst.stackOverFlowAnalytics.helpers;

import com.qburst.stackOverFlowAnalytics.models.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

public class XMLEntityExtractor {
    public void extract_attribute(String xmlPath, String writeTo) throws IOException{
        HashSet<String> locations = new HashSet<String >();
        BufferedReader xmlFileReader = new BufferedReader(new FileReader(xmlPath));
        String line;
        while ((line = xmlFileReader.readLine()) != null) {
            if(line.contains("<row")) {
                line = line.trim().replaceFirst("^([\\W]+)<", "<");
                User user = (User) XMLObjectBuilder.xmlToObject(line, User.class);
                System.out.println(user.getAccountId());
                if (user.getLocation() != null)
                    locations.add(user.getLocation().toLowerCase());
            }
        }
        PrintWriter writeToWriter = new PrintWriter(writeTo, "UTF-8");
        for(String location: locations)
            writeToWriter.println(location);
        writeToWriter.close();
    }

    public static void main(String[] args) throws IOException {
        XMLEntityExtractor xmlEntityExtractor = new XMLEntityExtractor();
        xmlEntityExtractor.extract_attribute("/home/jithinoc/Fatboy/stackoverflow/Users.xml", "/home/jithinoc/Fatboy/stackoverflow/analytics/locations.txt");
    }
}
