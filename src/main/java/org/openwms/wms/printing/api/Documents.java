package org.openwms.wms.printing.api;


import org.ameba.http.AbstractBase;

import org.openwms.wms.printing.impl.DocumentService;

import org.pdfgeneratorapi.client.ApiClient;
import org.pdfgeneratorapi.client.ApiException;
import org.pdfgeneratorapi.client.Configuration;
import org.pdfgeneratorapi.client.api.TemplatesApi;
import org.pdfgeneratorapi.client.auth.HttpBearerAuth;
import org.pdfgeneratorapi.client.model.Data;
import org.pdfgeneratorapi.client.model.InlineResponse2002;
import org.pdfgeneratorapi.client.model.InlineResponse2003;
import org.pdfgeneratorapi.client.model.InlineResponse2004;

import org.springframework.stereotype.Component;


@Component
public class Documents extends AbstractBase implements DocumentService {

    String BEARER_TOKEN = "";
    Integer templateId = 308016;
    String name = "BOL";
    String format = "pdf";
    String output = "url";

    @Override
    public void generateBOL()
    {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v3");

        //Configure HTTP bearer authorization: JSONWebTokenAuth
        HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
        JSONWebTokenAuth.setBearerToken(BEARER_TOKEN);

        TemplatesApi apiInstance = new TemplatesApi(defaultClient);

        Data data = new Data();

        try {
            InlineResponse2004 result = apiInstance.mergeTemplate(templateId, data, name, format, output);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TemplatesApi#mergeTemplate");
            System.err.println("Status Code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response Headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }

    @Override
    public void editBOL() {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v3");

        // Configure HTTP bearer authorization: JSONWebTokenAuth
        HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
        JSONWebTokenAuth.setBearerToken("BEARER_TOKEN");

        TemplatesApi apiInstance = new TemplatesApi(defaultClient);
        Data data = new Data();


        try {
            InlineResponse2004 result = apiInstance.mergeTemplate(templateId, data, name, format, output);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TemplatesApi#mergeTemplate");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }


    @Override
    public void mergeBOL() {

        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v3");

        // Configure HTTP bearer authorization: JSONWebTokenAuth
        HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
        JSONWebTokenAuth.setBearerToken("BEARER TOKEN");

        TemplatesApi apiInstance = new TemplatesApi(defaultClient);
        Data data = new Data();

        try {
            InlineResponse2004 result = apiInstance.mergeTemplate(templateId, data, name, format, output);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TemplatesApi#mergeTemplate");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }


    @Override
    public void deleteBOL() {

        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://us1.pdfgeneratorapi.com/api/v3");

        // Configure HTTP bearer authorization: JSONWebTokenAuth
        HttpBearerAuth JSONWebTokenAuth = (HttpBearerAuth) defaultClient.getAuthentication("JSONWebTokenAuth");
        JSONWebTokenAuth.setBearerToken(BEARER_TOKEN);

        TemplatesApi apiInstance = new TemplatesApi(defaultClient);
        Integer templateId = 308016;
        try {
            InlineResponse2002 result = apiInstance.deleteTemplate(templateId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TemplatesApi#deleteTemplate");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}

