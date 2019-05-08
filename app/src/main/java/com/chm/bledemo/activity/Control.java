package com.chm.bledemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.chm.bledemo.R;
import com.chm.bledemo.bleutils.BleController;
import com.chm.bledemo.bleutils.callback.OnReceiverCallback;
import com.chm.bledemo.bleutils.callback.OnWriteCallback;
import com.chm.bledemo.utils.HexUtil;

public class Control extends AppCompatActivity {

    private static final String TAG = "ControlActivity";
    private BleController mBleController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);


        //获得实例
        mBleController = BleController.getInstance();

        // TODO 接收数据的监听
        mBleController.RegistReciveListener(TAG, new OnReceiverCallback() {
            @Override
            public void onReceiver(byte[] value) {
            }
        });
    }


    public void fleft(View view) {
        String mes = "aa010d";
        Write(mes);

    }

    public void fright(View view) {
        String mes = "AA020d";
        Write(mes);
    }

    public void mleft(View view) {
        String mes = "AA030d";
        Write(mes);
    }

    public void mright(View view) {
        String mes = "AA040d";
        Write(mes);
    }

    public void sleft(View view) {
        String mes = "AA050d";
        Write(mes);
    }

    public void sright(View view) {
        String mes = "AA060d";
        Write(mes);
    }
    public void Write(String value){
        mBleController.WriteBuffer(value, new OnWriteCallback() {
            @Override
            public void onSuccess() {
                Toast.makeText(Control.this, "ok", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailed(int state) {
                Toast.makeText(Control.this, "fail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
