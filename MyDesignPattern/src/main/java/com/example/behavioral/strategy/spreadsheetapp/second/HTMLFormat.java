package com.example.behavioral.strategy.spreadsheetapp.second;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import static com.example.behavioral.strategy.spreadsheetapp.second.DataModel.EMPTYSTR;

public class HTMLFormat implements IFormat {
    private static final String OUTPUT_FILE = "/Users/sarojkumarsahu/ml/data/data.html";

    @Override
    public void exportData(DataModel dataModel) {
        //String filePath = "/Users/sarojkumarsahu/ml/data/data.html";
        File file = new File(OUTPUT_FILE);
        Path path = Paths.get(OUTPUT_FILE);
        try {
            if (file.exists()) {
                Files.delete(path);
            }

            Files.write(path, EMPTYSTR.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
            StringBuilder sb = new StringBuilder()
                    .append("<!DOCTYPE html>\n")
                    .append("<html>\n")
                    .append("<body>\n")
                    .append("<h1>Exported</h1>\n");

            String PARA_START = "<p>";
            String PARA_END = "</p>\n";
            for (List<Integer> row : dataModel.getSheet()) {
                sb.append(PARA_START);
                for (int e : row) {
                    String val = e + " ";
                    sb.append(val);
                }
                sb.append(PARA_END);
            }
            sb.append("</html>\n");
            sb.append("</body>\n");
            Files.write(path, sb.toString().getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException ex) {
            System.err.println("Exception caught : " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }
}
