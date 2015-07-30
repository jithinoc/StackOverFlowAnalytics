package com.qburst.stackOverFlowAnalytics.helpers;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.qburst.stackOverFlowAnalytics.models.Post;
import org.apache.log4j.Logger;

public class XMLObjectBuilder {

    private static Logger LOGGER = Logger.getLogger(XMLObjectBuilder.class);
    public static void xmlToObject(String xml, Object object) {
        try {
            JacksonXmlModule module = new JacksonXmlModule();
            module.setDefaultUseWrapper(false);
            XmlMapper xmlMapper = new XmlMapper(module);
            System.out.println(xmlMapper.readValue(xml, Post.class));
        } catch (Exception ex) {
            LOGGER.info(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        String xml = "<row \"Id\"=\"4\" \"PostTypeId\"=\"1\" AcceptedAnswerId=\"7\" CreationDate=\"2008-07-31T21:42:52.667\" Score=\"322\" ViewCount=\"21888\" Body=\"XXXX\" OwnerUserId=\"8\" LastEditorUserId=\"451518\" LastEditorDisplayName=\"Rich B\" LastEditDate=\"2014-07-28T10:02:50.557\" LastActivityDate=\"2014-12-20T17:18:47.807\" Title=\"When setting a form's opacity should I use a decimal or double?\" Tags=\"&lt;c#&gt;&lt;winforms&gt;&lt;type-conversion&gt;&lt;opacity&gt;\" AnswerCount=\"13\" CommentCount=\"1\" FavoriteCount=\"27\" CommunityOwnedDate=\"2012-10-31T16:42:47.213\"> </row>";
        xmlToObject(xml, Post.class);
    }
}
