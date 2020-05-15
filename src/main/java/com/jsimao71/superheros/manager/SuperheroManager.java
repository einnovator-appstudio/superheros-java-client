package com.jsimao71.superheros.manager;

import com.jsimao71.superheros.model.Superhero;
import com.jsimao71.superheros.xmodel.SuperheroFilter;
import java.util.Collection;
import java.util.Optional;
import org.einnovator.jpa.manager.ManagerBase2;
import org.einnovator.util.PageOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SuperheroManager extends ManagerBase2<Superhero, Long> {

    /**
     * Find instances of {@code Superhero} matching specified filter condition.
     */
    public Page<Superhero> findAll(SuperheroFilter filter, Pageable pageable);

    /**
     * Find instances of {@code Superhero} matching specified filter condition.
     *
     * @param filter the value of filter
     * @param pageable the value of pageable
     * @return the result
     */
    public Page<Superhero> findAll(SuperheroFilter filter, PageOptions pageable);

    public long count(SuperheroFilter filter);

    public void populate();

    public void populate(boolean force);

    public Superhero addFriend(Superhero superhero, Superhero friend);

    public Superhero removeFriend(Superhero superhero, Superhero friend);

    public Superhero findFriend(Superhero superhero, String id);
}
