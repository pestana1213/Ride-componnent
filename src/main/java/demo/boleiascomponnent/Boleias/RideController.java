package demo.boleiascomponnent.Boleias;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/ride")
public class RideController {

    private final RideService rideService;

    @PutMapping
    public void createRide(@RequestBody RideRequest request){
        rideService.createRide(request);
    }

    @PutMapping("/request")
    public void requestRide(@RequestParam int places,
                            @RequestParam String rideId,
                            @RequestParam String userId
                            ){
        rideService.requestRide(places, UUID.fromString(rideId),
                UUID.fromString(userId));
    }

    @PatchMapping("/confirm")
    public void confirmRide(String token){
        rideService.confirmRequestRide(token);
    }

}
