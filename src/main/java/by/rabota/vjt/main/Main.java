package by.rabota.vjt.main;

import by.rabota.vjt.bean.FileData;
import by.rabota.vjt.service.FilesService;
import by.rabota.vjt.service.ServiceException;
import by.rabota.vjt.service.ServiceFactory;
import by.rabota.vjt.service.SortingDataService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        File file = new File("src/by.rabota.vjt.main/resources/in.txt");
        FileData data = new FileData();
        FilesService filesService = ServiceFactory.getInstance().getFilesService();
        SortingDataService sortingDataService = ServiceFactory.getInstance().getSortingDataService();
        try {
            filesService.readFromFile(data, file);
            sortingDataService.sortData(data);
            filesService.writeToFile(data, new File("src/by.rabota.vjt.main/resources/out.txt"));
        } catch (ServiceException e) {
            logger.info(e);
        }
    }
}
