package com.jsimao71.superheros.web;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindingResult;
import com.jsimao71.superheros.manager.SuperheroManager;
import com.jsimao71.superheros.model.Superhero;
import com.jsimao71.superheros.xmodel.SuperheroFilter;
import com.jsimao71.superheros.xmodel.SuperheroOptions;
import java.net.URI;
import java.util.Collection;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.einnovator.jpa.manager.ManagerBase2;
import org.einnovator.util.PageOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriTemplate;

@RequestMapping(value = { "/api/superhero" })
public class SuperheroRestController extends ControllerBase {

    @Autowired()
    private SuperheroManager superheroManager;

    @GetMapping(value = { "/{id}" })
    public Object get(@PathVariable(value = "id") String id, SuperheroOptions options, Principal principal, HttpServletRequest request, HttpServletResponse response) {
        Superhero superhero = superheroManager.find(id, options);
        status("get", HttpStatus.OK, response);
        return superhero;
    }

    @GetMapping(value = {})
    public Object list(SuperheroFilter filter, PageOptions pageOptions, Principal principal, HttpServletRequest request, HttpServletResponse response) {
        status("list", HttpStatus.OK, response);
        logger.info("list: " + superheroManager.findAll(filter, pageOptions));
        return superheroManager.findAll(filter, pageOptions);
        return superheroManager.findAll(filter, pageOptions);
    }

    @PostMapping(value = {})
    public void create(@RequestBody() Superhero superhero, Principal principal, HttpServletRequest request, HttpServletResponse response) {
        superheroManager.create(superhero);
        status("create", HttpStatus.OK, response);
    }

    @PutMapping(value = { "/{id}" })
    public void update(@PathVariable(value = "id") String id, @RequestBody() Superhero superhero, Principal principal, HttpServletRequest request, HttpServletResponse response) {
        superheroManager.update(superhero);
        nocontent("update", response);
    }

    @DeleteMapping(value = { "/{id}" })
    public void delete(@PathVariable(value = "id") String id, Principal principal, HttpServletRequest request, HttpServletResponse response) {
        superheroManager.delete(id);
        nocontent("delete", response);
    }

    @PostMapping(value = { "/{id}/friend" })
    public void addFriend(@PathVariable(value = "id") String id, Superhero friend, BindingResult errors, Principal principal, HttpServletRequest request, HttpServletResponse response) {
        Superhero superhero = superheroManager.find(id);
        superheroManager.addFriend(superhero, friend);
        URI location = new UriTemplate(request.getRequestURI() + "/{id}").expand(superhero.getId());
        created(location, "addFriend", response);
    }

    @ExceptionHandler(value = {})
    public void error(@PathVariable(value = "exception") Exception exception, Principal principal, HttpServletRequest request, HttpServletResponse response) {
        badrequest("error", response);
    }
}
