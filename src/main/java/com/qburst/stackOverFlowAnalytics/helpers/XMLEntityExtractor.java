package com.qburst.stackOverFlowAnalytics.helpers;

import com.qburst.stackOverFlowAnalytics.models.Post;
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
        PrintWriter noLocationWriter = new PrintWriter("/home/jithinoc/Fatboy/stackoverflow/analytics/noLocationUsers.txt", "UTF-8");
        PrintWriter writeToWriter = new PrintWriter(writeTo, "UTF-8");
        while ((line = xmlFileReader.readLine()) != null) {
            if(line.contains("<row")) {
                line = line.trim().replaceFirst("^([\\W]+)<", "<");
                Post post = (Post) XMLObjectBuilder.xmlToObject(line, Post.class);
                System.out.println(post.getOwnerUserId());
                if (post.getOwnerUserId() != null)
                    writeToWriter.println(post.getOwnerUserId());
//                    locations.add(user.getLocation().toLowerCase());
//                    if(user.getAccountId() != null)
//                    noLocationWriter.println(user.getAccountId());
            }
        }

//        for(String location: locations)
//            writeToWriter.println(location);
        writeToWriter.close();
    }

    public static void main(String[] args) throws IOException {
        XMLEntityExtractor xmlEntityExtractor = new XMLEntityExtractor();
        xmlEntityExtractor.extract_attribute("/home/jithinoc/Fatboy/stackoverflow/Posts.xml", "/home/jithinoc/Fatboy/stackoverflow/analytics/uids.txt");
    }
}
