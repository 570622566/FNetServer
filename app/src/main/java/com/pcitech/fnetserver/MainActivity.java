package com.pcitech.fnetserver;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import cn.hotapk.fastandrutils.utils.FFileUtils;
import cn.hotapk.fastandrutils.utils.FLogUtils;
import cn.hotapk.fhttpserver.FHttpManager;

import cn.hotapk.fastandrutils.utils.FNetworkUtils;
import cn.hotapk.fastandrutils.utils.FPermissionUtils;

public class MainActivity extends AppCompatActivity {
    private TextView assets_tv;
    FHttpManager fHttpManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assets_tv = findViewById(R.id.assets_tv);

        fHttpManager = FHttpManager.init(this, UserController.class, AppController.class);
        try {
            fHttpManager.setResdir(FFileUtils.getRootDir()+"/apk98.com");
            fHttpManager.setFilterName(".log");
        } catch (Exception e) {

        }
        FPermissionUtils.requestPermissions(this, 200, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, new FPermissionUtils.OnPermissionListener() {
            @Override
            public void onPermissionGranted() {
//                String a="";
//                StringBuffer sb = new StringBuffer();
//                List<String> list = FAssetsUtils.getAssetsLs("");
//                for (int i = 0; i < list.size(); i++) {
//                    sb.append(list.get(i) + "\n");
//                    if (list.get(i).endsWith("test.txt")){
//                       a= FAssetsUtils.getAssetsToString(list.get(i));
//                    }
//                }
//                assets_tv.setText(sb.toString()+a);
                FLogUtils.getInstance().e(FFileUtils.getRootDir());
                FHttpManager.getfHttpManager().setPort(9999);
                assets_tv.setText("内网打开：http://" + FNetworkUtils.getIPAddress(true) + ":" + FHttpManager.getfHttpManager().getPort());
                FHttpManager.getfHttpManager().startServer();
//                try {
//                    new FNetServer(8888).start();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            }

            @Override
            public void onPermissionDenied(String[] deniedPermissions) {

            }

            @Override
            public void manifestUnPermission(String[] unpermission) {

            }
        });


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        FPermissionUtils.onRequestPermissionsResult(this, requestCode, permissions, grantResults);

    }

}
