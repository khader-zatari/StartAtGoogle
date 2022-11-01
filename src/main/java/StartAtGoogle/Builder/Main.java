package StartAtGoogle.Builder;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        JobPosition jobPosition = new JobPosition.Builder("title", LocalDate.now(), true).salaryCap(20000).build();
        System.out.println(jobPosition);

    }
}
