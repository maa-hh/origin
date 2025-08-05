package com.example.demo.DuraAndData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

//@Component
@ConfigurationProperties(prefix = "my")
@Validated
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DuraAndData {
    @DurationUnit(ChronoUnit.MINUTES)
    @Min(value = 0,message = "最小0")
    private Duration dura;
    @Max(value = 10000,message = "最大10000B")
    @DataSizeUnit(DataUnit.BYTES)
    private DataSize data;
   /* @NotNull
    @NotBlank
    @NotEmpty
    @Length(min=1,max=10)
    @Size(min=1,max = 2)
    @Email(message = "Invalid email address")
    @Pattern(regexp = "[a-zA-Z0-9]+", message = "Only alphanumeric characters are allowed")
    @Past(message = "Date must be in the past")
    @Future(message = "Date must be in the future")*/

}
