package pl.sda.spring.security.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String password;

    public UserDto(Long id, String username) {
        this.id = id;
        this.username = username;
    }
}
