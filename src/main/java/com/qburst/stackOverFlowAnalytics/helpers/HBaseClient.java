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

    public HBaseClient() throws IOException {
        hBaseAdmin = new HBaseAdmin(configuration);
    }

    public boolean tableExists(String table) throws IOException {
        return hBaseAdmin.tableExists(table);
    }

    public boolean createTable(String table, String[] columnFamilies) throws IOException {
        if (tableExists(table)) {
            LOGGER.info("Table already Exists   ");
            return true;
        }
        HTableDescriptor hTableDescriptor = new HTableDescriptor(TableName.valueOf(table));
        HColumnDescriptor hColumnDescriptor;
        for (String columnFamily : columnFamilies) {
            hColumnDescriptor = new HColumnDescriptor(columnFamily);
            hTableDescriptor.addFamily(hColumnDescriptor);
        }

        hBaseAdmin.createTable(hTableDescriptor);

        return tableExists(table);
    }

    public boolean enableTable(String table) throws IOException {
        hBaseAdmin.disableTable(table);
        return hBaseAdmin.isTableEnabled(table);

    }

    public boolean disableTable(String table) throws IOException {
        hBaseAdmin.disableTable(table);
        return hBaseAdmin.isTableDisabled(table);

    }

    public boolean dropTable(String table) throws IOException {
        disableTable(table);
        hBaseAdmin.deleteTable(table);
        return !tableExists(table);

    }

    public boolean putTable(String table, Put put) throws IOException {
        hTable = new HTable(configuration, table);
        hTable.put(put);
        hTable.close();
        return true;

    }

    public boolean multiplePutTable(String table, List<Put> puts) throws IOException {
        hTable = new HTable(configuration, table);
        hTable.put(puts);
        hTable.close();
        return true;

    }

    public Result getTable(String table, Get get) throws IOException {
        hTable = new HTable(configuration, table);
        return hTable.get(get);

    }

    public List<Result> scanTable(String table, Scan scan) throws IOException {
        hTable = new HTable(configuration, table);
        List<Result> results = Lists.newArrayList(hTable.getScanner(scan).iterator());
        LOGGER.info(results.size() + " results found");
        return results;

    }
}
