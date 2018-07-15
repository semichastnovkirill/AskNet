package org.communis.asknet.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "fields")
@Data
public class Field {

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
    private String title;

    @JoinColumn(name = "id_type")
    @OneToOne
    private SupportedDataType type;

    @ManyToMany(mappedBy = "fieldList")
    private List<Issue> issueList = new ArrayList<>();

    @OneToMany(mappedBy = "dataValue", fetch = FetchType.LAZY)
    private List<DataFieldValue> dataFieldValueList = new ArrayList<>();
}
