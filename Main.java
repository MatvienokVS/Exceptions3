import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("input.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.matches("^[a-zA-Zа-яА-Я]+$")) {
                System.out.println("Ошибка: введены некорректные данные");
                continue;
            }
            String[] parts = line.split(" ");
            String firstName = parts[0];
            String lastName = parts[1];
            String birthDay = parts[2];
            String telephoneNumber = parts[3];
            String gender = parts[4].toLowerCase();
            
            // Проверка количества частей
            int count = 0;
            for (int i = 5; i >= 1; i--) {
                if (parts[i].equals("пол")) {
                    count++;
                }
            }
            if (count != 4) {
                System.out.println("Ошибка: введены некорректные данные");
                continue;
            }
            
            // Создание файла для записи
            String fileName = firstName + ".txt";
            String dataToWrite = firstName + " " + lastName + " " + birthDay + " " + telephoneNumber + " " + gender + "\n";
            
            // Запись данных в файл
            try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName))) {
                writer.println(dataToWrite);
            } catch (IOException e) {
                System.out.println("Ошибка при записи данных в файл");
                e.printStackTrace();
            }
        }
        scanner.close();
    }
}