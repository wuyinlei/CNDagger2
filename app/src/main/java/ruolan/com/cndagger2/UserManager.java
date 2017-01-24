package ruolan.com.cndagger2;


import android.util.Log;

public class UserManager {

    private ApiServer mApiServer;
    private UserStore mUserStore;
//
    public UserManager(ApiServer apiServer) {
        Log.d("UserManager", "UserManager");

        mApiServer = apiServer;
//        mUserStore = new UserStore();
    }

    public void register(){
        mApiServer.register();
//        mUserStore.register();
    }


}
