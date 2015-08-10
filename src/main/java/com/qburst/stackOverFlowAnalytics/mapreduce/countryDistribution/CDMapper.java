package com.qburst.stackOverFlowAnalytics.mapreduce.countryDistribution;

import com.qburst.stackOverFlowAnalytics.helpers.HashTable;
import com.qburst.stackOverFlowAnalytics.helpers.XMLObjectBuilder;
import com.qburst.stackOverFlowAnalytics.models.Post;
import com.qburst.stackOverFlowAnalytics.models.User;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.log4j.Logger;

import java.io.IOException;

public class CDMapper extends Mapper<LongWritable, Text, Text, Text> {
    private Logger LOGGER = Logger.getLogger(CDMapper.class);
    private HashTable locationMapper=null;

    public void setup(Context context) {
        Configuration configuration = context.getConfiguration();
        try {
            locationMapper = new HashTable(configuration.get("locationMap"), configuration.get("locationMapSeperator"));
        } catch (IOException ex) {
            LOGGER.info("Loading locationMapper Failed");
        }
    }

    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
        Configuration configuration = context.getConfiguration();
        String sourceFile = ((FileSplit) context.getInputSplit()).getPath().getName();
        if(sourceFile.equals(configuration.get("postFile"))) {
            if(value.toString().contains("row")) {
                Post post = (Post) XMLObjectBuilder.xmlToObject(value.toString(), Post.class);
                String ownerUserId = post.getOwnerUserId();
                if (ownerUserId == null) {
                    ownerUserId = "Undefined";
                }
                Text userId = new Text(ownerUserId);
                Text one = new Text("one");
                context.write(userId, one);
            }
        } else {
            User user = (User)XMLObjectBuilder.xmlToObject(value.toString(), User.class);
            String accountId = user.getAccountId();
            String userLocation = user.getLocation();
            String country;
            if(accountId==null) {
                accountId = "#undefined#";
            }
            Text userId = new Text(accountId);
            if(userLocation==null) {
                country = "#undefined#";
            } else {
                country = locationMapper.get(userLocation);
            }
            Text location = new Text(country);
            context.write(userId, location);
        }
    }
}
