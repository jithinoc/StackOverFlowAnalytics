package com.qburst.stackOverFlowAnalytics.helpers;

import com.google.common.collect.Lists;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class HBaseClient {
    private Logger LOGGER = Logger.getLogger(HBaseClient.class);
    private HBaseAdmin hBaseAdmin;
    private Configuration configuration = HBaseConfiguration.create();
    private HTable hTable;

    public HBaseClient() {
        try {
            hBaseAdmin = new HBaseAdmin(configuration);
        } catch (Exception ex) {
            LOGGER.info("HBaseAdmin creation Failed");
            System.exit(1);
        }
    }

    public boolean tableExists(String table) {
        try {
            return hBaseAdmin.tableExists(table);
        } catch (IOException ex) {
            LOGGER.info("Unable to check table exists");
            return false;
        }
    }

    public boolean createTable(String table, String[] columnFamilies) {
        HTableDescriptor hTableDescriptor = new HTableDescriptor(TableName.valueOf(table));
        HColumnDescriptor hColumnDescriptor;
        for(String columnFamily: columnFamilies) {
            hColumnDescriptor = new HColumnDescriptor(columnFamily);
            hTableDescriptor.addFamily(hColumnDescriptor);
        }
        try {
            hBaseAdmin.createTable(hTableDescriptor);
        } catch (IOException ex) {
            LOGGER.info("Unable to create Table: "+table);
            if (tableExists(table))
                LOGGER.info("Table Already Exists");
            System.exit(1);
        }
        return tableExists(table);
    }

    public boolean enableTable(String table) {
        try {
            hBaseAdmin.disableTable(table);
            return hBaseAdmin.isTableEnabled(table);
        } catch (IOException ex) {
            LOGGER.info("Unable to enable " + table);
            return false;
        }
    }

    public boolean disableTable(String table) {
        try {
            hBaseAdmin.disableTable(table);
            return hBaseAdmin.isTableDisabled(table);
        } catch (IOException ex) {
            LOGGER.info("Unable to disable " + table);
            return false;
        }
    }

    public boolean dropTable(String table) {
        disableTable(table);
        try {
            hBaseAdmin.deleteTable(table);
            return !tableExists(table);
        } catch (IOException ex) {
            LOGGER.info("Unable to delete "+table);
            return false;
        }
    }

    public boolean putTable(String table, Put put) {
        try {
            hTable = new HTable(configuration, table);
            hTable.put(put);
            hTable.close();
            return true;
        }catch (IOException ex) {
            LOGGER.info("Instantiating table failed");
            return false;
        }
    }

    public boolean multiplePutTable(String table, List<Put> puts) {
        try {
            hTable = new HTable(configuration, table);
            hTable.put(puts);
            hTable.close();
            return true;
        }catch (IOException ex) {
            LOGGER.info("Instantiating table failed");
            return false;
        }
    }

    public Result getTable(String table, Get get) {
        try {
            hTable = new HTable(configuration, table);
            return hTable.get(get);
        } catch (IOException ex) {
            LOGGER.info("Instantiating table failed");
            System.exit(1);
            return null;
        }
    }

    public List<Result> scanTable(String table, Scan scan) {
        try {
            hTable = new HTable(configuration, table);
            List<Result> results = Lists.newArrayList(hTable.getScanner(scan).iterator());
            LOGGER.info(results.size() + " results found");
            return results;
        } catch (IOException ex) {
            LOGGER.info("Instantiating table failed");
            return null;
        }
    }
}
