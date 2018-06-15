package cn.xiaoshuiping.springbootwebflux.util;

/**
 * @author Sean.Xiao
 * @date 2018/6/15 上午10:05
 */
public class RedisUtil {

    public static String getStudentKey(Long id) {
        return "student_" + id;
    }
}
