package com.arulstudies.hibernate.operations.aliens;

import com.arulstudies.hibernate.util.Util;

import java.util.List;
import java.util.function.Function;

public class AlienService implements CRUDPrerequisite{

    @Override
    public String createAlien(AlienDTO alienDTO) {
        Alien alien = mapAlienDTOtoAlien.apply(alienDTO);
        String id = AlienRepository.getInstance().createAlien(alien);

        if(!Util.isEmptyValue(id)) return "{\"id\":\""+id+"\",\"message\":\"Alien created successfully\"}";
        return "Not success";
    }

    @Override
    public String deleteAlien(int id) {
        Alien alien = AlienRepository.getInstance().getAlien(id);
        boolean result = AlienRepository.getInstance().deleteAlien(alien);
        String message = result ? "Alien removed successfully" : "Alien not removed";
        return "{\"id\":\""+id+"\",\"message\":\""+message+"\"}";
    }

    @Override
    public List<Alien> getAliens(String filter, int limit, int offset) {
        List<Alien> alien = AlienRepository.getInstance().getAliens(null, limit, offset);
        return null;
    }

    Function<AlienDTO, Alien> mapAlienDTOtoAlien = (alienDTO) -> {

        Alien alien = new Alien();
        alien.setName(alienDTO.getName());
        alien.setLocation(alienDTO.getLocation());
        return alien;
    };
}
