package xutils.xiaoxiao.xutilslibrary.Application;

import android.app.Application;

import org.xutils.x;

/**
 *
 * @author Administrator
 * @date 2018/1/5
 */

public class XutlisLibDataApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
