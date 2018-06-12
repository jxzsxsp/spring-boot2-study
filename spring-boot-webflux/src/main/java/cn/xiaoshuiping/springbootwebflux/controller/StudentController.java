package cn.xiaoshuiping.springbootwebflux.controller;

import cn.xiaoshuiping.springbootwebflux.domain.Student;
import cn.xiaoshuiping.springbootwebflux.handler.StudentHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Sean.Xiao
 * @date 2018/6/11 上午9:46
 */
@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentHandler studentHandler;

    @GetMapping(value = "/{id}")
    public Mono<Student> findStudentById(@PathVariable("id") Long id) {
        return studentHandler.findStudentById(id);
    }

    @GetMapping()
    public Flux<Student> findAllStudent() {
        return studentHandler.findAllStudent();
    }

    @PostMapping()
    public Mono<Long> saveStudent(@RequestBody Student student) {
        return studentHandler.save(student);
    }

    @PutMapping()
    public Mono<Long> modifyStudent(@RequestBody Student student) {
        return studentHandler.modifyStudent(student);
    }

    @DeleteMapping(value = "/{id}")
    public Mono<Long> deleteStudent(@PathVariable("id") Long id) {
        return studentHandler.deletStudent(id);
    }
}
