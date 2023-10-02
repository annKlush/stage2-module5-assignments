package assignments;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

@Getter
@Setter
public class LocalProcessor {
    private static final Logger logger = Logger.getLogger(LocalProcessor.class.getName());

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
            logger.log(Level.INFO, "Hash code: {0}", localList.get(i).hashCode());
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
        while (informationScanner.hasNext()) {
            fullProcessorVersion.append(informationScanner.nextLine());
        }
        processorVersion = fullProcessorVersion.toString();
    }
}