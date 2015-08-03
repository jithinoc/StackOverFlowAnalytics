package com.qburst.stackOverFlowAnalytics.helpers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Indexer {
    private HashMap<String, String> hashMap = new HashMap<String, String>();
    public Indexer(String sourcePath, String separator) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(sourcePath), "UTF-16"));
        String line;
        String address, country;
        while ((line = br.readLine()) != null) {
            String[] splits = line.split(separator);
            address = splits[0];
            String[] secondSplits = splits[1].split(",");
            if(secondSplits[secondSplits.length-1].matches(".*\\d+.*")) {
                country = secondSplits[secondSplits.length-2];
            } else {
                country = secondSplits[secondSplits.length-1];
            }
            hashMap.put(address, country);
        }
    }

    public String get(String key) {
        return hashMap.get(key);
    }

    public static void main(String[] args) throws Exception{
        Indexer indexer = new Indexer("/home/jithinoc/Fatboy/stackoverflow/countryMap.txt", "##");
        System.out.println(indexer.get("washington, d.c"));
    }
}
