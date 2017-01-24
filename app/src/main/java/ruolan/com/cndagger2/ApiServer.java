package ruolan.com.cndagger2;


import android.util.Log;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ApiServer {

    private static final MediaType JSON = MediaType.parse("applicaption/json; charset=utf-8");
    OkHttpClient mOkHttpClient;

    @Inject
    public ApiServer(OkHttpClient okHttpClient) {
        Log.d("ApiServer", "构造方法");
        mOkHttpClient = okHttpClient;
    }


    public void register() {
        Log.d("ApiServer", "绑定成功");

        //云端保存数据
        Log.d("ApiServer", "mOkHttpClient:" + mOkHttpClient);

//        RequestBody requestBody = RequestBody.create(JSON,"");
//        Request request = new Request.Builder()
//                .url("")
//                .post(requestBody)
//                .build();
//
//        mOkHttpClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//
//            }
//        });
    }
}
