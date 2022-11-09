package StartAtGoogle.Debug;

import java.util.logging.Logger;

public class Debug {
    static class Debugger {
        public void log(Object o) {
            System.out.println(o.toString());
        }
    }
    static Logger log = Logger.getLogger(Debugger.class.getName());
    public static void main(String[] args) {
        Debugger debugger = new Debugger();
        int n = 10 ;
        while(n > 0){
            int r  = n % 10;
            n--;
            log.info("hello iam here");

        }

    }


}
