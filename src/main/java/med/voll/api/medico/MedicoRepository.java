package med.voll.api.medico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {/*Devido isso aqui, que o nossos métodos JPA
vai sempre receber um Medico, pois foi declarado aqui*/
}
