package dev.catano.spring.repository;


import java.util.List;

import dev.catano.spring.model.Mascota;

public interface MascotaRepository {

	List<Mascota> getMascotas();
	
	Mascota getMascota(int id);
	
}
