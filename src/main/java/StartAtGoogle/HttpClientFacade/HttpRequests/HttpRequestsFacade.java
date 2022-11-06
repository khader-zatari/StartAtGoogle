package StartAtGoogle.HttpClientFacade.HttpRequests;


import java.io.IOException;

public class HttpRequestsFacade {



    public void sendGET(String path) {
        try {
            HttpRequests.sendGET(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendPOST(String path) {
        try {
            HttpRequests.sendPOST(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void put(String path) {
        try {
            HttpRequests.put(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String path) {
        try {
            HttpRequests.delete(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void patch(String path) {
        try {
            HttpRequests.patch(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //we return an object to the client for "response object"-> status code and the body of the message

}