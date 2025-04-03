package UtilsMethods;

import java.io.FileInputStream;
import org.junit.Assert;
import java.util.Properties;

public class FileUtilities {
	
	/**
     * This method is used to retrieve VALUES of the PROPERTIES file
     * @param filePath - Properties file path
     * @param key - Expected key of the given properties file
     * @return - VALUE
     */
    public static String getProperty(String filePath, String key) {
        Properties properties = new Properties();
        String value = null;
        try {
            // Load properties from file
            FileInputStream fis = new FileInputStream(filePath);
            properties.load(fis);
            fis.close();

            // Retrieve value by key
            value = properties.getProperty(key);
            return value;
        }
        catch (Exception e){
            Assert.fail("TestFailed: Unable to retrieve the value of the properties file using key" + e.getMessage());
        }
        return null;
    }


}
