package com.jsimao71.superheros.manager;

import org.springframework.stereotype.Service;
import com.jsimao71.superheros.model.Superhero;
import com.jsimao71.superheros.repository.SuperheroRepository;
import com.jsimao71.superheros.xmodel.SuperheroFilter;
import org.einnovator.jpa.manager.ManagerBaseImpl2;
import org.einnovator.util.PageOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service()
public class SuperheroManagerImpl extends ManagerBaseImpl2<Superhero, Long> implements SuperheroManager {

    public final String SUPERHERO_RESOURCE_JSON = "data/Superhero.json";

    public final String SUPERHERO_RESOURCE_XML = "data/Superhero.xml";

    public final String SUPERHERO_RESOURCE_XLS = "data/Superhero.xls";

    @Autowired
    private SuperheroRepository repository;

    private boolean init;

    public SuperheroRepository getRepository() {
        return repository;
    }

    public Page<Superhero> findAll(SuperheroFilter filter, Pageable pageable) {
        populate();
        Page<Superhero> page = null;
        ;
        if (page == null)
            page = repository.findAll(pageable);
        else
            ;
        return processAfterLoad(page, filter);
    }

    public Page<Superhero> findAll(SuperheroFilter filter, PageOptions pageable) {
        return findAll(filter, pageable);
    }

    public long count(SuperheroFilter filter) {
        ;
        return repository.count();
    }

    public void populate() {
        populate(false);
    }

    public void populate(boolean force) {
        populate(Superhero.class, force, SUPERHERO_RESOURCE_JSON);
    }

    public Superhero addFriend(Superhero superhero, Superhero friend) {
        Superhero superhero0 = find(superhero);
        superhero0.addFriend(friend);
        return superhero0;
    }

    public Superhero removeFriend(Superhero superhero, Superhero friend) {
        Superhero superhero0 = find(superhero);
        superhero0.removeFriend(friend);
        return superhero0;
    }

    public Superhero findFriend(Superhero superhero, String id) {
        Superhero superhero0 = find(superhero);
        return superhero0.findFriend(id);
    }
}
