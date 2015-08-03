package com.qburst.stackOverFlowAnalytics.mapreduce.countryDistribution;

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

    public void map(LongWritable key, Text value, Context context) {
        Configuration configuration = context.getConfiguration();
        String sourceFile = ((FileSplit) context.getInputSplit()).getPath().getName();
        if(sourceFile.equals(configuration.get("postFile"))) {
            try {
                Post post = (Post)XMLObjectBuilder.xmlToObject(value.toString(), Post.class);
                String ownerUserId = post.getOwnerUserId();
                if(ownerUserId==null) {
                    ownerUserId = "Undefined";
                }
                Text userId = new Text(ownerUserId);
                Text one = new Text("one");
                context.write(userId, one);
            } catch (IOException ex) {
                LOGGER.info("Unable to parse Post xml");
                LOGGER.info(ex.getMessage());
            } catch (InterruptedException ex) {
                LOGGER.info("Mapper interrupted on Post");
            }
        } else {
            try {
                User user = (User)XMLObjectBuilder.xmlToObject(value.toString(), User.class);
                Text userId = new Text(user.getAccountId());
                String locationValue = user.getLocation();
                String country;
                if(locationValue==null) {
                    locationValue = "Undefined";
                }
                if(locationValue.contains(",")) {
                    String[] tokens = locationValue.split(",");
                    country = tokens[tokens.length-1];
                } else {
                    country = locationValue;
                }
                Text location = new Text(country);
                context.write(userId, location);
            } catch (IOException ex) {
                LOGGER.info("Unable to parse User xml");
                LOGGER.info(ex.getMessage());
            } catch (InterruptedException ex) {
                LOGGER.info("Mapper interrupted on User");
            }
        }
    }
}
