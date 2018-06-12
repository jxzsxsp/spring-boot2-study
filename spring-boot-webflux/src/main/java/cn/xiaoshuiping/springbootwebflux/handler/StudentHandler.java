package cn.xiaoshuiping.springbootwebflux.handler;

import cn.xiaoshuiping.springbootwebflux.dao.StudentRepository;
import cn.xiaoshuiping.springbootwebflux.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Sean.Xiao
 * @date 2018/6/10 下午7:58
 */
@Component
public class StudentHandler {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentHandler(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Mono<Long> save(Student student) {
        return Mono.create(studentMonoSink -> studentMonoSink.success(studentRepository.save(student)));
    }

    public Mono<Student> findStudentById(Long id) {
        return Mono.justOrEmpty(studentRepository.findStudentById(id));
    }

    public Flux<Student> findAllStudent() {
        return Flux.fromIterable(studentRepository.findAll());
    }

    public Mono<Long> modifyStudent(Student student) {
        return Mono.create(studentMonoSink -> studentMonoSink.success(studentRepository.updateStudent(student)));
    }

    public Mono<Long> deletStudent(Long id) {
        return Mono.create(studentMonoSink -> studentMonoSink.success(studentRepository.deleteStudent(id)));
    }
}
