package br.com.perfilcar.perfil.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import br.com.perfilcar.perfil.kafka.Producer;
import br.com.perfilcar.perfil.models.Perfil;
import br.com.perfilcar.perfil.repository.PerfilRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/perfil")
@Api(value = "API REST Perfis")
@CrossOrigin(origins="*")
public class PerfilResource {

	
	//private final Producer producer = null;
	
	@Autowired
	PerfilRepository perfilRepository;
	
	
	@GetMapping("/perfis")
	@ApiOperation(value="Retorna uma lista de perfis")
	public List<Perfil> listaPerfis(){
		//producer.send("Pedido de Lista de Perfil");
		return perfilRepository.findAll();
	}
	
	@GetMapping("/perfis/{emailProprietario}")
	@ApiOperation(value="Retorna uma lista de perfis do e-mail especificado")
	public List<Perfil> listaPerfisPorEmail(@PathVariable(value = "emailProprietario") String emailProprietario){
		//producer.send("Pedido de Lista de Perfil por e-mail");
		return perfilRepository.findByEmailProprietario(emailProprietario);
	}
	
	@GetMapping("/perfil/{id}")
	@ApiOperation(value="Retorna um perfil unico do Id especificado")
	public Perfil listaPerfilUnico(@PathVariable(value = "id") long id){
		//producer.send("Pedido de Lista de Perfil por id");
		return perfilRepository.findById(id);
	}
	
	@PostMapping("/perfil")
	@ApiOperation(value="Cria um perpil com os dados informados")
	public Perfil salvaPerfil(@RequestBody Perfil perfil) {
		//producer.send("Pedido de criação de Perfil");
		return perfilRepository.save(perfil);
	}

	@PutMapping("/perfil")
	@ApiOperation(value="Atualiza um perfil com os dados informados")
	public Perfil atualizaPerfil(@RequestBody Perfil perfil) {
		//producer.send("Pedido de atualização de Perfil");
		return perfilRepository.save(perfil);
	}

	@DeleteMapping("/perfil")
	@ApiOperation(value="Deleta o perfil Informado")
	 public void deletaPerfil(@RequestBody Perfil perfil) {
		//producer.send("Pedido de deleção de Perfil");
		perfilRepository.delete(perfil);
	}

}
