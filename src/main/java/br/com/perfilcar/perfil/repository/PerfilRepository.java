package br.com.perfilcar.perfil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.perfilcar.perfil.models.Perfil;


public interface PerfilRepository  extends JpaRepository<Perfil,Long> {

	Perfil findById(long id);
	
}
