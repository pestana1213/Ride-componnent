package demo.boleiascomponnent.Token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TokenService {

    private final TokenRepository tokenRepository;

    public void saveToken(Token token){
        tokenRepository.save(token);
    }

    public Optional<Token> getToken(String token){
        return tokenRepository.findByToken(token);
    }

    public void delete(Token token){
        tokenRepository.deleteById(token.getId());
    }

    public Token getTokenFromARide(UUID rideId){
        return tokenRepository.findByRideId(rideId).orElseThrow( () ->
                new IllegalArgumentException("Nao ha nenhum token associado a esta boleia (ainda ninguem fez o pedido para participar na boleia)"));
    }
}
