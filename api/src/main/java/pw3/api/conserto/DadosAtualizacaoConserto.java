package pw3.api.conserto;

import jakarta.validation.constraints.NotNull;
import pw3.api.mecanico.DadosMecanico;

public record DadosAtualizacaoConserto(
        @NotNull
        Long id,
        String dataSaida,
        DadosMecanico mecanico) {
    public static record DadosDetalhamentoConserto(Conserto conserto) {
    }
}
