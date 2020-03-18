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
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "User's unique id", example = "7")
    private Long id;

    @ApiModelProperty(value = "User's name")
    private String name;

    @CreationTimestamp
    @ApiModelProperty(value = "Create date")
    private Date createdAt;

    @UpdateTimestamp
    @ApiModelProperty(value = "Update date")
    private Date updatedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ARC> arcs = new ArrayList<>();

}
