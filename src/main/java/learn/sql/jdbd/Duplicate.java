package learn.sql.jdbd;

import java.util.Objects;

public class Duplicate<T> {
    Integer first_index;
    Integer second_index;

    public Duplicate(Integer first_index, Integer second_index) {
        this.first_index = first_index;
        this.second_index = second_index;
    }

    public Integer getFirst_index() {
        return first_index;
    }

    public void setFirst_index(Integer first_index) {
        this.first_index = first_index;
    }

    public Integer getSecond_index() {
        return second_index;
    }

    public void setSecond_index(Integer second_index) {
        this.second_index = second_index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Duplicate<?> duplicate = (Duplicate<?>) o;
        return Objects.equals(first_index, duplicate.first_index) && Objects.equals(second_index, duplicate.second_index);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first_index, second_index);
    }

    @Override
    public String toString() {
        return "Duplicate{" +
                "first_index=" + first_index +
                ", second_index=" + second_index +
                '}';
    }
}
