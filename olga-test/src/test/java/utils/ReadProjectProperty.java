package utils;

import java.io.IOException;
import java.util.Properties;

import static java.lang.System.getProperty;

public class ReadProjectProperty {


    private static final Properties propertyObject = new Properties();

    private static ReadProjectProperty INSTANCE = new ReadProjectProperty();

    public static ReadProjectProperty getInstance (){
        return INSTANCE;
    }

    private ReadProjectProperty() {
        String environment = getProperty("environment", "delta");

        try {
            propertyObject.load(this.getClass().getResourceAsStream("/" + environment + "Project.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }



    public Properties getProjectProperty() {
        return propertyObject;
    }

    public String getSpecificProjectProperty(String key) {
        return propertyObject.get(key).toString();
    }
}
