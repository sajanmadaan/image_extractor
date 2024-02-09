package com.example.imageupload.service;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class OCRService {

     public String extractText(MultipartFile file) {
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath(System.getenv("TESSDATA_PREFIX"));

        try (InputStream inputStream = file.getInputStream()) {
            BufferedImage bufferedImage = ImageIO.read(inputStream);
            return tesseract.doOCR(bufferedImage);
        } catch (IOException | TesseractException e) {
            e.printStackTrace();
            return "";
        }
    }


    public String identifyBoldWords(String text) {
        List<String> boldWords = new ArrayList<>();

        String[] words = text.split("\\s+");

        for (String word : words) {
            if (isBold(word)) {
                boldWords.add(word);
            }
        }

        return "Bold words: " + boldWords;
    }

    private boolean isBold(String word) {
        if (word.startsWith("<b>") && word.endsWith("</b>")) {
            return true;
        }
        if (word.equals(word.toUpperCase())) {
            return true;
        }
        return false;
    }

}
