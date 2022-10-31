package StartAtGoogle.Generic;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Callable<String> stringCallable = new Callable<>() {
            @Override
            public String call() throws Exception {
                return "10";
            }
        };
        Callable<Double> doubleCallable = new Callable<>() {
            @Override
            public Double call() throws Exception {
                return ThreadLocalRandom.current().nextDouble(10);
            }
        };
        Callable<Integer> intCallable = new Callable<>() {
            @Override
            public Integer call() throws Exception {
                return ThreadLocalRandom.current().nextInt(10);
            }
        };

        retry(intCallable, 5);
//        retry(doubleCallable, 10.0);
//        retry(stringCallable, "10");

    }

    public static <T> T retry(Callable<T> action, T expectedResult, int countTry, int sleepTime) {
        //check if countTry if it's 0 or -1.. .
        //it's butter (less readable. this is the reason) done using do while. do {currentRes = action.call(); counter ++} while(!currentRes.equals(expectedResult)&& counter < retryCount)

        T actionRes = null;
        for (int i = 0; i < countTry; i++) {
            try {
                actionRes = action.call();
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (actionRes == expectedResult) // here we should make actionRes.equals(expectedResult)
            {
                return expectedResult;
            }
            if (i == countTry - 1) {
                return actionRes;
            }
            try {
                System.out.println(actionRes);
                Thread.sleep(sleepTime);
            } catch (Exception e) {
                e.printStackTrace(); // or throw exception
            }


        }
        return null;
    }

    public static <T> T retry(Callable<T> action, T expectedResult) {
        return retry(action, expectedResult, 1000, 10);
    }

}