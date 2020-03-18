package com.arrayteam.argo.server.dao.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Table(name = "VirtualContents3D")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class VirtualContent3D {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "3D Virtual content's unique id", example = "7")
    private Long id;

    @Lob
    private byte[] data;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "virtual_content_id")
    @JsonIgnore
    private VirtualContent virtualContent;

}
