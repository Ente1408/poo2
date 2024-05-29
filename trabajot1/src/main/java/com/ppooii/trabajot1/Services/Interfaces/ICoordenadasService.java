package com.ppooii.trabajot1.Services.Interfaces;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ppooii.trabajot1.entities.Coordenadas;

public interface ICoordenadasService {
	List<Coordenadas> consultarAllCoordenadas(Pageable pageable);
}
