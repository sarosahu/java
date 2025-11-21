package com.example.structural.proxy.virtual.one;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Bitmap extends Image{
    // The loaded image will be kept in this buffer
    private StringBuilder buffer = new StringBuilder();

    public Bitmap() {
    }
    public Bitmap(String fileName) {
        super(fileName);
    }

    @Override
    public void display() {
        System.out.println(buffer.toString());
    }

    @Override
    public void load() {
        /**
        try {
            String fileName = this.getFileName();
            FileInputStream f = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
         */
        BufferedReader reader;
        try {
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(getFileName());
            InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            reader = new BufferedReader(streamReader);
            //reader = new BufferedReader(new FileReader(getFileName()));
            String line = reader.readLine();
            while (line != null) {
                //System.out.println(line);
                buffer.append(line);
                buffer.append('\n');
                line = reader.readLine();
                Thread.sleep(1000);
                System.out.printf(".");
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void load(String fileName) {
        setFileName(fileName);
        load();
    }
}
