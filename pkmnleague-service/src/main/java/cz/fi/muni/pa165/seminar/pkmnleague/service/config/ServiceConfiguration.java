package cz.fi.muni.pa165.seminar.pkmnleague.service.config;

import cz.fi.muni.pa165.seminar.pkmnleague.utils.EmbeddedDerbyDatabase;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Pavel Kouřil <pk@pavelkouril.cz>
 */
@Configuration
@Import(EmbeddedDerbyDatabase.class)
@ComponentScan(basePackages = "cz.fi.muni.pa165.seminar.pkmnleague.service")
public class ServiceConfiguration {
    @Bean
    public Mapper dozer(){
        DozerBeanMapper dozer = new DozerBeanMapper();
        //dozer.addMapping(new DozerCustomConfig());
        return dozer;
    }
}
