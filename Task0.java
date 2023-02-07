import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

//Напишите программу, которая принимает с консоли число в формате byte и записывает его в файл ”result.txt”.
//Требуется перехватить все возможные ошибки и вывести их в логгер.
//После написания, попробуйте подать на вход числа 100 и 200 и проследите разницу в результате

public class Task0 {
    

    public static void main(String[] args) throws SecurityException, IOException {

        try {
            writeToFile(getByteNum());

        } catch (Exception e) {
            Logger logger = Logger.getLogger(Task0.class.getName());
            logger.setLevel(Level.WARNING);
            FileHandler fh = new FileHandler("log.txt");
            logger.addHandler(fh);
            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);
            logger.log(Level.WARNING, "Ошибка. Введено число за границами диапазона -128 до 127 или введено не число.");

        }

    }

    public static Byte getByteNum() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: ");
        Byte value = in.nextByte();
        value.toString();

        return value;
    }

    public static void writeToFile(Byte data) throws IOException {
        File file = new File("result.txt");
        if (file.createNewFile()) {
            System.out.println("File is created!");
        } else {
            System.out.println("File already exists.");
        }
        FileWriter writer = new FileWriter(file);
        writer.write(data.toString());
        writer.close();
    }

}
