package dleedev365.runnerz.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record Run(
        @Id
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive
        Integer miles,
        Location location
) {

    // manual validation
    // runs whenever a run instance gets created
    public Run{
        if(!completedOn.isAfter(startedOn)){
            throw new IllegalArgumentException("Completed On must be after Started On");
        }
    }
}
