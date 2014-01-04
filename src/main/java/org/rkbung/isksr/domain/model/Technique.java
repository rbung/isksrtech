package org.rkbung.isksr.domain.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Technique extends BaseObject {

    private static final long serialVersionUID = -947669563148486057L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic(optional = false)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
