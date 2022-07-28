package com.gozdesy.log;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggingExample {

	// Logger nesnesi yaratıyoruz
    static Logger logger = Logger.getLogger(LoggingExample.class.getName());
    
    public static void main(String[] args) {
    	
        try {
        	//özelliklerini ayarladığımı properties dosyasını tanıtıyoruz
            LogManager.getLogManager().readConfiguration(new FileInputStream("mylogging.properties"));
            
        } catch (SecurityException | IOException e1) {
            e1.printStackTrace();
        }
        
        logger.setLevel(Level.FINE); //7 tane normal level var
        logger.addHandler(new ConsoleHandler());
        //MyHandler classını tanıtarak kendi oluşturduğumuz handleri ekliyoruz
        logger.addHandler(new MyHandler());
        
        try {
        	
            //fileHandler dosya adı ile loglama yapacağımız yolu, 
        	//günlük kaç tane log mesajı oluşturacağımızı ve dışarıya export edilecek log dosya sayısını tanımlıyoruz.
            Handler fileHandler = new FileHandler("//Users/gozde/Desktop/Coding/01-BilgeAdam_Boost/Logging_Presentation/Log", 1000, 5);
            
            //formatlama biçimimizi tanıtıyoruz
            fileHandler.setFormatter(new MyFormatter()); 
            
            //fileHandler için kişiselleştirilmiş bir filtre ekleniyor
            fileHandler.setFilter(new MyFilter());
            logger.addHandler(fileHandler);
            
            for(int i=0; i<1000; i++){
            	
                //logging messages
                logger.log(Level.INFO, "Msg"+i);
            }
            logger.log(Level.CONFIG, "Config data");
            
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
    }

}