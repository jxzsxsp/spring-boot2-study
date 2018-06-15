package cn.xiaoshuiping.springbootwebflux.domain;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @author Sean.Xiao
 * @date 2018/6/12 下午7:42
 */
public class Person implements Serializable {

    private static final long serialVersionUID = -7833800558942340L;

    @Id
    private Long id;
    private String name;
    private Integer age;
    private boolean gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
