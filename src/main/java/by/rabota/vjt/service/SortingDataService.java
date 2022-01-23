package by.rabota.vjt.service;

import by.rabota.vjt.bean.FileData;

public interface SortingDataService {
    /**
     * Method for sort data by
     * @param data data from file
     * @throws ServiceException if {@code data} is empty
     */
    void sortData(FileData data) throws ServiceException;
}
