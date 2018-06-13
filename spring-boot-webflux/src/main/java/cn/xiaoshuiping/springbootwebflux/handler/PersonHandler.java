package cn.xiaoshuiping.springbootwebflux.handler;

import cn.xiaoshuiping.springbootwebflux.dao.PersonRespository;
import cn.xiaoshuiping.springbootwebflux.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Sean.Xiao
 * @date 2018/6/12 下午7:49
 */
@Component
public class PersonHandler {

    private final PersonRespository personRespository;

    @Autowired
    public PersonHandler(PersonRespository personRespository) {
        this.personRespository = personRespository;
    }

    public Mono<Person> save(Person person) {
        return personRespository.save(person);
    }

    public Mono<Person> findPersonById(Long id) {
        return personRespository.findById(id);
    }

    public Flux<Person> findAllPerson() {
        return personRespository.findAll();
    }

    public Mono<Person> modifyPerson(Person person) {
        return personRespository.save(person);
    }

    public Mono<Long> deletePerson(Long id) {
        personRespository.deleteById(id);
        return Mono.create(personMonoSink -> personMonoSink.success(id));
    }
}
