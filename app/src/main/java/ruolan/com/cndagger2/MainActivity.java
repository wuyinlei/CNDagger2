package ruolan.com.cndagger2;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;
import javax.inject.Named;

import ruolan.com.cndagger2.ano.Debug;
import ruolan.com.cndagger2.ano.Release;

public class MainActivity extends AppCompatActivity {


    @Inject
    @Debug
    ApiServer mApiServerDebug;

    @Inject
    @Named("release")
    ApiServer mApiServerRelease;
//
//    @Inject
//    UserManager mUserManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        DaggerUserComponent.create().inject(this);
        DaggerUserComponent.builder().httpModule(new HttpModule())
                .userModule(new UserModule())
                .build().inject(this);
        //mUserManager.register();
//
       // mApiServer.register();
    }
}
