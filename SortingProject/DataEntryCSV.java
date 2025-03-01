//DataEntryCSV.java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataEntryCSV {
    public static int[] loadData(String filePath) {
        List<Integer> dataList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    dataList.add(Integer.valueOf(line.trim()));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return dataList.stream().mapToInt(Integer::intValue).toArray();
    }
}