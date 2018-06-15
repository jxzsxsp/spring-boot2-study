package cn.xiaoshuiping.springbootwebflux.controller;

import cn.xiaoshuiping.springbootwebflux.domain.Person;
import cn.xiaoshuiping.springbootwebflux.domain.Student;
import cn.xiaoshuiping.springbootwebflux.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ReactiveValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * @author Sean.Xiao
 * @date 2018/6/14 下午7:48
 */
@RestController
@RequestMapping(value = "/redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ReactiveRedisTemplate reactiveRedisTemplate;

    @PostMapping(value = "/student")
    public Mono<Student> saveStudent(@RequestBody Student student) {
        String key = RedisUtil.getStudentKey(student.getId());
        ValueOperations<String, Student> ops = redisTemplate.opsForValue();
        ops.set(key, student);

        return Mono.create(studentMonoSink -> studentMonoSink.success(student));
    }

    @GetMapping(value = "/student/{id}")
    public Mono<Student> findStudentById(@PathVariable("id") Long id) {
        String key = RedisUtil.getStudentKey(id);
        ValueOperations<String, Student> ops = redisTemplate.opsForValue();
        Boolean hasKey = redisTemplate.hasKey(key);

        if(!hasKey) {
            return Mono.create(studentMonoSink -> studentMonoSink.success(null));
        }

        Student student = ops.get(key);

        return Mono.create(studentMonoSink -> studentMonoSink.success(student));
    }

    @DeleteMapping(value = "/student/{id}")
    public Mono<Long> deleteStudent(@PathVariable("id") Long id) {
        String key = RedisUtil.getStudentKey(id);
        Boolean hasKey = redisTemplate.hasKey(key);

        if(hasKey) {
            redisTemplate.delete(key);
        }

        return Mono.create(longMonoSink -> longMonoSink.success(id));
    }

    @PostMapping(value = "/person")
    public Mono<Person> savePerson(@RequestBody Person person) {
        String key = RedisUtil.getPersonKey(person.getId());
        ReactiveValueOperations<String, Person> ops = reactiveRedisTemplate.opsForValue();

        return ops.getAndSet(key, person);
    }

    @GetMapping(value = "/person/{id}")
    public Mono<Person> findPersonById(@PathVariable("id") Long id) {
        String key = RedisUtil.getPersonKey(id);
        ReactiveValueOperations<String, Person> ops = reactiveRedisTemplate.opsForValue();

        return ops.get(key);
    }

    @DeleteMapping(value = "/person/{id}")
    public Mono<Long> deletePerson(@PathVariable("id") Long id) {
        String key = RedisUtil.getPersonKey(id);

        return reactiveRedisTemplate.delete(key);
    }
}
