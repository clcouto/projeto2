package br.edu.ccouto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ccouto.entities.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long>{

}
