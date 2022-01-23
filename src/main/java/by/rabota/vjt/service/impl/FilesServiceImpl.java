package by.rabota.vjt.service.impl;

import by.rabota.vjt.bean.FileData;
import by.rabota.vjt.dao.DaoException;
import by.rabota.vjt.dao.DaoFactory;
import by.rabota.vjt.dao.FilesDao;
import by.rabota.vjt.service.FilesService;
import by.rabota.vjt.service.ServiceException;

import java.io.File;

public class FilesServiceImpl implements FilesService {
    @Override
    public void readFromFile(FileData data, File file) throws ServiceException {
        if (file == null || !file.exists()) {
            throw new ServiceException("File doesn't exist");
        }
        if(data == null){
            throw new ServiceException("FileData object doesn't exist");
        }
        if (!data.getData().isEmpty()) {
            data.clear();
        }
        FilesDao filesDao = DaoFactory.getInstance().getFilesDao();
        try {
            filesDao.readFromFile(data, file);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void writeToFile(FileData data, File file) throws ServiceException {
        if (data == null || data.getData().isEmpty()) {
            throw new ServiceException("Data wasn't be sorted");
        }
        if (file == null) {
            throw new ServiceException("Unknown file for save data");
        }
        FilesDao filesDao = DaoFactory.getInstance().getFilesDao();
        try {
            filesDao.writeToFile(data, file);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
