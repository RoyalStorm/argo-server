package com.arrayteam.argo.server.service;


import com.arrayteam.argo.server.exception.BadFileException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
public class ImageService {

    public byte[] validate(MultipartFile image) throws IOException {
        String fileName = StringUtils.cleanPath(image.getOriginalFilename());
        String extension = getExtension(fileName).toLowerCase();

        if (extension.equals("png") || extension.equals("jpg"))
            return image.getBytes();

        throw new BadFileException();
    }

    private String getExtension(String fileName) {
        final int EXTENSION_INDEX = 1;

        return fileName.split("\\.")[EXTENSION_INDEX];
    }

}
