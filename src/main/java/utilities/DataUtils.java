package utilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataUtils {

    public static String dataPathFolder = "src/test/resources/testData/" ;
    //TODO :: read Json File

    public static String readJsonFile(String fileName , String key) throws FileNotFoundException {
        FileReader reader = new FileReader(dataPathFolder+fileName+".json") ;
        JsonElement je = JsonParser.parseReader(reader) ;
        return je.getAsJsonObject().get(key).getAsString();
    }


    //TODO :: read property file
    public static String readPropertiesFile(String fileName , String key) throws IOException {
        Properties properties = new Properties() ;
        properties.load(new FileInputStream(dataPathFolder+fileName+".properties"));
        return properties.getProperty(key);
    }

}
