package br.com.perfilcar.perfil.interfaces;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.perfilcar.perfil.application.PerfilService;
import br.com.perfilcar.perfil.domain.Perfil;

@RestController
@RequestMapping(path = "/perfil")
@CrossOrigin(origins = "*")
public class PerfilResource {

	private final PerfilService service;

	@Autowired
	public PerfilResource(PerfilService service) {
		this.service = service;
	}

	@GetMapping("/perfis")
	public List<Perfil> listaPerfis() {
		return service.listaPerfis();
	}

	@GetMapping("/perfis/{emailProprietario}")
	public List<Perfil> listaPerfisPorEmail(@PathVariable(value = "emailProprietario") String emailProprietario) {
		return service.listaPerfisPorEmail(emailProprietario);
	}

	@GetMapping("/perfil/{id}")
	public Perfil listaPerfilUnico(@PathVariable(value = "id") long id) {
		return service.listaPerfilUnico(id);
	}

	@PostMapping("/perfil")
	public ResponseEntity<Void> salvaPerfil(@RequestBody Perfil perfil) {
		Perfil perfilInserido = service.salvaPerfil(perfil);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
												  .path("/{id}")
												  .buildAndExpand(perfilInserido.getId())
												  .toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping("/perfil")
	public Perfil atualizaPerfil(@RequestBody Perfil perfil) {
		return service.atualizaPerfil(perfil);
	}

	@DeleteMapping("/perfil/{id}")
	public void deletaPerfil(@PathVariable(value = "id") long id) {
		service.deletaPerfil(id);
	}
}
