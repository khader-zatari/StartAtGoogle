package StartAtGoogle.Team;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class NameGenerator {
    List<String> names;

    public NameGenerator(List<String> names) {
        this.names = names;
    }

    public String generateRandomName() {
        return this.names.get(ThreadLocalRandom.current().nextInt(0, names.size()));
    }
}



