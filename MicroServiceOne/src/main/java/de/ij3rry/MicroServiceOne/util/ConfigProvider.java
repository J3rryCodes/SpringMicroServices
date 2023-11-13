package de.ij3rry.MicroServiceOne.util;


import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class ConfigProvider {

    private static Map<String, Object> yamlData;
    public static String getBookStoreFileNamePrefix(){
        return (String) ((Map<?, ?>) getYMLData().get("bookStore")).get("file.preFix");
    }

    public static String getBookStoreFileType(){
        return (String) ((Map<?, ?>) getYMLData().get("bookStore")).get("file.xml");
    }

    private static Map<String, Object> getYMLData(){
        if(yamlData == null) {
            InputStream input = ConfigProvider.class.getClassLoader().getResourceAsStream("config.yml");
            yamlData = new Yaml().load(input);
        }
        return yamlData;
    }
}
