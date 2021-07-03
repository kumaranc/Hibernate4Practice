package com.arulstudies.hibernate.operations.aliens;

import java.util.List;

public interface CRUDPrerequisite {

    public String createAlien(AlienDTO alienDTO);

    public String deleteAlien(int id);

    public List<Alien> getAliens(String filter, int limit, int offset);
}
