package com.hoang.multiThreadring.publisher.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Config")
@Table(name = "Config")
public class ConfigEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "source")
    private String source;
}
