package com.qburst.stackOverFlowAnalytics.mapreduce.countryDistribution;

import com.qburst.stackOverFlowAnalytics.models.Post;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

public class CDMapper extends Mapper<LongWritable, Text, Text, Text> {

    public void map(LongWritable key, Text value, Context context) {
        Configuration configuration = context.getConfiguration();
        String sourceFile = ((FileSplit) context.getInputSplit()).getPath().getName();
        if(sourceFile.equals(configuration.get("postFile"))) {
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(Post.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                InputStream inputStream = new ByteArrayInputStream(value.toString().getBytes(Charset.forName("UTF-8")));
                Post post = (Post)jaxbUnmarshaller.unmarshal(inputStream);
            }catch (Exception ex) {

            }
        } else {

        }
    }
}
