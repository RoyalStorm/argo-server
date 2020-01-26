package com.arrayteam.argo.server.dao.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
public class Target {

    private Long id;
    private String name;
    private Date createdAt;
    private Date updatedAt;

}
