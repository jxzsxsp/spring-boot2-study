package cn.xiaoshuiping.springbootwebflux.dao;

import cn.xiaoshuiping.springbootwebflux.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Sean.Xiao
 * @date 2018/6/10 下午7:50
 */
@Repository
public class StudentRepository {

    private ConcurrentMap<Long, Student> repository = new ConcurrentHashMap<>();
    private static final AtomicLong idGenerator = new AtomicLong(0);

    public Long save(Student student) {
        Long id = idGenerator.incrementAndGet();
        student.setId(id);
        repository.put(id, student);
        return id;
    }

    public Collection<Student> findAll() {
        return repository.values();
    }

    public Student findStudentById(Long id) {
        return repository.get(id);
    }

    public Long updateStudent(Student student) {
        repository.put(student.getId(), student);
        return student.getId();
    }

    public Long deleteStudent(Long id) {
        repository.remove(id);
        return id;
    }
}
