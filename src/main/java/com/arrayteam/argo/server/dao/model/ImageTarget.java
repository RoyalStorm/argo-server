package com.arrayteam.argo.server.dao.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Table(name = "ImageTargets")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ImageTarget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Image's unique id", example = "7")
    private Long id;

    @Lob
    private byte[] data;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "target_id")
    @JsonIgnore
    private Target target;

}
