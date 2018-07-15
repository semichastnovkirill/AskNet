package org.communis.asknet.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "supported_view_cfg")
@Data
public class SupportedViewCfg {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String code;

    @Column
    private String title;

    @Column
    private String desc;

    @Column
    private Boolean required;

    @NonNull
    @JoinColumn(name = "id_data_type")
    @OneToOne
    private SupportedDataType dataType;

    @NonNull
    @JoinColumn(name = "id_view")
    @OneToOne
    private SupportedView view;
}
