package by.rabota.vjt.service;

import by.rabota.vjt.bean.FileData;

import java.io.File;

public interface FilesService {
    /**
     * Method for checking is a file existing and clearing {@code FileData} if {@code data} not empty
     * @param data object of {@code FileData} that will be fill in
     * @param file file from which will take data
     * @throws ServiceException if file doesn't exist {@code data} is empty or {@code null}
     */
    void readFromFile(FileData data, File file) throws ServiceException;

    /**
     * Method for checking the filling of an object {@code FileData}
     * @param data sorted object of {@code FileData}
     * @param file file in which will write {@code data}
     * @throws ServiceException if there are no info about file or {@code data} is empty or {@code null}
     */
    void writeToFile(FileData data, File file) throws ServiceException;
}
