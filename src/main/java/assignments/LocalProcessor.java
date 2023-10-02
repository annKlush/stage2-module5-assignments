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
    private Integer valueOfCheap;
    private Scanner informationScanner;
    private LinkedList<String> stringArrayList;

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, LinkedList<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
        this.period = 10000000000000L;  // Default period value
    }

    @ListIteratorAnnotation
    public void listIterator(LinkedList<String> stringList) {
        LinkedList<String> localList = new LinkedList<>(stringList);
        for (int i = 0; i < period; i++) {
            if (i < localList.size()) {
                System.out.println(localList.get(i).hashCode());
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
        informationScanner = new Scanner(file);
        StringBuilder fullProcessorVersion = new StringBuilder(processorVersion);
        while (informationScanner.hasNextLine()) {
            fullProcessorVersion.append(informationScanner.nextLine());
        }
        processorVersion = fullProcessorVersion.toString();
    }
}