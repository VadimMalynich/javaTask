package by.rabota.vjt.dao;

import by.rabota.vjt.dao.impl.FilesDaoImpl;

public class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();

    private final FilesDao filesDao = new FilesDaoImpl();

    public static DaoFactory getInstance(){
        return instance;
    }

    public FilesDao getFilesDao() {
        return filesDao;
    }
}
