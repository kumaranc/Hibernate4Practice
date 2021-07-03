package com.arulstudies.hibernate.operations.aliens;

import java.util.List;

public class AlienController {

    public static void main(String[] args) {
        AlienService alienService = new AlienService();
        AlienController controller = new AlienController();

    }

    public void createAlien(AlienService alienService) {
        AlienDTO alienDTO = new AlienDTO();
        alienDTO.setName("solomon");
        alienDTO.setLocation("nagarkoil");
        String value = alienService.createAlien(alienDTO);
        System.out.println(value);
    }

    public void deleteAlien(AlienService alienService) {
        String result = alienService.deleteAlien(1);
        System.out.println(result);
    }

    public List<Alien> getAliens(AlienService alienService, String filter, int limit, int offset) {
        List<Alien> result = alienService.getAliens(filter, limit, offset);
        return result;
    }
}
