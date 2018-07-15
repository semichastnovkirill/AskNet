package org.communis.asknet.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rules")
@Data
public class Rule {

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

}
