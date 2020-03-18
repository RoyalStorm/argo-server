package com.arrayteam.argo.server.dao.model;


import lombok.Data;


@Data
public class Type {

    public enum TargetType {
        PHOTO,
        GEO,
        PLANE
    }

    public enum VirtualContentType {
        TEXT,

        /*2D*/
        PHOTO,
        VIDEO,

        /*3D*/
        MODEL,
        TEXTURE,
        ANIMATION,

        AUDIO
    }

}
