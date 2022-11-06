package StartAtGoogle.HttpClientFacade.client;

import StartAtGoogle.HttpClientFacade.HttpRequests.HttpRequestsFacade;

public class Main {
    public static void main(String[] args) {
        final String GET_URL = "https://reqres.in/api/users?page=2";
        final String POST_URL = "https://reqres.in/api/users";
        final String PUT_URL = "https://reqres.in/api/users/2";
        final String PATCH_URL = "https://reqres.in/api/users/2";
        final String DELETE_URL = "https://reqres.in/api/users/2";

        HttpRequestsFacade httpRequest = new HttpRequestsFacade();
        httpRequest.sendGET(GET_URL);
        System.out.println("\n");
        httpRequest.sendPOST(POST_URL);
        System.out.println("\n");
        httpRequest.put(PUT_URL);
        System.out.println("\n");
        httpRequest.delete(DELETE_URL);
        System.out.println("\n");
        httpRequest.patch(PATCH_URL);
        System.out.println("\n");

    }
}
