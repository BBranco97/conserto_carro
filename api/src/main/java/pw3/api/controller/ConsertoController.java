package pw3.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pw3.api.conserto.Conserto;
import pw3.api.conserto.ConsertoRepository;
import pw3.api.conserto.DadosCadastroConserto;
import pw3.api.conserto.DadosListagemConserto;

import java.util.List;

import static java.util.Arrays.stream;

@RestController
@RequestMapping("conserto")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroConserto dados){
        repository.save(new Conserto((dados)));

    }

    @GetMapping ("listar")
    public Page<Conserto> listar(Pageable paginacao) {
        return repository.findAll(paginacao);
    }


    @GetMapping("algunsdados")
    public List<DadosListagemConserto> listarAlgunsDados() {
        return repository.findAll().stream().map(DadosListagemConserto::new).toList();

    }



}
