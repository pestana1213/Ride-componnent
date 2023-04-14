package demo.boleiascomponnent.Boleias;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID rideOwner;
    private String cityLeft;
    private String cityArrival;
    private LocalDate dayLeft;
    private LocalDateTime hourLeft;
    private int places;
    private ArrayList<UUID> participants;

    public Ride(UUID rideOwner,
                String cityLeft,
                String cityArrival,
                LocalDate dayLeft,
                LocalDateTime hourLeft,
                int places
                ) {
        this.rideOwner = rideOwner;
        this.cityLeft = cityLeft;
        this.cityArrival = cityArrival;
        this.dayLeft = dayLeft;
        this.hourLeft = hourLeft;
        this.places = places;
        this.participants = new ArrayList<>();
    }
}
