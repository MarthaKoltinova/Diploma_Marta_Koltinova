package Properties;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private Properties properties;

    public PropertyReader(String name) {
        properties = new Properties();
        try {
            properties.load(PropertyReader.class.getClassLoader().getResourceAsStream(name + ".properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getProperties() {
        return properties;
    }
}
