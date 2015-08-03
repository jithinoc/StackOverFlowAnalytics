package com.qburst.stackOverFlowAnalytics.mapreduce.countryDistribution;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.Text;
import org.apache.log4j.Logger;

public class CDReducer extends TableReducer<Text, Text, ImmutableBytesWritable> {
    private Logger LOGGER = Logger.getLogger(CDReducer.class);
    public void reduce(Text key, Iterable<Text> values, Context context) {
        Configuration configuration = context.getConfiguration();
        int postCount=0;
        String country="Undefined";
        for(Text value: values) {
            if(value.toString().equals("one")) {
                postCount++;
            } else {
                country = value.toString();
            }
        }
        Put put = new Put(Bytes.toBytes(country));
        byte[] columnFamily = Bytes.toBytes(configuration.get("columnFamily"));
        byte[] columnName = Bytes.toBytes(configuration.get("countryColumn"));
        put.add(columnFamily, columnName, Bytes.toBytes(country));
        columnName = Bytes.toBytes(configuration.get("postCountColumn"));
        put.add(columnFamily, columnName, Bytes.toBytes(String.valueOf(postCount)));
        try {
            context.write(null, put);
        }catch (Exception ex) {
            LOGGER.info("Reducer failed");
        }
    }
}
