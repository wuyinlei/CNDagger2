package ruolan.com.cndagger2;

import javax.inject.Singleton;

import dagger.Component;



@Singleton
@Component(modules = {UserModule.class})
public interface UserComponent {

    void inject(MainActivity activity);

}
