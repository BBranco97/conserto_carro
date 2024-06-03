package pw3.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pw3.api.usuario.DadosAutentificacao;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager; // Objeto AuthenticationManager,
    // que será injetado aqui:
    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutentificacao dados) {
        var token = new UsernamePasswordAuthenticationToken( dados.login(), dados.senha() );
        var authentication = manager.authenticate(token);
        return ResponseEntity.ok().build();
    }
}