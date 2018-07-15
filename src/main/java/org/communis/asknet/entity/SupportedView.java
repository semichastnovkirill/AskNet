package org.communis.asknet.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "supported_view")
@Data
public class SupportedView {

    @Id
    private String id;

    @Column
    private String name;

    @Column
    private String grouping;

    @Column(name = "default_use")
    private Boolean defaultUse;
}
