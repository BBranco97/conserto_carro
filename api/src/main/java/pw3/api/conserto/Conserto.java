package pw3.api.conserto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pw3.api.mecanico.Mecanico;
import pw3.api.veiculo.Veiculo;


@Table(name = "conserto")
@Entity(name = "Conserto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dataEntrada;
    private String dataSaida;
    @Embedded
    private Mecanico mecanicoResponsavel;
    @Embedded
    private Veiculo veiculo;
    private Boolean ativo;

    public Conserto(DadosCadastroConserto dados) {
        this.dataEntrada = dados.dataEntrada();
        this.dataSaida = dados.dataSaida();
        this.mecanicoResponsavel = new Mecanico(dados.mecanicoResponsavel());
        this.veiculo = new Veiculo((dados.veiculo()));
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizacaoConserto dados) {
        if (dados.dataSaida() != null) {
            this.dataSaida = dados.dataSaida();
        }
        if (dados.mecanico() != null) {
            this.mecanicoResponsavel.atualizarInformacoes(dados.mecanico());
            //this.telefone = dados.nomeMecanico();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}