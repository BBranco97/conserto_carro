package pw3.api.usuario;

import jakarta.validation.constraints.NotNull;

public record DadosAutentificacao(

        @NotNull
        String login,


        @NotNull
        String senha) {

}
