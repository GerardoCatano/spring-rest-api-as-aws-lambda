package dev.catano.spring.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import dev.catano.spring.model.Mascota;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MascotaMockRepository implements MascotaRepository {
	
	private List<Mascota> mascotasList = new ArrayList<>();	

	public MascotaMockRepository() {			
		mascotasList.add(new Mascota(1, "Max", "perro"));
		mascotasList.add(new Mascota(2, "Tom", "gato"));
		mascotasList.add(new Mascota(3, "Hammy", "hámster"));
		mascotasList.add(new Mascota(4, "Pelusa", "perro"));
		mascotasList.add(new Mascota(5, "Kira", "gato"));
		log.info("Lista inicial de mascotas: {}", mascotasList);
	}

	@Override
	public List<Mascota> getMascotas() {
		return mascotasList;
	}

	@Override
	public Mascota getMascota(int id) {		
		Mascota m = mascotasList.stream()
				.filter(mascota -> id == mascota.getId())
				.findFirst()
				.orElse(null);		
		return m;
	}



}
