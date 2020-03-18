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
@Table(name = "ARCs")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ARC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "ARC's unique id", example = "7")
    private Long id;

    @CreationTimestamp
    @ApiModelProperty(value = "Create date")
    private Date createdAt;

    @UpdateTimestamp
    @ApiModelProperty(value = "Update date")
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

}
