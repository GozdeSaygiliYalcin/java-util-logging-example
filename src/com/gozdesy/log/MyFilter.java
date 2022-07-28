package com.gozdesy.log;

import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class MyFilter implements Filter {

	@Override
	public boolean isLoggable(LogRecord log) {
		//config dosyalarını log file içine kaydetmemesi için filtre oluştıuruyoruz
		//başka filtreler de oluşturabiliriz
		if(log.getLevel() == Level.CONFIG) return false;
		return true;
	}

}
