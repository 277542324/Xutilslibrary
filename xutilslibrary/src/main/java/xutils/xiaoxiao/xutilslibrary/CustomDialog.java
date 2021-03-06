package xutils.xiaoxiao.xutilslibrary;

import android.app.Dialog;
import android.content.Context;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.TextView;

/**
 *
 * @author Administrator
 * @date 2018/1/5
 */

public class CustomDialog extends Dialog {
    private String content;

    public CustomDialog(Context context, String content) {
        super(context, R.style.CustomDialog);
        this.content=content;
        initView();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_BACK:
                if(CustomDialog.this.isShowing()) {
                    CustomDialog.this.dismiss();
                }
                break;
            default:
                break;
        }
        return true;
    }

    private void initView(){
        setContentView(R.layout.dialog_view);
        ((TextView)findViewById(R.id.tvcontent)).setText(content);
        setCanceledOnTouchOutside(true);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha=0.9f;
        getWindow().setAttributes(attributes);
        getWindow().setWindowAnimations(R.style.AnimaCustomDialog);
        setCancelable(false);
    }
}
