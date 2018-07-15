package org.communis.asknet.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "data_field_value")
@Data
public class DataFieldValue {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String value;

    @NonNull
    @JoinColumn(name = "id_data_value")
    @ManyToOne(fetch = FetchType.LAZY)
    private DataValue dataValue;
}
