package org.rkbung.isksr.domain.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TECHNIQUE")
public class Technique extends BaseObject {

    private static final long serialVersionUID = -947669563148486057L;

    @Id
    @GeneratedValue
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
