package org.communis.asknet.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "data_value")
@Data
public class DataValue {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_open")
    private Date dateOpen;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_edit")
    private Date dateEdit;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_close")
    private Date dateClose;

    @Column
    private String card;

    @OneToMany(mappedBy = "dataValue", fetch = FetchType.LAZY)
    private List<DataFieldValue> dataFieldValueList = new ArrayList<>();
}
