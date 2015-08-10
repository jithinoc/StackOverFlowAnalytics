package com.qburst.stackOverFlowAnalytics.helpers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class HashTable {
    private HashMap<String, String> hashMap = new HashMap<String, String>();

    public HashTable(String sourceFile, String separator) throws IOException{
        BufferedReader sourceFileReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(sourceFile), "UTF-8")
        );
        String line;
        String key=null, value;
        while ((line = sourceFileReader.readLine()) != null) {
            String[] splits = line.split(separator);
            if(splits.length==2) {
                key = splits[0].toLowerCase();
                value = splits[1].toLowerCase();
                hashMap.put(key, value);
            }

        }
        System.out.println(hashMap.size());
    }

    public String get(String key) {
        String value =  hashMap.get(key.toLowerCase());
        if(value==null) {
            return "#undefined#";
        } else {
            return value;
        }
    }

    public static void main(String[] args) throws IOException {
        HashTable hashTable = new HashTable("/home/jithinoc/Fatboy/stackoverflow/analytics/addressMap.txt", "000#000");
        System.out.println(hashTable.get("west coast, usa"));
    }

}
