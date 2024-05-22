package com.devsuperior.demo.services;

import com.devsuperior.demo.dto.CityDTO;
import com.devsuperior.demo.entities.City;
import com.devsuperior.demo.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityService {
    
    @Autowired
    private CityRepository cityRepository;
    
    @Transactional(readOnly = true)
    public List<CityDTO> findAll() {
        List<City> cityList = cityRepository.findAll(Sort.by("name"));
        return cityList.stream().map(CityDTO::new).toList();
    }
    
    @Transactional
    public CityDTO insert(CityDTO dto) {
        City newCity = new City(null, dto.getName());
        newCity = cityRepository.save(newCity);
        return new CityDTO(newCity);
    }
    
}
