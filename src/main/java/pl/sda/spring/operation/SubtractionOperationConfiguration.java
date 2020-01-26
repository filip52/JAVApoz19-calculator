package pl.sda.spring.operation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SubtractionOperationConfiguration {

    @Bean
    SubtractionOperation subtractionOperation() {
        return new SubtractionOperation();
    }

    @Bean
    DivisionOperation divisionOperation(){return new DivisionOperation("NieWolno przez 0");}
}
