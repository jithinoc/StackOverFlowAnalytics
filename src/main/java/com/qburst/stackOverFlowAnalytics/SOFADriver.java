package com.qburst.stackOverFlowAnalytics;

import com.qburst.stackOverFlowAnalytics.helpers.HBaseClient;
import com.qburst.stackOverFlowAnalytics.helpers.JobHelper;
import com.qburst.stackOverFlowAnalytics.mapreduce.countryDistribution.CDJob;
import org.apache.hadoop.conf.Configuration;

import java.io.IOException;

public class SOFADriver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Configuration configuration = JobHelper.createConfiguration(args[0]);
        HBaseClient hBaseClient = new HBaseClient();
        hBaseClient.createTable(configuration.get("table"), new String[]{configuration.get("columnFamily")});
        CDJob cdJob = new CDJob(configuration);
        cdJob.run();
    }
}
