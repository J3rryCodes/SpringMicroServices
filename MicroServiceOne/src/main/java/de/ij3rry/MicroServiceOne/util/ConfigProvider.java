package de.ij3rry.MicroServiceOne.util;


import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class ConfigProvider {

    private static Map<String, Object> yamlData;
    public static String getBookStoreFileNamePrefix(){
        Map<?, ?>  bookStore = (Map<?, ?>)  getYMLData().get("bookStore");
        Map<?, ?> file = (Map<?, ?>) bookStore.get("file");
        return (String) file.get("preFix");
    }

    public static String getBookStoreFileType(){
        Map<?, ?>  bookStore = (Map<?, ?>)  getYMLData().get("bookStore");
        Map<?, ?> file = (Map<?, ?>) bookStore.get("file");
        return (String) file.get("type");
    }

    private static Map<String, Object> getYMLData(){
        if(yamlData == null) {
            InputStream input = ConfigProvider.class.getClassLoader().getResourceAsStream("config.yml");
            yamlData = new Yaml().load(input);
        }
        return yamlData;
    }
}
