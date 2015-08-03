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
    public String find(String address) {
        String formatted_address = "Undefined";
        try {
            URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?address="+ URLEncoder.encode(address, "UTF-8")+"&sensor=false");
            URLConnection con = url.openConnection();
            InputStream in = con.getInputStream();
            String encoding = con.getContentEncoding();
            encoding = encoding == null ? "UTF-8" : encoding;
            String body = IOUtils.toString(in, encoding);

            JSONObject json = (JSONObject) JSONSerializer.toJSON(body);
            String status = json.getString("status");
            if(status.equals("OK")) {
                JSONArray jsonArray = json.getJSONArray("results");
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                formatted_address = jsonObject.getString("formatted_address");
                System.out.println(address+ "---"+formatted_address);
            }
        }catch (Exception ex) {
            System.out.println("-------->"+address);
        }
        return formatted_address;
    }

    public void findAll(String sourcePath, String destinationPath) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(sourcePath), "UTF-16"));
            String line;
            PrintWriter writer = new PrintWriter(destinationPath, "UTF-16");
            while ((line = br.readLine()) != null) {
                String formatted_address = this.find(line.trim());
                writer.println(line+"##"+formatted_address);
            }
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AddressFinder addressFinder = new AddressFinder();
        addressFinder.findAll("/home/jithinoc/Fatboy/stackoverflow/locations.txt", "/home/jithinoc/Fatboy/stackoverflow/countryMap.txt");
    }
}
