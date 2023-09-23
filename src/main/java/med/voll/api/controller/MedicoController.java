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
    public List<DadosListagemMedico> listar(){/*Se eu retornar um Medico, é um problema grande, como outros problemas por se trabalhar
    com entidade JPA. Nesse caso ele vai retornar todas as informações de médico, mas na nossa regra de negocio, queremos
    somente algumas informações, então vou gerar um novo DTO para isso, onde vamos devolver dados da API.
    Antes era<Medico> agora vai ser <DadosListagemMedico>*/
        return repository.findAll().stream().map(DadosListagemMedico::new).toList();/*findAll retorna o tipo MEDICO, a entidade JPA. Então da erro,Entao vamos ter que converter
        de MEDICO para DadosListagemMedico, usando o -> .stream().map(DadosListagemMedico::new)
        Dessa forma (DadosListagemMedico::new) chamo o construtor do nosso DTO, mas vai reclamar, pq dentro do DadosListagemMedico
        não tem um construtor que recebe um objeto do tipo MEDICO, então precisamos criar esse construtor no DTO record.

.toList() No final uso essa função para transformar para uma lista
        */
    }

}
