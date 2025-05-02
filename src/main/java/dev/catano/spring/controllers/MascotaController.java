package dev.catano.spring.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.catano.spring.model.Mascota;
import dev.catano.spring.services.MascotaService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {
	
	private final MascotaService mascotaService;

	public MascotaController(MascotaService mascotaService) {
		this.mascotaService = mascotaService;
	}

	@GetMapping("")
	public ResponseEntity<?> getMascotas() {
		log.info("Buscando lista de mascotas");
		try {
			List<Mascota> l = mascotaService.getMascotas();
			log.info("Lista de mascotas: {}", l);
			return new ResponseEntity<>(l, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Lista no encontrada.");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getMascota(@PathVariable int id) {
		log.info("Buscando mascota con id: {}", id);
		try {
			Mascota m = mascotaService.getMascota(id);
			log.info("Mascota encontrada: {}", m);
			return new ResponseEntity<>(m, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Mascota no encontrada.");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
