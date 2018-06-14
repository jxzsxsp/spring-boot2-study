package cn.xiaoshuiping.springbootwebflux.controller;

import cn.xiaoshuiping.springbootwebflux.constant.TemplateConstant;
import cn.xiaoshuiping.springbootwebflux.domain.Person;
import cn.xiaoshuiping.springbootwebflux.handler.PersonHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Sean.Xiao
 * @date 2018/6/12 下午7:55
 */
@Controller
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonHandler personHandler;

    @GetMapping(value = "/{id}")
    public @ResponseBody Mono<Person> findPersonById(@PathVariable(value = "id") Long id) {
        return personHandler.findPersonById(id);
    }

    @GetMapping()
    public @ResponseBody Flux<Person> findAllPerson() {
        return personHandler.findAllPerson();
    }

    @PostMapping()
    public @ResponseBody Mono<Person> savePerson(@RequestBody Person person) {
        return personHandler.save(person);
    }

    @PutMapping()
    public @ResponseBody Mono<Person> modifyPerson(@RequestBody Person person) {
        return personHandler.modifyPerson(person);
    }

    @DeleteMapping(value = "/{id}")
    public @ResponseBody Mono<Long> deletePerson(@PathVariable(value = "id") Long id) {
        return personHandler.deletePerson(id);
    }

    @GetMapping(value = "/hello")
    public Mono<String> helloThymeleaf(final Model model) {
        model.addAttribute("title", "你好，Thymeleaf!");
        model.addAttribute("desc", "这是我的第一个Thymeleaf模板页面。");

        return Mono.create(monoSink -> monoSink.success(TemplateConstant.HELLO));
    }

    @GetMapping(value = "/page/list")
    public String personList(final Model model) {
        final Flux<Person> personList = personHandler.findAllPerson();
        model.addAttribute("personList", personList);
        return TemplateConstant.PERSON_LIST;
    }
}
