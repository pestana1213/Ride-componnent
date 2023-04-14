package demo.boleiascomponnent.Token;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private UUID rideId;
    @Column(nullable = false)
    private UUID userRequestId;
    private int places = 1;

    public Token(String token,
                 UUID rideId,
                 UUID userRequestId,
                 int places){
        this.token = token;
        this.rideId = rideId;
        this.userRequestId = userRequestId;
        this.places = places;
    }
}
