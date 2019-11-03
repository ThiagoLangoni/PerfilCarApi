package br.com.perfilcar.perfil.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.perfilcar.perfil.kafka.Producer;
import br.com.perfilcar.perfil.models.Perfil;
import br.com.perfilcar.perfil.repository.PerfilRepository;

@RestController
@RequestMapping(path = "/perfil")
public class PerfilResource {

	
	private final Producer producer = null;
	
	@Autowired
	PerfilRepository perfilRepository;
	
	
	@GetMapping("/perfis")
	public List<Perfil> listaPerfis(){
		producer.send("Pedido de Lista de Perfil");
		return perfilRepository.findAll();
	}
	
	@GetMapping("/perfil/{id}")
	public Perfil listaPerfilUnico(@PathVariable(value = "id") long id){
		producer.send("Pedido de Lista de Perfil por id");
		return perfilRepository.findById(id);
	}
	
	@PostMapping("/perfil")
	public Perfil salvaPerfil(@RequestBody Perfil perfil) {
		producer.send("Pedido de criação de Perfil");
		return perfilRepository.save(perfil);
	}

	@PutMapping("/perfil")
	public Perfil atualizaPerfil(@RequestBody Perfil perfil) {
		producer.send("Pedido de atualização de Perfil");
		return perfilRepository.save(perfil);
	}

	@DeleteMapping("/perfil")
	 public void deletaPerfil(@RequestBody Perfil perfil) {
		producer.send("Pedido de deleção de Perfil");
		perfilRepository.delete(perfil);
	}

}
