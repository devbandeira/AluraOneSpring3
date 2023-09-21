package med.voll.api.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//Para o Spring reconhecer essa classe. Agora ele vai inicializar essa classe quando carregar o projeto
@RequestMapping("medicos")//Está mapeando a URI /medicos
public class MedicoController {

    @PostMapping//Dizendo qual o tipo do verbo, deste método
    public void cadastrar(@RequestBody String json){//@RequestBody para ele pegar do corpo da requisiçãoo, se não ele retorna null
        /*
        * Pra não ter que fazer parser na string.
        * Para receber os campos de maneira separada, não posso receber como string.
        * Para isso devo criar uma classe e dentro dela criar os atributos iguais do JSON
        */
        System.out.println(json);
    }

}
