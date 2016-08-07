package mpt.auctionmaster.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {
	
	private static final String DEFAULT_CONFIGURATION = "DefaultConfiguration";
	
	@Autowired
	private Environment environment;
	
	private PropertyManager propertyManager;
	
	public PropertyManager getPropertyManager() throws IOException, URISyntaxException {
		if (propertyManager != null) {
			propertyManager = new DefaultPropertyManager(getConfigurationDirectory());
		}
		return propertyManager;
	}

	private String getConfigurationDirectory() throws IOException, URISyntaxException {

		return getProperty(DEFAULT_CONFIGURATION);
	}

	public String getProperty(String property) throws IOException, URISyntaxException {
		return environment.getProperty(property);
	}
}
