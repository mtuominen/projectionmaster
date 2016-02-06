package mpt.auctionmaster.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

/**
 * Created by UTUOMMA on 8/3/2015.
 */
public class PropertyLoadingUtil {

	public static Properties loadProperties(String path) throws URISyntaxException, IOException{
		if (!path.startsWith("/")) {
			path = "/" + path;
		}
		final Properties properties = new Properties();
		final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		final InputStream inputStream = PropertyLoadingUtil.class.getResourceAsStream("../../.." + path);
		try {
			properties.load(inputStream);
		} finally {
			if (null != inputStream) {
				inputStream.close();
			}
		}

		return properties;
	}
}
