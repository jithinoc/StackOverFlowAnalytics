package com.qburst.stackOverFlowAnalytics.mapreduce.countryDistribution;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.log4j.Logger;

import java.io.IOException;

public class CDJob {
    private Logger LOGGER = Logger.getLogger(CDJob.class);
    private Job job;

    public CDJob(Configuration configuration) {
        this.job = createJob(configuration);
    }

    public Job createJob(Configuration configuration) {
        Job job=null;
        try {
            job = new Job(configuration, configuration.get("job"));
            job.setJarByClass(CDJob.class);
            job.setMapperClass(CDMapper.class);
            job.setMapOutputKeyClass(Text.class);
            job.setMapOutputValueClass(Text.class);
            job.setInputFormatClass(TextInputFormat.class);
            TableMapReduceUtil.initTableReducerJob(
                    configuration.get("table"),
                    CDReducer.class,
                    job
            );
            FileInputFormat.addInputPath(job, new Path(configuration.get("source")));
        }catch (IOException ex) {
            LOGGER.info("Job creation failed");
            ex.printStackTrace();
        }
        return job;
    }
    public boolean run() {
        try {
            return job.waitForCompletion(true);
        }catch (Exception ex) {
            LOGGER.info("Job run failed");
            ex.printStackTrace();
            return false;
        }
    }
}
