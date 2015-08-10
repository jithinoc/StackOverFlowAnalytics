package com.qburst.stackOverFlowAnalytics.helpers;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Set;

public class JobHelper {
    private static Logger LOGGER = Logger.getLogger(JobHelper.class);

    public static Configuration createConfiguration(String configFile) throws FileNotFoundException{
        Configuration configuration = HBaseConfiguration.create();

            YMLParser ymlParser = new YMLParser();
            Map<String, String> map = ymlParser.getMap(configFile);
            Set<String> keys = map.keySet();
            for(String key: keys) {
                configuration.set(key, map.get(key));
            }

        return configuration;
    }
}
