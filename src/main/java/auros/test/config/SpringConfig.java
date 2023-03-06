package auros.test.config;

import auros.test.dao.KnowledgePackageDAO;
import auros.test.dao.KnowledgePackageDAOImpl;
import auros.test.dao.KnowledgePackageSetDAO;
import auros.test.dao.KnowledgePackageSetDAOImpl;
import auros.test.models.KnowledgePackageSet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "auros.test")
public class SpringConfig {

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/testtask?useSSL=false&&serverTimezone=Europe/Kiev");
        ds.setUsername("root");
        ds.setPassword("rootroot");
        return ds;
    }

    @Bean
    public KnowledgePackageDAO getKnowledgePackageDao() {
        return new KnowledgePackageDAOImpl(getJdbcTemplate());
    }

    @Bean
    public KnowledgePackageSetDAO getKnowledgePackageSetDao() {
        return new KnowledgePackageSetDAOImpl(getJdbcTemplate());
    }

}
