package by.rabota.vjt.service;

import by.rabota.vjt.service.impl.FilesServiceImpl;
import by.rabota.vjt.service.impl.SortingDataServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final FilesService filesService = new FilesServiceImpl();
    private final SortingDataService sortingDataService = new SortingDataServiceImpl();

    public static ServiceFactory getInstance() {
        return instance;
    }

    public FilesService getFilesService() {
        return filesService;
    }

    public SortingDataService getSortingDataService() {
        return sortingDataService;
    }
}
