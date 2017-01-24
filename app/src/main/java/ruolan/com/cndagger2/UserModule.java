package ruolan.com.cndagger2;

import android.util.Log;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import ruolan.com.cndagger2.ano.Debug;
import ruolan.com.cndagger2.ano.Release;


@Module//(includes = {HttpModule.class})
public class UserModule {



    @Provides
    @Debug
    public ApiServer provideApiServerForDebug(OkHttpClient client){
        Log.d("UserModule", "provideApiServerForDebug");
        return new ApiServer(client);
    }

    @Provides
    @Release
    public ApiServer provideApiServerForRelease(OkHttpClient client){
        Log.d("UserModule", "provideApiServerForRelease");
        return new ApiServer(client);
    }

    @Provides
    public UserManager provideUserManager(ApiServer apiServer){
        return new UserManager(apiServer);
    }



}
