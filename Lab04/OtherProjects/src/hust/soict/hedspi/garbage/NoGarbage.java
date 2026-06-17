package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "OtherProjects/src/hust/soict/hedspi/garbage/CA.RISCV.2025-CH3.pdf";
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();
            StringBuffer outputStringBuffer = new StringBuffer();
            for (byte b : inputBytes) {
                outputStringBuffer.append((char) b);
            }

            String outputString = outputStringBuffer.toString();
            endTime = System.currentTimeMillis();
            System.out.println("Processing time with StringBuffer: " + (endTime - startTime) + "ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}