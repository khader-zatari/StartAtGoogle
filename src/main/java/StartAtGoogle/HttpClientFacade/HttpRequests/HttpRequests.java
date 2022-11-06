package StartAtGoogle.HttpClientFacade.HttpRequests;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

class HttpRequests {

    private static final String USER_AGENT = "Mozilla/5.0";

    public static void sendGET(String path) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(path);
        httpGet.addHeader("User-Agent", USER_AGENT);
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

        System.out.println("GET Response Status:: "
                + httpResponse.getStatusLine().getStatusCode());

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                httpResponse.getEntity().getContent()));

        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = reader.readLine()) != null) {
            response.append(inputLine);
        }
        reader.close();

        // print result
        System.out.println(response.toString());
        httpClient.close();
    }

    public static void sendPOST(String path) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(path);
        httpPost.addHeader("User-Agent", USER_AGENT);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("userName", "Pankaj Kumar"));
        urlParameters.add(new BasicNameValuePair("khader", "zatari"));

        HttpEntity postParams = new UrlEncodedFormEntity(urlParameters);
        httpPost.setEntity(postParams);

        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);

        System.out.println("POST Response Status:: "
                + httpResponse.getStatusLine().getStatusCode());

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                httpResponse.getEntity().getContent()));

        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = reader.readLine()) != null) {
            response.append(inputLine);
        }
        reader.close();

        // print result
        System.out.println(response.toString());
        httpClient.close();

    }

    public static void put(String path) throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPut httpPut = new HttpPut(path);
            List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
            urlParameters.add(new BasicNameValuePair("name", "morpheus"));
            urlParameters.add(new BasicNameValuePair("job", "zion resident"));

            HttpEntity postParams = new UrlEncodedFormEntity(urlParameters);
            httpPut.setEntity(postParams);


            System.out.println("Executing request " + httpPut.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };
            String responseBody = httpclient.execute(httpPut, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        }


    }

    public static void delete(String path) throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

            HttpDelete httpDelete = new HttpDelete(path);
            System.out.println("Executing request " + httpDelete.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status < 200 || status >= 300) {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
                return String.valueOf(status);
            };
            String responseBody = httpclient.execute(httpDelete, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        }

    }

    public static void patch(String path) throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPatch httpPatch = new HttpPatch(path);
            List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
            urlParameters.add(new BasicNameValuePair("name", "morpheus"));
            urlParameters.add(new BasicNameValuePair("job", "zion resident"));

            HttpEntity postParams = new UrlEncodedFormEntity(urlParameters);
            httpPatch.setEntity(postParams);


            System.out.println("Executing request " + httpPatch.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };
            String responseBody = httpclient.execute(httpPatch, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        }


    }
}