
import java.io.FileWriter;
import java.io.IOException;

import java.util.List;

public class CsvUtil {

    
    public static void saveToFile(List<List<String>> rows,String fileName) throws IOException {
        FileWriter csvWriter=new FileWriter(fileName);
        for(List<String> rowData: rows){
            csvWriter.append(String.join(",",rowData));
            csvWriter.append("\n");
        }
        csvWriter.flush();
        csvWriter.close();
    }
}
