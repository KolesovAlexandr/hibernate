package entities;

import javax.persistence.*;

/**
 * Created by Aleksandr_Kolesov on 10/14/2016.
 */
@Entity
@Table(name = "stipend")
public class Stipend {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "value")
    private Integer value;

    @OneToOne
    @JoinColumn(name = "student_id")
    Student student;

    public Stipend(int value) {
        this.value = value;
    }

    public Stipend() {
    }

    ;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer student_id) {
        this.id = student_id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
