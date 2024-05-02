package pw3.api.conserto;

import pw3.api.mecanico.Mecanico;
import pw3.api.veiculo.Veiculo;

public record DadosDetalhamentoConserto (
        Long id,
        String dataEntrada,
        String dataSaida,
        Mecanico mecanicoResponsavel,
        Veiculo veiculo,
        Boolean ativo){
    public DadosDetalhamentoConserto (Conserto conserto) {
        this(   conserto.getId(),
                conserto.getDataEntrada(),
                conserto.getDataSaida(),
                conserto.getMecanicoResponsavel(),
                conserto.getVeiculo(),
                conserto.getAtivo());
    }
}
