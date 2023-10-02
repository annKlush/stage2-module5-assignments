package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger; // Import the Logger class
import java.util.stream.Collectors;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private final Long period = 10_000_000_000_000L; // Set the period as final
    private String processorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    private static List<String> stringArrayList = new ArrayList<>(); // Change to a static reference

    // Create a Logger instance
    private static final Logger logger = Logger.getLogger(LocalProcessor.class.getName());

    public LocalProcessor(String processorName, String processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, List<String> stringList) {
        this.processorName = processorName;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringArrayList = stringList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        // Use a logger to print hash codes
        stringList.forEach(str -> logger.info("Hash code: " + str.hashCode()));
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList) {
        // Use Java Streams to concatenate strings
        return stringList.stream().collect(Collectors.joining(" ", processorName + " ", ""));
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        informationScanner = new Scanner(file);
        StringBuilder builder = new StringBuilder();
        while (informationScanner.hasNextLine()) {
            builder.append(informationScanner.nextLine());
        }
        processorVersion = builder.toString();
    }
}