package pw3.api.mecanico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosMecanico (
        @NotBlank
        String nome,
        int anosExperiencia) {
}
