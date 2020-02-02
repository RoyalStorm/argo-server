package com.arrayteam.argo.server.service;


import com.arrayteam.argo.server.exception.BadFileException;
import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;


@Service
public class ImageService {

    public Blob validate(MultipartFile image) throws IOException {
        String fileName = StringUtils.cleanPath(image.getOriginalFilename());
        String extension = getExtension(fileName).toLowerCase();

        if (extension.equals("png") || extension.equals("jpg"))
            return BlobProxy.generateProxy(image.getBytes());

        throw new BadFileException();
    }

    private String getExtension(String fileName) {
        final int EXTENSION_INDEX = 1;

        return fileName.split("\\.")[EXTENSION_INDEX];
    }

}
