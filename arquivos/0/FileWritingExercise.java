import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWritingExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // Solicita o nome do arquivo
        System.out.print("Digite o nome do arquivo (com extensão .txt): ");
        String fileName = scanner.nextLine();


        // implemente o codigo aqui
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            String line;
            while (!"sair".equals(line = scanner.nextLine())) {
                writer.write(line);
                writer.newLine();
            }
            System.out.printf("O arquivo %s foi criado com sucesso!\n", fileName);;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        scanner.close();
    }
}