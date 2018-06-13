package cn.xiaoshuiping.springbootwebflux.controller;

import cn.xiaoshuiping.springbootwebflux.domain.Person;
import cn.xiaoshuiping.springbootwebflux.handler.PersonHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Sean.Xiao
 * @date 2018/6/12 下午7:55
 */
@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonHandler personHandler;

    @GetMapping(value = "/{id}")
    public Mono<Person> findPersonById(@PathVariable(value = "id") Long id) {
        return personHandler.findPersonById(id);
    }

    @GetMapping()
    public Flux<Person> findAllPerson() {
        return personHandler.findAllPerson();
    }

    @PostMapping()
    public Mono<Person> savePerson(@RequestBody Person person) {
        return personHandler.save(person);
    }

    @PutMapping()
    public Mono<Person> modifyPerson(@RequestBody Person person) {
        return personHandler.modifyPerson(person);
    }

    @DeleteMapping(value = "/{id}")
    public Mono<Long> deletePerson(@PathVariable(value = "id") Long id) {
        return personHandler.deletePerson(id);
    }
}
