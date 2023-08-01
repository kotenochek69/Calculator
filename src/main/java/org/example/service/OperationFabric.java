package org.example.service;

import org.example.model.Calculation;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class OperationFabric {
    private Properties catalogProps = new Properties();
    public OperationFabric() throws IOException {
        InputStream file = getClass().getClassLoader().getResourceAsStream("config.properties");
        catalogProps.load(file);
    }
    public Calculation Create(String value) throws IOException {
        String command = catalogProps.getProperty(value);
        try {
            Class<?> class_operation = Class.forName(command);
            return (Calculation) class_operation.getConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
