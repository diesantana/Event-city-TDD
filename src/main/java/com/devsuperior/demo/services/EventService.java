package com.devsuperior.demo.services;

import com.devsuperior.demo.dto.EventDTO;
import com.devsuperior.demo.entities.City;
import com.devsuperior.demo.entities.Event;
import com.devsuperior.demo.repositories.CityRepository;
import com.devsuperior.demo.repositories.EventRepository;
import com.devsuperior.demo.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private CityRepository cityRepository;
    
    @Transactional
    public EventDTO update(Long id, EventDTO dto) {
        try{
            Event event = eventRepository.getReferenceById(id);
            copyDtoToEntity(dto, event);
            event = eventRepository.save(event);
            return new EventDTO(event);
        } 
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
            
        }
    }

    private void copyDtoToEntity(EventDTO dto, Event event) {
        event.setName(dto.getName());
        event.setDate(dto.getDate());
        event.setUrl(dto.getUrl());
        City city = cityRepository.getReferenceById(dto.getCityId());
        event.setCity(city);
    }
}
