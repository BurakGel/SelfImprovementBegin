package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Logger logger = LoggerFactory.getLogger(ConfigReader.class);
    private static Properties properties;

    static {
        try {
            properties = new Properties();
            InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");
            if (inputStream == null) {
                throw new IOException("config.properties dosyası classpath üzerinde bulunamadı!");
            }
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            logger.error("Config dosyası yüklenirken hata oluştu: ", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
