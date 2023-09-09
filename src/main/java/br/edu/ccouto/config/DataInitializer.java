package br.edu.ccouto.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.edu.ccouto.entities.Usuario;
import br.edu.ccouto.repositories.UserRepository;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		
		List<Usuario> usuarios = userRepository.findAll();
		

		if (usuarios.isEmpty()) {
			
			createUsuario("Cláudio Luiz Couto","clcouto@gmail.com");
			createUsuario("João Couto","jcouto@gmail.com");
			createUsuario("Pedro Couto","pcouto@gmail.com");
			createUsuario("Lúcia Couto","lcouto@gmail.com");
			createUsuario("Elvira Couto","elvira@gmail.com");
		
		/*
		Usuario usuario = new Usuario();
		
		usuario.setName("Cláudio Luiz Couto");
		usuario.setEmail("clcouto@gmail.com");
		
		Usuario usuario2 = new Usuario();
		usuario2.setName("Fabiano Couto");
		usuario2.setEmail("fcouto@gmail.com");
		
		userRepository.save(usuario);
		userRepository.save(usuario2);
		*/
			
		}
		
		// Usuario usuario = userRepository.getReferenceById(1L);
		// System.out.println(usuario.getName());
		
		// userRepository.deleteById(2L);

	}
	public void createUsuario(String name, String email) {
		
		Usuario usuario = new Usuario(name, email);
		userRepository.save(usuario);
		
	}	
	
	
	

}
