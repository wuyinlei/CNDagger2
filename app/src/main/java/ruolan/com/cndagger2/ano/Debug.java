package ruolan.com.cndagger2.ano;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by wuyinlei on 2017/1/24.
 */

@Qualifier
@Documented
@Retention(RUNTIME)
public @interface Debug {

}
