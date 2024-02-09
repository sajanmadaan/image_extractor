package com.example.imageupload.service;

import com.example.imageupload.mapper.UploadedImageMapper;
import com.example.imageupload.model.UploadedImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@Service
public class UploadedImageService {

    @Autowired
    private UploadedImageMapper imageMapper;

    @Autowired
    private OCRService ocrService;

    public void uploadImage(byte[] imageData, MultipartFile file) {

        String extractedText = ocrService.extractText(file);
        String boldWords = ocrService.identifyBoldWords(extractedText);
        UploadedImage uploadedImage = new UploadedImage();
        uploadedImage.setImageData(Arrays.toString(imageData));
        uploadedImage.setExtractedText(extractedText);
        uploadedImage.setBoldWords(boldWords);

        imageMapper.insertImage(uploadedImage);
    }

    public List<UploadedImage> getAllImages() {
        return imageMapper.getAllImages();
    }
}
