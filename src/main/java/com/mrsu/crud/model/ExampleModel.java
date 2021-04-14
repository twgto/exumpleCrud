package com.mrsu.crud.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "example_table")
public class ExampleModel extends BaseEntity{

    @Column(name = "base_column")
    private String column;
}
