package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.endereco.Endereco;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    /*nosso método cadastrar recebe DadosCadastroMedico como parametro, que é onde estão os dados, que é um DTO RECORD
    * Então lá que vamos fazer o bean validation*/
    /*Usamos a anotação @VALID aqui tbm, para pedir par ao Spring integrar com o BEAN VALIDTION
    validar o DadosCadastroMedico que é um DTO e como dentro dele vai ter outro DTO DadosEndereco, ele vai validar em
    cascata*/

}
