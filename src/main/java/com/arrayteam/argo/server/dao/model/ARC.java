package com.arrayteam.argo.server.dao.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ARC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "ARC's unique id", example = "7")
    private Long id;
    @ApiModelProperty(value = "Augmented reality content name")
    private String name;
    @ApiModelProperty(value = "Augmented reality content description")
    private String description;
    @ApiModelProperty(value = "Views number")
    private String views;
    @ApiModelProperty(value = "Augmented reality content rate")
    private String rate;
    @CreationTimestamp
    @ApiModelProperty(value = "Create date")
    private Date createdAt;
    @UpdateTimestamp
    @ApiModelProperty(value = "Update date")
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "target_id")
    @JsonIgnore
    private Target target;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "virtual_content_id")
    @JsonIgnore
    private VirtualContent virtualContent;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

}
