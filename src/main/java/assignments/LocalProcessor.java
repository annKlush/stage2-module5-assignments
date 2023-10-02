package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.StringBuilder;
import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private Long period = 10_000_000_000_000L;
    private String processorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    private static List<String> stringArrayList = new ArrayList<>();
    private StringBuilder stringBuilder = new StringBuilder(); // Add a StringBuilder variable

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, List<String> stringList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringArrayList = stringList;
    }
    public LocalProcessor() {
    }
    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        for (String str : stringList) {
            System.out.println(str.hashCode());
        }
    }
    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList) {
        StringBuilder fullName = new StringBuilder(processorName);
        for (String str : stringList) {
            fullName.append(str).append(' ');
        }
        return fullName.toString();
    }
    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        informationScanner = new Scanner(file);
        StringBuilder builder = new StringBuilder();
        while (informationScanner.hasNextLine()) {
            builder.append(informationScanner.nextLine());
            stringBuilder.append(informationScanner.nextLine()); // Use the StringBuilder here
        }

        processorVersion = builder.toString();
        processorVersion = stringBuilder.toString(); // Update the processorVersion
    }
}