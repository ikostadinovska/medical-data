package com.better.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Utily class
 */
public class FilesUtil {

    private static final Logger log = LoggerFactory.getLogger(FilesUtil.class);

    /**
     * Private constructor.
     */
    private FilesUtil() {
        throw new IllegalStateException("Utility class.");
    }

    /**
     * Read files from a given directory.
     *
     * @param directoryPath
     * @return
     */
    public static List<File> readFiles(String directoryPath) {
        try (Stream<Path> paths = Files.walk(Paths.get(directoryPath))) {
            return paths
                    .filter(Files::isRegularFile)
                    .filter(p -> p.toString().endsWith(".xml"))
                    .map(Path::toFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            log.error("Exception occurred while reading file.", e);
        }
        return Collections.emptyList();
    }

    /**
     * @param source
     * @param target
     * @param fileName
     * @return
     */
    public static void moveFile(String source, String target, String fileName) throws IOException {
        Files.move(Paths.get(source, fileName), Paths.get(target, fileName));
    }
}
