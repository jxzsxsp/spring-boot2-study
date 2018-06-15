package cn.xiaoshuiping.springbootwebflux.domain;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @author Sean.Xiao
 * @date 2018/6/10 下午7:43
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 4557577374290627279L;

    @Id
    private Long id;
    private String name;
    private Integer age;
    private Double score;
    private String description;

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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
