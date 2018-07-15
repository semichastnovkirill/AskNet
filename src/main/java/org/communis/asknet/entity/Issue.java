package org.communis.asknet.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "issues")
@Data
public class Issue {

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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "issue_fields",
            joinColumns = {@JoinColumn(name = "id_issue")},
            inverseJoinColumns = {@JoinColumn(name = "id_field")}
    )
    private List<Field> fieldList = new ArrayList<>();
}
