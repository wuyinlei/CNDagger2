package ruolan.com.cndagger2;


public class UserManager {

    private ApiServer mApiServer;
    private UserStore mUserStore;

    public UserManager() {

        mApiServer = new ApiServer();
        mUserStore = new UserStore();
    }

    public void register(){
        mApiServer.register();
        mUserStore.register();
    }


}
