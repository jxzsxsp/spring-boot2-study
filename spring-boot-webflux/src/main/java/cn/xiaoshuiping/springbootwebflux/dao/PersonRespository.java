package cn.xiaoshuiping.springbootwebflux.dao;

import cn.xiaoshuiping.springbootwebflux.domain.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sean.Xiao
 * @date 2018/6/12 下午7:45
 */
@Repository
public interface PersonRespository extends ReactiveMongoRepository<Person, Long> {

}
