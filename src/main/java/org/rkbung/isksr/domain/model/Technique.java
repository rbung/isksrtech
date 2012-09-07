package org.rkbung.isksr.domain.model;

import javax.persistence.*;

@Table(name = "TECHNIQUE")
public class Technique extends BaseObject {

    private static final long serialVersionUID = -947669563148486057L;

    @Id
    @GeneratedValue
    private int id;

    @Basic(optional = false)
    private String name;
}
