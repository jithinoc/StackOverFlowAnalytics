package com.qburst.stackOverFlowAnalytics.helpers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class HashTable {
    private HashMap<String, String> hashMap = new HashMap<String, String>();

    public HashTable(String sourceFile, String separator) throws Exception{
        BufferedReader sourceFileReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(sourceFile), "UTF-16")
        );
        String line;
        String key, value;
        while ((line = sourceFileReader.readLine()) != null) {
            String[] splits = line.split(separator);
            key = splits[0].toLowerCase();
            value = splits[1].toLowerCase();
            hashMap.put(key, value);
        }
    }

    public String get(String key) {
        return hashMap.get(key.toLowerCase());
    }

}
