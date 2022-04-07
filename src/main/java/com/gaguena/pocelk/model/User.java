package com.gaguena.pocelk.model;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;

@Getter
@Entity
@Table(name = "TB_USER")
@SequenceGenerator(name = "ENTITY_SEQ", sequenceName = "USER_SEQ", initialValue = 1, allocationSize = 1)
public class User  extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String email;

    private String password;
}
