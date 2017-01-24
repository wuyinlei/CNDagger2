package ruolan.com.cndagger2;

import dagger.Module;
import dagger.Provides;


@Module
public class UserModule {

    @Provides
    public ApiServer provideApiServer(){
        return new ApiServer();
    }
}
