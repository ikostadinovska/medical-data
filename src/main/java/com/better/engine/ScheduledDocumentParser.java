package com.better.engine;

import com.better.bean.MedicalDataBean;
import com.better.config.ConfigProperties;
import com.better.model.dto.Doctor;
import com.better.model.dto.DocumentReport;
import com.better.model.enums.DocumentSource;
import com.better.util.FilesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Scheduled task for reading and processing system files from an input directory.
 */
@Component
public class ScheduledDocumentParser {

    private static final Logger log = LoggerFactory.getLogger(ScheduledDocumentParser.class);

    @Autowired
    private ConfigProperties configProperties;

    @Autowired
    private MedicalDataBean bean;

    @Profile("development")
    @Scheduled(fixedRateString = "${documents.folder.interval.milliseconds}")
    public void reportCurrentTime() {
        processInputDirectory();
    }

    /**
     * Read files from input directory and process them.
     */
    private void processInputDirectory() {
        log.info("Read files from input directory.");
        List<File> inputFiles = FilesUtil.readFiles(configProperties.getInput());
        inputFiles.forEach(this::processFile);
    }

    /**
     * Parse document, store it in DB and move the file.
     *
     * @param inputFile
     */
    private void processFile(File inputFile) {
        Doctor doctor = parseFile(inputFile);
        DocumentReport documentReport = bean.createReport(doctor, DocumentSource.SYSTEM_FILE);
        moveFile(inputFile.getName(), Boolean.TRUE.equals(documentReport.getError()));
    }

    /**
     * Move file from input dir to out or error dir.
     *
     * @param fileName
     * @param isError
     */
    private void moveFile(String fileName, boolean isError) {
        String target = isError ? configProperties.getError() : configProperties.getOutput();
        try {
            FilesUtil.moveFile(configProperties.getInput(), target, fileName);
        } catch (IOException e) {
            log.error("Exception occurred while moving file.", e);
        }
    }

    /**
     * Parse input file.
     *
     * @param inputFIle
     * @return
     */
    private Doctor parseFile(File inputFIle) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Doctor.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (Doctor) jaxbUnmarshaller.unmarshal(inputFIle);
        } catch (JAXBException e) {
            log.error("Exception occurred while parsing file.", e);
        }
        return null;
    }
}