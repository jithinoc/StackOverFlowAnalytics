package com.qburst.stackOverFlowAnalytics.mapreduce.countryDistribution;

import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.io.Text;

public class CDReducer extends TableReducer<Text, Text, ImmutableBytesWritable> {
}
