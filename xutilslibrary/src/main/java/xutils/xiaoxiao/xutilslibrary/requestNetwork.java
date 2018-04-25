package xutils.xiaoxiao.xutilslibrary;

import android.content.Context;
import android.os.Handler;

import org.xutils.common.Callback;
import org.xutils.http.HttpMethod;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;
import java.util.HashMap;

/**
 * @author Administrator
 * @date 2018/1/5
 */

public class requestNetwork {

    static CustomDialog customDialog;

    /**
     * 不带入任何参数以及头部进行请求
     *
     * @param mContext   当前Activity
     * @param url        请求地址
     * @param identifier 请求返回识别Key
     * @param method     请求类型get、post
     * @param callback   回调方法
     * @param isDialog   是否显示等待动画
     */
    public static void xutilsRequest(final Context mContext, String url, final String identifier, HttpMethod method, final MyHttpCallback callback, final boolean isDialog) {
        if (isDialog) {
            showDialog(mContext);
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                closeDialog();
            }
        }, 7000);
        RequestParams params = new RequestParams(url);
        params.setConnectTimeout(5000);
        x.http().request(method, params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                callback.onSuccess(result, identifier,mContext);
                closeDialog();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                callback.onError(ex.getMessage(), identifier,mContext);
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }


    /**
     * 不带头部请求进行请求
     *
     * @param mContext   当前Activity
     * @param url        请求地址
     * @param identifier 请求返回识别Key
     * @param method     请求类型get、post
     * @param map        params 传入参数值
     * @param callback   回调方法
     * @param isDialog   是否显示等待动画
     */
    public static void xutilsRequest(final Context mContext, String url, final String identifier, HttpMethod method, HashMap<String, Object> map, final MyHttpCallback callback, final boolean isDialog) {
        if (isDialog) {
            showDialog(mContext);
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                closeDialog();
            }
        }, 7000);
        RequestParams params = new RequestParams(url);
        params.setConnectTimeout(5000);
        if (map.size() > 0) {
            for (String key : map.keySet()) {
                Object value = map.get(key);
                if (value instanceof String) {
                    params.addBodyParameter(key, String.valueOf(value));
                } else {
                    params.addBodyParameter(key, (File) value);
                }
            }
        }
        x.http().request(method, params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                callback.onSuccess(result, identifier,mContext);
                closeDialog();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                callback.onError(ex.getMessage(), identifier,mContext);
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }


    /**
     * 只带头部，不带任何参数进行请求
     *
     * @param mContext       当前Activity
     * @param url            请求地址
     * @param identifier     请求返回识别Key
     * @param method         请求类型get、post
     * @param addHeaderState 是否带头部参数请求
     * @param addHeaderKey   头部Key
     * @param addHeaderValue 头部Key对应的Value
     * @param callback       回调方法
     * @param isDialog       是否显示等待动画
     */
    public static void xutilsRequest(final Context mContext, String url, final String identifier, HttpMethod method, final MyHttpCallback callback, final boolean isDialog, final boolean addHeaderState, final String addHeaderKey, final String addHeaderValue) {
        if (isDialog) {
            showDialog(mContext);
        }
        RequestParams params = new RequestParams(url);
        params.setConnectTimeout(5000);
        if (addHeaderState) {
            params.addHeader(addHeaderKey, addHeaderValue);
        }
        x.http().request(method, params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                callback.onSuccess(result, identifier,mContext);
                closeDialog();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                callback.onError(ex.getMessage(), identifier,mContext);
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                closeDialog();
            }
        }, 7000);
    }


    /**
     * 带头部，带参数进行请求
     *
     * @param mContext       当前Activity
     * @param url            请求地址
     * @param identifier     请求返回识别Key
     * @param method         请求类型get、post
     * @param map            params 传入参数值
     * @param addHeaderState 是否带头部参数请求
     * @param addHeaderKey   头部Key
     * @param addHeaderValue 头部Key对应的Value
     * @param callback       回调方法
     * @param isDialog       是否显示等待动画
     */
    public static void xutilsRequest(final Context mContext, String url, final String identifier, HttpMethod method, HashMap<String, Object> map, final MyHttpCallback callback, final boolean isDialog, final boolean addHeaderState, final String addHeaderKey, final String addHeaderValue) {
        if (isDialog) {
            showDialog(mContext);
        }
        RequestParams params = new RequestParams(url);
        params.setConnectTimeout(5000);
        if (map.size() > 0) {
            for (String key : map.keySet()) {
                Object value = map.get(key);
                if (value instanceof String) {
                    params.addBodyParameter(key, String.valueOf(value));
                } else {
                    params.addBodyParameter(key, (File) value);
                }
            }
        }
        if (addHeaderState) {
            params.addHeader(addHeaderKey, addHeaderValue);
        }
        x.http().request(method, params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                callback.onSuccess(result, identifier,mContext);
                closeDialog();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                callback.onError(ex.getMessage(), identifier,mContext);
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                closeDialog();
            }
        }, 7000);
    }

    public interface MyHttpCallback {
        void onSuccess(String result, String SuccessRequest,Context mContext);

        void onError(String errorMsg, String ErrorRequest,Context mContext);
    }

    /**
     * 开始转菊花提示框
     */
    public static void showDialog(Context mContext) {
        customDialog = new CustomDialog(mContext, "加载中…");
        customDialog.show();
    }

    /**
     * 结束转菊花提示框
     */
    public static void closeDialog() {
        if (customDialog != null && customDialog.isShowing()) {
            customDialog.dismiss();
            customDialog = null;
        }
    }
}
