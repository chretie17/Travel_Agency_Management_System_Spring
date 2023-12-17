package TravelAgency.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // Set your DataSource properties (URL, username, password, etc.)
        dataSource.setUrl("jdbc:mysql://localhost:3306/tour");
        dataSource.setUsername("root");
        dataSource.setPassword("Admin@123");
        return dataSource;
    }
}
