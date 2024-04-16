package pw3.api.conserto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import pw3.api.mecanico.DadosMecanico;
import pw3.api.veiculo.DadosVeiculo;

public record DadosCadastroConserto (
        @NotBlank
        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}")
        String dataEntrada,
        @NotBlank
        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}")
        String dataSaida,
        @NotNull
        @Valid
        DadosMecanico mecanicoResponsavel,
        @NotNull
        @Valid
        DadosVeiculo veiculo){
}
