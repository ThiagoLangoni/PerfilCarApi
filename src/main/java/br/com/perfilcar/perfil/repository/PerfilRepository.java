package br.com.perfilcar.perfil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sun.istack.FinalArrayList;

import br.com.perfilcar.perfil.models.Perfil;


public interface PerfilRepository  extends JpaRepository<Perfil,Long> {

	Perfil findById(long id);
	
	List <Perfil> findByEmailProprietario(String emailProprietario);

}
