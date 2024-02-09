package com.example.imageupload.mapper;


import com.example.imageupload.model.UploadedImage;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UploadedImageMapper {


    void insertImage(UploadedImage uploadedImage);

    List<UploadedImage> getAllImages();
}
