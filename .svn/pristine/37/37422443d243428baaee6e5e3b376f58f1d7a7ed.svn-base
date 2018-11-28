package cu.aotain.osmp.task;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * Demo class
 *
 * @author bang
 * @date 2018/08/27
 */
@Getter
@Setter
public class Student {
    private Integer id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
