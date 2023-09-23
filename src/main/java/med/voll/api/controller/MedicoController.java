package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }

    @GetMapping
    public List<DadosListagemMedico> listar(){
        return repository.findAll().stream().map(DadosListagemMedico::new).toList();
    }
/*Não vamos retornar uma List<Medico>, pois ele vai retornar todos os atributos e nossa REGRA de negocio quer somente
* alguns atributos listados, então vamos criar um DTO para retornar os dados corretos, mas precisamos converter Medico
* para o nosso DTO DadosListagemMedico, criando um construtor no DTO que recebe MEdico como parametro.*/
    /*Meu map que vai fazer a conversão de Médico para DadosListagemMedico, map(DadosListagemMedico::new) passando
    * e chamando o construtor no nosso DTO(criar um construtor que recebe do tipo médico)*/
}
