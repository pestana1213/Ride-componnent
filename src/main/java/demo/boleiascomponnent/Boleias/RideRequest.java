package demo.boleiascomponnent.Boleias;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class RideRequest {

    private UUID rideOwner;
    private String cityLeft;
    private String cityArrival;
    private LocalDate dayLeft;
    private LocalDateTime hourLeft;
    private int places;
}
