package com.qburst.stackOverFlowAnalytics.helpers;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class AddressFinder {
    private String getResponse(URL url) throws IOException {
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        String encoding = urlConnection.getContentEncoding();
        encoding = (encoding == null) ? "UTF-8" : encoding;
        return IOUtils.toString(inputStream, encoding);
    }

    private String getAddressFromBody(String body) {
        JSONObject json = (JSONObject) JSONSerializer.toJSON(body);
        String status = json.getString("status");
        String formattedAddress;
        if(status.equals("OK")) {
            JSONArray jsonArray = json.getJSONArray("results");
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            formattedAddress = jsonObject.getString("formatted_address");
        } else {
            formattedAddress = "#undefined#";
        }
        return formattedAddress;
    }

    /* Returns formatted_address value from json response after google maps api request */
    public String getFormattedAddress(String text) throws IOException {
        URL url = new URL("https://maps.googleapis.com/maps/api/geocode/json?address=" +
                URLEncoder.encode(text, "UTF-8")+
                "&sensor=false&key=AIzaSyCylO2gdL8br3doelaZBgc7gpCCYzi5RdU"
        );
        // AIzaSyCylO2gdL8br3doelaZBgc7gpCCYzi5RdU
        // AIzaSyA0_I3gZ2_wFAQpOiCgEH7hTkmOKr9mNm4
        String body = getResponse(url);
        return getAddressFromBody(body);
    }

    /*
    sourceFile:       contains list of text to search
    successQueryFile: fills with formatted_address for each sourceFile input
    failedQueryFile:  fills with failed query inputs
    */
    public void getAllFormattedAddress(String sourceFile, String successQueryFile, String failedQueryFile) throws IOException {
        BufferedReader sourceFileReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(sourceFile), "UTF-8")
        );
        PrintWriter successQueryFileWriter = new PrintWriter(successQueryFile, "UTF-8");
        PrintWriter failedQueryFileWriter = new PrintWriter(failedQueryFile, "UTF-8");
        String line;
        while ((line = sourceFileReader.readLine()) != null) {
            System.out.println(line);
            String formatted_address = this.getFormattedAddress(line.trim());
            if(formatted_address.equals("#undefined#")) {
                failedQueryFileWriter.println(line);
            } else {
                successQueryFileWriter.println(line + "##" + formatted_address);
            }
        }
        successQueryFileWriter.close();
        failedQueryFileWriter.close();
    }

    public static void main(String[] args) throws IOException {
        AddressFinder addressFinder = new AddressFinder();
        addressFinder.getAllFormattedAddress(args[0], args[1], args[2]);
//        System.out.println(addressFinder.getFormattedAddress("chennai"));
    }
}
