package com.studer.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 07.06.2016.
 */
public class Arithmetic {
    List<Operation> operations;

    public Arithmetic(String path) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path));
            String line;
            this.operations = new ArrayList<Operation>();
            while ((line = reader.readLine()) != null) {
                operations.add(Operation.getInstanse(line));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            operations = null;
        } catch (IOException e) {
            operations = null;
        }
        System.out.println(operations);

    }
    public List<Operation> getOperations(){
        return this.operations;
    }
}
