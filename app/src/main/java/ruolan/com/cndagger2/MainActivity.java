package ruolan.com.cndagger2;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

import okhttp3.OkHttpClient;
import ruolan.com.cndagger2.ano.Debug;
import ruolan.com.cndagger2.ano.Release;

public class MainActivity extends AppCompatActivity {


//    @Inject
//    @Debug
//    ApiServer mApiServerDebug;
//
//    @Inject
//    @Named("release")
//    ApiServer mApiServerRelease;

//    @Inject
//    OkHttpClient mOkHttpClientDemo1;
//    @Inject
//    OkHttpClient mOkHttpClientDemo2;

//
    @Inject
    UserManager mUserManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerUserComponent.create().inject(this);

//        Log.d("MainActivity", "mOkHttpClientDemo1:" + mOkHttpClientDemo1);
//        Log.d("MainActivity", "mOkHttpClientDemo2:" + mOkHttpClientDemo2);
//        DaggerUserComponent.builder().httpModule(new HttpModule())
//                .userModule(new UserModule())
//                .build().inject(this);
        mUserManager.register();
//
       // mApiServer.register();
    }
}
