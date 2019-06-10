package debug;


import android.util.Log;

import com.winmu.librarycommon.base.BaseApplication;
import com.winmu.librarycommon.http.HttpClient;
import com.winmu.librarycommon.http.OnResultListener;

public class MainApplication extends BaseApplication {
    private final static String TAG = "MainApplication";
    @Override
    public void onCreate() {
        super.onCreate();
        login();
    }

    /**
     * 在这里模拟登陆，然后拿到sessionId或者Token
     * 这样就能够在组件请求接口了
     */
    private void login() {
        HttpClient client = new HttpClient.Builder()
                .baseUrl("http://gank.io/api/data/")
                .url("福利/10/1")
                .build();
        client.get(new OnResultListener<String>() {

            @Override
            public void onSuccess(String result) {
                Log.i(TAG, "onSuccess: ");
            }

            @Override
            public void onError(int code, String message) {
                Log.i(TAG, "onError: ");
            }

            @Override
            public void onFailure(String message) {
                Log.i(TAG, "onFailure: ");
            }
        });
    }
}
