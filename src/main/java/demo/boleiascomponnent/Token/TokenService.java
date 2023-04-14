package demo.boleiascomponnent.Token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
}
