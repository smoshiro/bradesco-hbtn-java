import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileReader {
    public static void main(String[] args) {
        var filename = "funcionarios.csv";
        try (var reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                var fields = line.split(",", -1);
                System.out.printf("Funcionário: %s\n", fields[0]);
                System.out.printf("Idade: %s\n", fields[1]);
                System.out.printf("Departamento: %s\n", fields[2]);
                System.out.printf("Salarial: %s\n", fields[3]);
                System.out.println("------------------------");
            }
            System.out.println("Leitura do arquivo concluída.");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
