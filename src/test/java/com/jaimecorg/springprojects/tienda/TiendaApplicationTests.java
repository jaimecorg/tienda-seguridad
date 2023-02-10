package com.jaimecorg.springprojects.tienda;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

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

		User u2 = new User();
		u2.setId(2);
		u2.setName("jaimecorg2");
		u2.setPassword(encoder.encode("5555"));
		u2.setEmail("jaimecorg2@gmail.com");

		User u3 = new User();
		u3.setId(3);
		u3.setName("jaimecorg3");
		u3.setPassword(encoder.encode("5555"));
		u3.setEmail("jaimecorg3@gmail.com");
	
		User u4 = new User();
		u4.setId(4);
		u4.setName("jaimecorg4");
		u4.setPassword(encoder.encode("5555"));
		u4.setEmail("jaimecorg4@gmail.com");

		Permission permisoAdmin = new Permission();
		permisoAdmin.setId(1);
		permisoAdmin.setName("ADMIN");

		Permission permisoPedidos = new Permission();
		permisoPedidos.setId(2);
		permisoPedidos.setName("PEDIDOS");

		Permission permisoClientesPermisos = new Permission();
		permisoClientesPermisos.setId(3);
		permisoClientesPermisos.setName("CLIENTESPERMISOS");

		Permission permisoInicio = new Permission();
		permisoInicio.setId(4);
		permisoInicio.setName("INICIO");

		List<Permission> listaPermisosTodos = new ArrayList<Permission>();
		listaPermisosTodos.add(permisoAdmin);
		listaPermisosTodos.add(permisoPedidos);
		listaPermisosTodos.add(permisoClientesPermisos);
		listaPermisosTodos.add(permisoInicio);

		List<Permission> listaPermisosUsuario2 = new ArrayList<Permission>();
		listaPermisosUsuario2.add(permisoPedidos);
		listaPermisosUsuario2.add(permisoInicio);

		List<Permission> listaPermisosUsuario3 = new ArrayList<Permission>();
		listaPermisosUsuario3.add(permisoPedidos);
		listaPermisosUsuario3.add(permisoClientesPermisos);
		listaPermisosUsuario3.add(permisoInicio);

		u1.setPermissions(listaPermisosTodos);
		u2.setPermissions(listaPermisosUsuario2);
		u3.setPermissions(listaPermisosUsuario3);

		permissionRepository.save(permisoAdmin);
		permissionRepository.save(permisoPedidos);
		permissionRepository.save(permisoClientesPermisos);
		permissionRepository.save(permisoInicio);

		userRepository.save(u1);
		User saveUser2 = userRepository.save(u2);
		userRepository.save(u3);
		userRepository.save(u4);

		assertTrue(u2.getPassword().equalsIgnoreCase(saveUser2.getPassword()));

	}

}
