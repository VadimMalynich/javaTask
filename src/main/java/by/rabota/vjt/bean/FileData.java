package by.rabota.vjt.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileData {
    private List<List<String>> data;

    public FileData() {
        data = new ArrayList<>();
    }

    public List<List<String>> getData() {
        return data;
    }

    public List<String> get(int index) {
        return data.get(index);
    }

    public void add(List<String> strings) {
        data.add(strings);
    }

    public void clear() {
        data.clear();
    }

    public int size() {
        return data.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileData fileData = (FileData) o;
        return Objects.equals(data, fileData.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return "FileData{" +
                "data=" + data +
                '}';
    }
}
