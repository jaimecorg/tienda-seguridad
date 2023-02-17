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
		u1.setName("usuario1");
		u1.setPassword(encoder.encode("1234"));
		u1.setEmail("usuario@gmail.com");

		User u2 = new User();
		u2.setId(2);
		u2.setName("usuario2");
		u2.setPassword(encoder.encode("5555"));
		u2.setEmail("usuario2@gmail.com");

		User u3 = new User();
		u3.setId(3);
		u3.setName("usuario3");
		u3.setPassword(encoder.encode("666"));
		u3.setEmail("usuario3@gmail.com");

		User u4 = new User();
		u4.setId(20);
		u4.setName("usuario4");
		u4.setPassword(encoder.encode("777"));
		u4.setEmail("usuario4@gmail.com");

		Permission PermissionAdmin = new Permission();
		PermissionAdmin.setId(1);
		PermissionAdmin.setName("ADMIN");

		Permission PermissionPedidos = new Permission();
		PermissionPedidos.setId(2);
		PermissionPedidos.setName("PEDIDOS");

		Permission PermissionClientes = new Permission();
		PermissionClientes.setId(3);
		PermissionClientes.setName("CLIENTES");

		Permission PermissionCesta = new Permission();
		PermissionCesta.setId(4);
		PermissionCesta.setName("CESTA");

		Permission PermissionProveedores = new Permission();
		PermissionProveedores.setId(5);
		PermissionProveedores.setName("PROVEEDORES");

		Permission PermissionVendedores = new Permission();
		PermissionVendedores.setId(6);
		PermissionVendedores.setName("VENDEDORES");

		Permission PermissionEmpleados = new Permission();
		PermissionEmpleados.setId(7);
		PermissionEmpleados.setName("EMPLEADOS");

		Permission PermissionDepartamentos = new Permission();
		PermissionDepartamentos.setId(8);
		PermissionDepartamentos.setName("DEPARTAMENTOS");

		List<Permission> PermissionsTodos = new ArrayList<Permission>();
		PermissionsTodos.add(PermissionAdmin);

		List<Permission> PermissionsUsuario2 = new ArrayList<Permission>();
		PermissionsUsuario2.add(PermissionPedidos);
		PermissionsUsuario2.add(PermissionCesta);

		List<Permission> PermissionsUsuario3 = new ArrayList<Permission>();
		PermissionsUsuario3.add(PermissionPedidos);
		PermissionsUsuario3.add(PermissionClientes);
		PermissionsUsuario3.add(PermissionCesta);

		u1.setPermissions(PermissionsTodos);
		u2.setPermissions(PermissionsUsuario2);
		u3.setPermissions(PermissionsUsuario3);

		permissionRepository.save(PermissionAdmin);
		permissionRepository.save(PermissionPedidos);
		permissionRepository.save(PermissionClientes);
		permissionRepository.save(PermissionCesta);
		permissionRepository.save(PermissionProveedores);
		permissionRepository.save(PermissionVendedores);
		permissionRepository.save(PermissionEmpleados);
		permissionRepository.save(PermissionDepartamentos);

		userRepository.save(u1);
		userRepository.save(u3);
		userRepository.save(u4);
		User saveUsuario2 = userRepository.save(u2);

		assertTrue(u2.getPassword().equalsIgnoreCase(saveUsuario2.getPassword()));

	}

}
