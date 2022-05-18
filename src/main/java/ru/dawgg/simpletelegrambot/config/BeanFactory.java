package ru.dawgg.simpletelegrambot.config;

import com.github.prominence.openweathermap.api.OpenWeatherMapClient;
import com.ritaja.xchangerate.api.CurrencyConverter;
import com.ritaja.xchangerate.api.CurrencyConverterBuilder;
import com.ritaja.xchangerate.util.Strategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanFactory {

    @Bean
    public OpenWeatherMapClient openWeatherMapClient() {
        return new OpenWeatherMapClient("fcd83518f8dc705e564d05eaac57cb8d");
    }

    @Bean
    public CurrencyConverter currencyConverter() {
        CurrencyConverter currencyConverter = new CurrencyConverterBuilder()
                .strategy(Strategy.CURRENCY_LAYER_FILESTORE)
                .accessKey("9ea3fb1a25bc0647d6c219a46f61fe06")
                .buildConverter();
        return currencyConverter;
    }
}
