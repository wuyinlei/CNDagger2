package ruolan.com.cndagger2;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;


@Module
public class HttpModule {

    @Provides
    public OkHttpClient provideOkHttpClient(){
        return  new OkHttpClient().newBuilder().build();
    }


}
