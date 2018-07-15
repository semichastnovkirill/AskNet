package org.communis.asknet.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "supported_data_type")
@Data
public class SupportedDataType {

    @Id
    private String id;

    @Column
    private String name;

}
