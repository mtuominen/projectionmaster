package mpt.auctionmaster.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

public class ApplicationProperties {
	
	private static final String DEFAULT_CONFIGURATION = "DefaultConfiguration";
	
	private Properties properties;
	
	private PropertyManager propertyManager;
	
	public ApplicationProperties() throws IOException, URISyntaxException {
		final String directory = getConfigurationDirectory();
		
		
		propertyManager = new DefaultPropertyManager(directory);
	}
	
	public PropertyManager getPropertyManager() throws IOException {
		return propertyManager;
	}

	private String getConfigurationDirectory() throws IOException, URISyntaxException {

		return getProperties().getProperty(DEFAULT_CONFIGURATION);
	}

	public String getProperty(String property) throws IOException, URISyntaxException {
		return getProperties().getProperty(property);
	}
	
	private Properties getProperties() throws IOException, URISyntaxException {
		if (null == properties) {
			properties = new Properties();
			final File directory = new File("./");
			final InputStream inputStream = new FileInputStream(new File(directory, "ProjectionMaster.properties"));
			try {
				properties.load(inputStream);
			} finally {
				if (null != inputStream) {
					inputStream.close();
				}
			}
		}
		
		return properties;
	}
}
