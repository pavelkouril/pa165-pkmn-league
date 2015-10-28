package cz.fi.muni.pa165.seminar.pkmnleague.utils;

import java.sql.SQLException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Runner for our application.
 *
 * @author Dominik Hanak @domhanak
 */
@SpringBootApplication
@ImportResource("classpath:/app-Context.xml")
public class PokemonLeagueRunner {
    public static void main(String[] args) throws SQLException {
        SpringApplication.run(PokemonLeagueRunner.class, args);
    }
}
