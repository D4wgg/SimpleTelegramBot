package ru.dawgg.simpletelegrambot.response;

import com.ritaja.xchangerate.api.CurrencyConverter;
import com.ritaja.xchangerate.util.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DollarToRubConverter implements BotResponse {

    private final Commands convert = Commands.DOLLAR;
    private final CurrencyConverter converter;

    @Override
    public String reply() {
        try {
            return String.valueOf(converter.convertCurrency(new BigDecimal(1), Currency.USD, Currency.RUB));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Unfortunately, converter could not make it";
    }

    @Override
    public Commands getCommand() {
        return convert;
    }
}
