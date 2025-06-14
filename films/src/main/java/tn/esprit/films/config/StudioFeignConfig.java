
package tn.esprit.films.config;

import feign.Logger;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class StudioFeignConfig {

    /** Active un log BASIC pour voir les requêtes Feign dans les logs */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new ErrorDecoder.Default(); // plus tard, tu pourras customiser
    }
}
