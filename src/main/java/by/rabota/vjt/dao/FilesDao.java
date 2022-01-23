package by.rabota.vjt.dao;

import by.rabota.vjt.bean.FileData;

import java.io.File;

public interface FilesDao {
    /**
     * Method for read data from file
     *
     * @param data object of {@code FileData} that will be fill in
     * @param file file from which will take data
     * @throws DaoException if there are errors when reading the information from file
     */
    void readFromFile(FileData data, File file) throws DaoException;

    /**
     * Method for write data to file
     * @param data object of {@code FileData} that will be written in file
     * @param file file in which will write {@code data}
     * @throws DaoException if there are errors when writing information to the file
     */
    void writeToFile(FileData data, File file) throws DaoException;
}
