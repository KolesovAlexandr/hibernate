package entities;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by Aleksandr_Kolesov on 10/14/2016.
 */
@Entity
@Table(name = "student")
public class Student implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "group_name", nullable = false, length = 10)
    private String group;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Stipend stipend;

    public Student() {
    }

    public Student(String name, String group, Stipend stipend) {
        this.name = name;
        this.group = group;
        this.stipend = stipend;
    }

    public Student(Integer id, String name, String group, Stipend stipend) {
        this(name, group, stipend);
        this.id = id;
    }

    public Student(String name, String group) {


        this.name = name;
        this.group = group;
    }

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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Stipend getStipend() {
        return stipend;
    }

    public void setStipend(Stipend stipend) {
        stipend.setStudent(this);

        this.stipend = stipend;
    }

    @Override
    public String toString() {
        return "id: " + id + " name: " + name
                + " group: " + group + " stipend: " + stipend;
    }
}
