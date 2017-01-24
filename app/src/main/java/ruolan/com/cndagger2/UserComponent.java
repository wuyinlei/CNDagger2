package ruolan.com.cndagger2;

import dagger.Component;



@Component(modules = UserModule.class)
public interface UserComponent {

    void inject(MainActivity activity);

}
