package by.rabota.vjt.dao.impl;

import by.rabota.vjt.bean.FileData;
import by.rabota.vjt.dao.DaoException;
import by.rabota.vjt.dao.FilesDao;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilesDaoImpl implements FilesDao {
    @Override
    public void readFromFile(FileData data, File file) throws DaoException {
        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bf.readLine()) != null){
                data.add(Arrays.stream(line.split("\t")).collect(Collectors.toList()));
            }
        } catch (IOException ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public void writeToFile(FileData data, File file) throws DaoException {
        try (FileWriter writer = new FileWriter(file, false)) {
            for (List<String> lines : data.getData()) {
                for (String element : lines) {
                    writer.write(element);
                    writer.write("\t");
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            throw new DaoException(e);
        }
    }
}
