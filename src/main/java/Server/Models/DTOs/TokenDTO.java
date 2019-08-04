package Server.Models.DTOs;

import Server.Models.Entities.Token;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenDTO {
    private String value;

    public static TokenDTO from(Token token){
        return new TokenDTO(token.getValue());
    }
}
