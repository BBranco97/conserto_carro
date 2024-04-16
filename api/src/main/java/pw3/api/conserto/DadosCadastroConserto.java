package pw3.api.conserto;

import pw3.api.mecanico.DadosMecanico;
import pw3.api.veiculo.DadosVeiculo;

public record DadosCadastroConserto (String dataEntrada, String dataSaida,
                                    DadosMecanico mecanicoResponsavel,
                                    DadosVeiculo veiculo){
}
