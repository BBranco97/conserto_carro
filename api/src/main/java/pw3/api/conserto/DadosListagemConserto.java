package pw3.api.conserto;

import pw3.api.mecanico.Mecanico;
import pw3.api.veiculo.Veiculo;

public record DadosListagemConserto(
        Long id,
        String dataEntrada,
        String dataSaida,
        String nomeMecanico,
        String marcaVeiculo,
        String modeloVeiculo) {

        public DadosListagemConserto (Conserto conserto) {
                this(   conserto.getId(),
                        conserto.getDataEntrada(),
                        conserto.getDataSaida(),
                        conserto.getMecanicoResponsavel().getNome(),
                        conserto.getVeiculo().getMarca(),
                        conserto.getVeiculo().getModelo());
        }

}
