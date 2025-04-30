package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) throws IOException {
        byte[] inputBytes = Files.readAllBytes(Paths.get("verylargefile.txt"));
        StringBuffer output = new StringBuffer();
        long start = System.currentTimeMillis();
        for (byte b : inputBytes) {
            output.append((char) b);
        }
        long end = System.currentTimeMillis();
        System.out.println("Time (with StringBuffer): " + (end - start) + " ms");
    }
}
