package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) throws IOException {
        byte[] inputBytes = Files.readAllBytes(Paths.get("verylargefile.txt"));
        String outputString = "";
        long start = System.currentTimeMillis();
        for (byte b : inputBytes) {
            outputString += (char) b;
        }
        long end = System.currentTimeMillis();
        System.out.println("Time (with '+'): " + (end - start) + " ms");
    }
}
