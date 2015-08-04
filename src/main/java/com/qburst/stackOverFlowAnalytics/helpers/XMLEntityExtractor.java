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
            line = line.trim().replaceFirst("^([\\W]+)<","<");
            User user = (User)XMLObjectBuilder.xmlToObject(line, User.class);
            if(user.getLocation()!=null)
                locations.add(user.getLocation().toLowerCase());
        }
        PrintWriter writeToWriter = new PrintWriter(writeTo, "UTF-16");
        for(String location: locations)
            writeToWriter.println(location);
        writeToWriter.close();
    }
}
