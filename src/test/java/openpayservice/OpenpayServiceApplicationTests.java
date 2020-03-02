/**
 * Openpay
 *
 * Creado el 1 mar. 2020 20:08:06 (dd/mm/aaaa hh:mm)
 *
 * Copyright (C) Oswaldo Vargas All rights reserved. Todos los derechos reservados.
 *
 */
package openpayservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import mx.oswaldo.openpay.controller.UsuarioController;
import mx.oswaldo.openpay.model.AltaCuentaUsuarioReqBean;
import mx.oswaldo.openpay.model.CuentaUsuarioResponseBean;
import mx.oswaldo.openpay.model.ModificaUsuarioReqBean;
import mx.oswaldo.openpay.model.NuevaCuentaUsuarioReqBean;
import mx.oswaldo.openpay.service.CuentaUsuarioService;

/**
 * 
 * @Proyecto: openpay-service
 * @Paquete : openpayservice
 * @Clase : OpenpayServiceApplicationTests.java. <br/>
 *        Clase que se encarga de realizar las pruebas unitarias de JUNIT
 * @version 1.0.0
 * @juan.vargas
 *
 */
@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = { SpringBootApplication.class })
class OpenpayServiceApplicationTests {

	/**
	 * instancia del mock controller
	 */
	@InjectMocks
	UsuarioController usuarioController;

	/**
	 * mock para simular el servicio de cuenta usuario
	 */
	@Mock
	private CuentaUsuarioService cuentaUsuarioService;

	/**
	 * Metodo que realiza la prueba unitaria a la alta de usuario
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testAltaUsuario() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setContentType("application/json");
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		BindingResult errors = new BeanPropertyBindingResult(request, "altaCuentaUsuarioReqBean");

		AltaCuentaUsuarioReqBean objReq = new AltaCuentaUsuarioReqBean();
		objReq.setApellidoMaterno("Vargas");
		objReq.setApellidoPaterno("Nuñez");
		objReq.setCelular("+(123) - 456-78-97");
		objReq.setDireccion("Felipe Angeles");
		objReq.setEdad(25);
		objReq.setNombre("juan Oswaldo");
		objReq.setProducto("LIBRETON");

		when(cuentaUsuarioService.altaCuentaUsuario(objReq)).thenReturn(new CuentaUsuarioResponseBean());

		ResponseEntity<Object> responseEntity = (ResponseEntity<Object>) usuarioController.altaUsuario(request, objReq,
				new Locale("es"), errors);

		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

	}

	/**
	 * Metodo que realiza la prueba unitaria a eliminar un usuario
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testEliminaUsuario() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setContentType("application/json");
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		when(cuentaUsuarioService.eliminUsuario(50L)).thenReturn(Boolean.TRUE);

		ResponseEntity<Object> responseEntity = (ResponseEntity<Object>) usuarioController.eliminaUsuario(50L, request,
				new Locale("es"));

		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

	}

	/**
	 * Metodo que realiza la prueba unitaria a la alta de usuario
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testGetUsuario() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setContentType("application/json");
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		when(cuentaUsuarioService.listaDatosUsuario(50L)).thenReturn(new CuentaUsuarioResponseBean());

		ResponseEntity<Object> responseEntity = (ResponseEntity<Object>) usuarioController.getUsuario(50L, request,
				new Locale("es"));

		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

	}

	/**
	 * Metodo que realiza la prueba unitaria a modificar un usuario
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testAgregaCuentaUsuario() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setContentType("application/json");
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		BindingResult errors = new BeanPropertyBindingResult(request, "altaCuentaUsuarioReqBean");

		ModificaUsuarioReqBean requestBean = new ModificaUsuarioReqBean();
		requestBean.setId(50L);
		requestBean.setApellidoMaterno("Vargas");
		requestBean.setApellidoPaterno("Nuñez");
		requestBean.setCelular("+(123) - 456-78-97");
		requestBean.setDireccion("Felipe Angeles");
		requestBean.setEdad(25);
		requestBean.setNombre("juan Oswaldo");

		when(cuentaUsuarioService.modificaUsuario(requestBean)).thenReturn(new CuentaUsuarioResponseBean());

		ResponseEntity<Object> responseEntity = (ResponseEntity<Object>) usuarioController.modificaUsuario(requestBean,
				request, new Locale("es"), errors);

		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}

	/**
	 * Metodo que realiza la prueba unitaria a agregar un usuario
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testModificaUsuario() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setContentType("application/json");
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		BindingResult errors = new BeanPropertyBindingResult(request, "altaCuentaUsuarioReqBean");

		NuevaCuentaUsuarioReqBean requestBean = new NuevaCuentaUsuarioReqBean();
		requestBean.setId(50L);
		requestBean.setProducto("Tarjeta Azul");

		when(cuentaUsuarioService.agregaCuentaUsuario(requestBean)).thenReturn(new CuentaUsuarioResponseBean());

		ResponseEntity<Object> responseEntity = (ResponseEntity<Object>) usuarioController
				.agregaCuentaUsuario(requestBean, request, new Locale("es"), errors);

		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}
}
