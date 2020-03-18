package com.arrayteam.argo.server.service;


import org.springframework.stereotype.Service;


@Service
public class ContentService {

    public String getExtension(String fileName) {
        final int EXTENSION_INDEX = 1;

        return fileName.split("\\.")[EXTENSION_INDEX].toLowerCase();
    }

}
