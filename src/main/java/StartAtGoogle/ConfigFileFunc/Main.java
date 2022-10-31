package StartAtGoogle.ConfigFileFunc;

public class Main {
    public static void main(String[] args) {

//        ConfFile file = new ConfFile("/Users/khaderzatari/Desktop/StartAtGoogle/src/main/java/StartAtGoogle/week5/Ex1/install_config.xml");
//        ConfFile file = new ConfFile("/Users/khaderzatari/Desktop/StartAtGoogle/src/main/java/StartAtGoogle/week5/Ex1/NO.xml");
        ConfFile file = new ConfFile();
        //file has already created

        file.readFile("/Users/khaderzatari/Desktop/StartAtGoogle/src/main/java/StartAtGoogle/week5/Ex1/file.json");
        System.out.println(file.getKeyValue("Khader"));

        //file hasn't created
        file.readFile("/Users/khaderzatari/Desktop/StartAtGoogle/src/main/java/StartAtGoogle/week5/Ex1/defaultFile.json");
        System.out.println(file.getKeyValue("Haitham"));
        System.out.println(file.getKeyValue("WRONG"));

    }
}
