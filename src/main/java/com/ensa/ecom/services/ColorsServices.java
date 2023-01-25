package com.ensa.ecom.services;


import com.ensa.ecom.dao.ColorsRepository;
import com.ensa.ecom.entities.Colors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ColorsServices {


        private  final ColorsRepository colorsRepository;



    @Autowired
    public ColorsServices(ColorsRepository colorsRepository) {
        this.colorsRepository = colorsRepository;
    }

    public Colors addColor(Colors colors) {
        return colorsRepository.save(colors);
    }

    public List<Colors> findAllColors() {
        return colorsRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Colors updateColor(Colors colors) {
        return colorsRepository.save(colors);
    }

    public Colors findColorById(Long id)
    {
        Optional<Colors> optional = colorsRepository.findById(id);
        Colors colors = optional.get();
        return colors;
    }

    public boolean find(Long id)
    {
        return colorsRepository.existsById(id);
    }

    public void deleteColor(Long id){
        colorsRepository.deleteColorById(id);
    }
}











