package by.rabota.vjt.service.impl;

import by.rabota.vjt.service.DataComparator;
import by.rabota.vjt.bean.FileData;
import by.rabota.vjt.service.ServiceException;
import by.rabota.vjt.service.SortingDataService;

public class SortingDataServiceImpl implements SortingDataService {
    @Override
    public void sortData(FileData data) throws ServiceException {
        if (data == null || data.getData().isEmpty()) {
            throw new ServiceException("There is no data for sorting");
        }
        data.getData().sort(new DataComparator());
    }
}
