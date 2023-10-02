package assignments;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class LocalProcessor {
    private String processorName;
    private final Long period;
    private String processorVersion;
    private Scanner informationScanner;

    public LocalProcessor(String processorName, Long period, String processorVersion,
                          Scanner informationScanner) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.informationScanner = informationScanner;
    }

    public LocalProcessor() {
        this.period = 10000000000000L;  // Default period value
    }

    @ListIteratorAnnotation
    public void listIterator(LinkedList<String> stringList) {
        LinkedList<String> stringArrayList = new LinkedList<>(stringList); // Convert to local variable
        for (int i = 0; i < period; i++) {
            if (i < stringArrayList.size()) {
                System.out.println(stringArrayList.get(i).hashCode());
            }
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(LinkedList<String> stringList) {
        StringBuilder fullName = new StringBuilder(processorName);
        for (String str : stringList) {
            fullName.append(' ').append(str);
        }
        return fullName.toString();
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        Scanner informationScanner = new Scanner(file); // Convert to local variable
        StringBuilder fullProcessorVersion = new StringBuilder(processorVersion);
        while (informationScanner.hasNextLine()) {
            fullProcessorVersion.append(informationScanner.nextLine());
        }
        processorVersion = fullProcessorVersion.toString();
        informationScanner.close(); // Close the local Scanner variable when done
    }
}