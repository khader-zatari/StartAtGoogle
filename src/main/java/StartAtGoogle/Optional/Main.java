package StartAtGoogle.Optional;

import java.lang.reflect.Constructor;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<Object> o = checkIfConstractor(new Class1("One"));
        System.out.println(o);
        Optional<Object> o2 = checkIfConstractor(new Class2("One", "Two"));
        System.out.println(o2);

    }

    public static Optional<Object> checkIfConstractor(Object o) {
        try {

            Constructor<?> constructor = o.getClass().getConstructor(String.class);
            Object newObj = constructor.newInstance("random String");
            return Optional.of(newObj);


        } catch (Exception e) {
            return Optional.empty();
        }

    }
}
