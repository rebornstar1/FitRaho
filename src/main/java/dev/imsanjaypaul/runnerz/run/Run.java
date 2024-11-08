package dev.imsanjaypaul.runnerz.run;

import java.time.LocalDateTime;

public record Run(
        Integer id,
        String msg,
        LocalDateTime StartedOn,
        LocalDateTime FinishedOn,
        Integer miles,
        Location location
) {
}
