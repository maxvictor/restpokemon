package com.maxvictor.restpokemon.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pokemon {
    @NotNull
    private int id;
    @NotNull
    private int height;
    @NotNull
    private int weight;
    @NotBlank
    private String name;
}
