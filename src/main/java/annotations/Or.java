package annotations;

import java.lang.annotation.*;

/**
 * desc:
 *
 * @author ljf
 * date: 2021/7/26
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Or {
    String[] values() default {};
}
