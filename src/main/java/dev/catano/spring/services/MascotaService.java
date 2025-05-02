package dev.catano.spring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.catano.spring.model.Mascota;
import dev.catano.spring.repository.MascotaRepository;

@Service
public class MascotaService {

	private final MascotaRepository mascotaRepository;	
	
	public MascotaService(MascotaRepository mascotaRepository) {
		this.mascotaRepository = mascotaRepository;
	}
	
	public List<Mascota> getMascotas() {
		return mascotaRepository.getMascotas();
	}

	public Mascota getMascota(int id) throws Exception {
		Mascota m = mascotaRepository.getMascota(id);
		if (m == null)
			throw new Exception("Mascota no encontrada");
		return m;
	}

	
}
