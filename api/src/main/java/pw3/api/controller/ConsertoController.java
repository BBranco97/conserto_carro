package pw3.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pw3.api.conserto.*;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.stream;

@RestController
@RequestMapping("conserto")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroConserto dados, UriComponentsBuilder uriBuilder){
        var conserto = new Conserto(dados);
        repository.save(conserto);
        var uri = uriBuilder.path("/conserto/{id}").buildAndExpand(conserto.getId()).toUri();
        return ResponseEntity.created(uri).body( new DadosDetalhamentoConserto(conserto));
    }

    @GetMapping("listar")
    public ResponseEntity listar(Pageable paginacao) {
        Page<Conserto> consertos = repository.findAll(paginacao);
        Page<DadosListagemConserto> dadosListagemConserto = consertos.map(DadosListagemConserto::new);
        return ResponseEntity.ok(dadosListagemConserto);
    }


    @GetMapping("algunsdados")
    public ResponseEntity listarAlgunsDados( Pageable paginacao ) {

        Page p = repository.findAllByAtivoTrue(paginacao).map(DadosListagemConserto::new);
        return ResponseEntity.ok(p);
    }


    @GetMapping("/{id}")
    public ResponseEntity getConsertoById(@PathVariable Long id) {
        Optional<Conserto> consertoOptional = repository.findById(id);
        if (consertoOptional.isPresent()) {
            Conserto conserto = consertoOptional.get();
            return ResponseEntity.ok(new DadosDetalhamentoConserto(conserto));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoConserto dados) {
        Conserto conserto = repository.getReferenceById( dados.id() );
        conserto.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoConserto(conserto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        Conserto conserto = repository.getReferenceById(id);
        conserto.excluir();
        return ResponseEntity.noContent().build();
    }

}
