package com.qburst.stackOverFlowAnalytics.helpers;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.qburst.stackOverFlowAnalytics.models.User;
import org.apache.log4j.Logger;

import java.io.IOException;

public class XMLObjectBuilder {

    private static Logger LOGGER = Logger.getLogger(XMLObjectBuilder.class);
    public static Object xmlToObject(String xml, Class<?> castingClass) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(xml, castingClass);
    }

    public static void main(String[] args) throws IOException {
        String xml = "<row Id=\"-1\" Reputation=\"1\" CreationDate=\"2010-09-01T17:32:37.120\" DisplayName=\"Community\" LastAccessDate=\"2010-09-01T17:32:37.120\" WebsiteUrl=\"http://meta.stackexchange.com/\" Location=\"on the server farm\" AboutMe=\"XXXX\" Views=\"0\" UpVotes=\"119547\" DownVotes=\"14754\" AccountId=\"-1\" />";
        User user = (User)XMLObjectBuilder.xmlToObject(xml, User.class);
        System.out.println(user.getId());
    }
}
