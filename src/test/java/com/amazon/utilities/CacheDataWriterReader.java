package com.amazon.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class CacheDataWriterReader {

         String propFilePath;

        public void propertyFile(String fileName)
        {
            propFilePath = "./src/test/resources/CacheData/[name].properties".replace("[name]", fileName);
            File file = new File(propFilePath);

            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } // if file already exists will do nothing
        }

        public void saveProperty(String key, String value) {
            Properties prop = new Properties();

            try {

                FileInputStream input = new FileInputStream(propFilePath);
                // load existing property values
                prop.load(input);

                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                // set the properties value
                prop.setProperty(key.toString(), value);

                FileOutputStream output = new FileOutputStream(propFilePath);
                // save properties to Test data file
                prop.store(output, null);

                if (output != null) {
                    try {
                        output.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            } catch (IOException io) {
                io.printStackTrace();
            }

        }

        public String getPropertyValues(String key) {
            Properties prop = new Properties();

            try {

                FileInputStream input = new FileInputStream(propFilePath);

                // load a properties file
                prop.load(input);

                // get the property value and print it out
                String value = prop.getProperty(key.toString());

                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                return value;

            } catch (IOException ex) {
                ex.printStackTrace();
                return "";
            }

        }
    }

