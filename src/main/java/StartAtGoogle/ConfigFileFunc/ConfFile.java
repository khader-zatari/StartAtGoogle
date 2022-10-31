package StartAtGoogle.ConfigFileFunc;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.google.gson.*;

class ConfFile {
    //read and write to and from the file, we should write it in a util folder class .
    //

    private final Map<String, String> fileData;

    public ConfFile() {
        fileData = new HashMap<>();
    }

    public void readFile(String path) {
        try {
            FileReader file = new FileReader(path);
            JsonObject jsonObject = JsonParser.parseReader(file).getAsJsonObject();
            insertDataToMap(jsonObject);
        } catch (FileNotFoundException | JsonIOException e) {
            genAndInsertDefaultFile();
        } catch (JsonSyntaxException e) {
            throw new IllegalArgumentException("Json Syntax not right");
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException("file is empty, please read it again");
        }
    }

    private void insertDataToMap(JsonObject jsonObj) {
        for (Map.Entry<String, JsonElement> obj : jsonObj.entrySet()) {
            this.fileData.put(obj.getKey(), obj.getValue().getAsString());
        }
    }

    private void genAndInsertDefaultFile() {
        // he made a hash map and put each key and value, then enter the hashmap into Gson object.
        String path = "/Users/khaderzatari/Desktop/StartAtGoogle/src/main/java/StartAtGoogle/week5/Ex1/defaultFile.json";
        String defaultText = "{\n" +
                "  \"Haitham\": \"Zatari\",\n" +
                "  \"Rawya\": \"Zatari\"\n" +
                "}";
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(Paths.get(path)), StandardCharsets.UTF_8))) {

            writer.write(defaultText);
            JsonObject jsonObject = JsonParser.parseString(defaultText).getAsJsonObject();
            insertDataToMap(jsonObject);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public String getKeyValue(String key) {
        String keyValue = "";

        keyValue = this.fileData.get(key);
        if (keyValue == null) {
            throw new IllegalArgumentException("key not found");
        }

        return keyValue;

        ///you should do it like that.
//        try {
//            return Objects.requireNonNull(this.fileData.get(key))
//        } catch (NullPointerException e) {
//            throw new IllegalArgumentException("key not found");
//        }
    }

}
