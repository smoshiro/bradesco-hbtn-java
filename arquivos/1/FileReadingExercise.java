import java.io.*;


public class FileReadingExercise {
    public static void main(String[] args) {
        String fileName = "exemplo.txt"; // Nome do arquivo fixo para leitura


        // efetue a leitura do arquivo
        try (var reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println("Conteúdo do arquivo 'exemplo.txt':");
            System.out.println();
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println();
            System.out.println("Leitura do arquivo concluída.");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
