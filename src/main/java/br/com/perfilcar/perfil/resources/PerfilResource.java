package br.com.perfilcar.perfil.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.perfilcar.perfil.models.Perfil;
import br.com.perfilcar.perfil.repository.PerfilRepository;

@RestController
@RequestMapping(path = "/perfil")
public class PerfilResource {

	@Autowired
	PerfilRepository perfilRepository;
	
	
	@GetMapping("/perfis")
	public List<Perfil> listaPerfis(){
		return perfilRepository.findAll();
	}
	
	@GetMapping("/perfil/{id}")
	public Perfil listaPerfilUnico(@PathVariable(value = "id") long id){
		return perfilRepository.findById(id);
	}
	
	@PostMapping("/perfil")
	public Perfil salvaPerfil(@RequestBody Perfil perfil) {
		return perfilRepository.save(perfil);
	}
	
	@PostMapping("/perfil")
	public Perfil atualizaPerfil(@RequestBody Perfil perfil) {
		return perfilRepository.save(perfil);
	}
	
	@DeleteMapping("/perfil")
	public void Perfil deletaPerfil=Perfil(@RequestBody Perfil perfil) {
		perfilRepository.save(perfil);
	}
		
/*	@DeleteMapping("/Perfil")
	public void Perfil deletaPerfil(@RequestBody Perfil perfil) {
		perfilRepository.delete(perfil);
	}
	
	
	*/
}
