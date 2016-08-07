package mpt.auctionmaster.projections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import mpt.auctionmaster.csv.loading.CSVPlayerLoader;

@Configuration
@ComponentScan({"mpt.auctionmaster"})
@PropertySource("classpath:ProjectionMaster.properties")
public class ProjectionMasterConfig {
	
}
