package com.jaimecorg.springprojects.tienda;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jaimecorg.springprojects.tienda.model.Group;
import com.jaimecorg.springprojects.tienda.model.Permission;
import com.jaimecorg.springprojects.tienda.model.User;
import com.jaimecorg.springprojects.tienda.repository.PermissionRepository;
import com.jaimecorg.springprojects.tienda.repository.UserRepository;

@SpringBootTest
class TiendaApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PermissionRepository permissionRepository;

	@Autowired
	PasswordEncoder encoder;
	@Test
	void crearUsuariosTest() {
		User u1 = new User();
		u1.setId(1);
		u1.setName("jaimecorg");
		u1.setPassword(encoder.encode("1234"));
		u1.setEmail("jaimecorg@gmail.com");

		Group g1 = new Group();
		g1.setId(1);
		u1.setGroup(g1);

		User u2 = new User();
		u2.setId(2);
		u2.setName("jaimecorg2");
		u2.setPassword(encoder.encode("5555"));
		u2.setEmail("jaimecorg2@gmail.com");
		Group g2 = new Group();
		g2.setId(2);
		u2.setGroup(g2);

		Permission p1 = new Permission();
		p1.setId(1);
		p1.setName("ADMIN");

		Permission p2 = new Permission();
		p2.setId(2);
		p2.setName("USER");

		List<Permission> permisos1 = new ArrayList<Permission>();

		permisos1.add(p1);
		permisos1.add(p2);

		List<Permission> permisos2 = new ArrayList<Permission>();
		permisos2.add(p2);

		u1.setPermissions(permisos1);
		u2.setPermissions(permisos2);

		permissionRepository.save(p1);
		permissionRepository.save(p2);

		userRepository.save(u1);
		User saveUser2 = userRepository.save(u2);

		assertTrue(u2.getPassword().equalsIgnoreCase(saveUser2.getPassword()));

	}

}
