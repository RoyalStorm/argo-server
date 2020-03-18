package com.arrayteam.argo.server.dao.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Table(name = "Targets")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Target {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Target's unique id", example = "7")
    private Long id;

    @ApiModelProperty(value = "Target's type")
    private String type;

    @CreationTimestamp
    @ApiModelProperty(value = "Create date")
    private Date createdAt;

    @UpdateTimestamp
    @ApiModelProperty(value = "Update date")
    private Date updatedAt;

    @OneToMany(mappedBy = "target", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ImageTarget> imageTargets = new ArrayList<>();

}
