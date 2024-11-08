package dev.imsanjaypaul.runnerz.run;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(
        @Max(100) Integer id,
        @NotEmpty String msg,
        LocalDateTime StartedOn,
        LocalDateTime FinishedOn,
        @Positive
        Integer miles,
        Location location
) {
    public Run {
        if(StartedOn.isAfter(FinishedOn)) {
            throw new IllegalArgumentException("Started on cannot be after Finished on");
        }
    }
}
