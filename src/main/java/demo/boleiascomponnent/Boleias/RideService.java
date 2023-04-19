package demo.boleiascomponnent.Boleias;

import demo.boleiascomponnent.Token.Token;
import demo.boleiascomponnent.Token.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RideService {

    private final RideRepository rideRepository;
    private final TokenService tokenService;

    public void createRide(RideRequest request){
        if(request.getDayLeft().isBefore(LocalDate.now())){
            throw new IllegalStateException("You can not create a ride for the past");
        }
        rideRepository.save(new Ride(request.getRideOwner(),
                request.getCityLeft(),
                request.getCityArrival(),
                request.getDayLeft(),
                request.getHourLeft(),
                request.getPlaces()));
    }

    public void requestRide(int places, UUID rideId, UUID userId){

        Ride ride = rideRepository.findById(rideId).orElseThrow(
                () -> new IllegalStateException("Boleia nao existe")
        );

        if(ride.getDayLeft().isBefore(LocalDate.now()) || places > ride.getPlaces()){
            throw new IllegalStateException("Nao podes marcar uma boleia no passado, ou entao nao ha tantos lugares disponiveis");
        }

        String tk = UUID.randomUUID().toString();
        Token token = new Token(tk,
                rideId,
                userId,
                places);
        tokenService.saveToken(token);
    }

    public void confirmRequestRide(String token){

        Token tk = tokenService.getToken(token).orElseThrow(
                () -> new IllegalStateException("Token not found")
        );
        Ride ride = rideRepository.findById(tk.getRideId()).orElseThrow(
                () -> new IllegalStateException("Boleia nao existe")
        );

        if(ride.getDayLeft().isBefore(LocalDate.now()) || tk.getPlaces() > ride.getPlaces()){
            throw new IllegalStateException("Nao podes aceitar uma boleia no passado, ou entao nao ha tantos lugares disponiveis");
        }

        ride.getParticipants().add(tk.getUserRequestId());
        ride.setPlaces(ride.getPlaces()-tk.getPlaces());
        rideRepository.save(ride);
    }
}
