package learn.sql.jdbd;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Result<T> {
    Integer number_of_duplicates;
    List<T>  clone_list;
    List<Duplicate<T>> list_of_duplicates;

    public Result(Integer number_of_duplicates, List<T> clone_list, List<Duplicate<T>> list_of_duplicates) {
        this.number_of_duplicates = number_of_duplicates;
        this.clone_list = clone_list;
        this.list_of_duplicates = list_of_duplicates;
    }

    public Integer getNumber_of_duplicates() {
        return number_of_duplicates;
    }

    public void setNumber_of_duplicates(Integer number_of_duplicates) {
        this.number_of_duplicates = number_of_duplicates;
    }

    public List<T> getClone_list() {
        return clone_list;
    }

    public void setClone_list(List<T> clone_list) {
        this.clone_list = clone_list;
    }

    public List<Duplicate<T>> getList_of_duplicates() {
        return list_of_duplicates;
    }

    public void setList_of_duplicates(List<Duplicate<T>> list_of_duplicates) {
        this.list_of_duplicates = list_of_duplicates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result<?> result = (Result<?>) o;
        return Objects.equals(number_of_duplicates, result.number_of_duplicates) && Objects.equals(clone_list, result.clone_list) && Objects.equals(list_of_duplicates, result.list_of_duplicates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number_of_duplicates, clone_list, list_of_duplicates);
    }

    @Override
    public String toString() {
        return "Result{" +
                "number_of_duplicates=" + number_of_duplicates +
                ", clone_list=" + clone_list +
                ", list_of_duplicates=" + list_of_duplicates +
                '}';
    }
}
