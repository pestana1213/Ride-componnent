package demo.boleiascomponnent.Boleias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RideRepository extends JpaRepository<Ride, UUID> {

    @Modifying
    @Query("update Ride u set u.places = ?1, u.participants = ?2 where u.id = ?3")
    void update(int places, ArrayList<UUID> participants, Integer userId);

    ArrayList<Ride> findAllRidesByOwnerId(UUID ownerId);
}
