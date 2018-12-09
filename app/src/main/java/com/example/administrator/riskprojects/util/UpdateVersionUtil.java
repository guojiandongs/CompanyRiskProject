package com.example.administrator.riskprojects.util;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.administrator.riskprojects.net.BaseJsonRes;
import com.example.administrator.riskprojects.net.NetClient;
import com.example.administrator.riskprojects.tools.Constants;
import com.example.administrator.riskprojects.tools.Utils;
import com.juns.health.net.loopj.android.http.RequestParams;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.HttpHandler;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;


import java.io.File;

/**
 * Create by guo on 2016/12/14 0014 11:20
 */
public class UpdateVersionUtil {
    private static final String TAG = "UpdateVersionUtil";
    private ProgressDialog progressDialog;
    private HttpHandler<File> handler;
    private Context context;
    private String is_qiangzhi = "1";//1:强制
    private String uid;
    private int flag;

    public void versionUpdata(final Context context, final boolean toastshow) {
        this.context = context;
        progressDialog = new ProgressDialog(context, ProgressDialog.THEME_HOLO_LIGHT);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("版本更新中");
        progressDialog.setMax(100);
        progressDialog.setCancelable(false);
        progressDialog.setButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (is_qiangzhi.equals("1")) {
                    System.exit(1);
                } else {
                    handler.cancel();
                    into(context);
                }
            }
        });

        //上传版本号，对比后进行更新

        RequestParams params = new RequestParams();
        NetClient netClient = new NetClient(context);
        final String version = AppUtils.getVersionName(context);
        /*netClient.post(Data.getInstance().getIp()+Constants.UPDATE_VERSION, params, new BaseJsonRes() {

            @Override
            public void onMySuccess(String data) {
                if (!TextUtils.isEmpty(data)) {
                    JSONObject returndata  = JSON.parseObject(data);
                    String oldversion = returndata.getString("version");
                    Log.e(TAG, "oldversion旧版本================= "+oldversion);
                    Log.e(TAG, "oldversion新版本================= "+version);
                    if(version.equals(oldversion)){
                        Utils.showShortToast(context, "已经是最新版本，不需要更新！");
                    }else{
                        String newVersionPath = returndata.getString("newVersionPath");
                        showUpdateDialog(newVersionPath, "1");
                    }
                }

            }

            @Override
            public void onMyFailure(String content) {
            }
        });*/
        //        new EditionJson(new AsyCallBack<EditionBean>() {
//            @Override
//            public void onStart(int type) throws Exception {
//                super.onStart(type);
//            }
//
//            @Override
//            public void onSuccess(String toast, int type, final EditionBean editionBean) throws Exception {
//                super.onSuccess(toast, type, editionBean);
//                if (editionBean != null) {
//                    is_qiangzhi = editionBean.getTypes();
//                    showUpdateDialog(editionBean.getUrl(), is_qiangzhi);
//                }
//
//            }
//
//            @Override
//            public void onFail(String toast, int type) throws Exception {
//                super.onFail(toast, type);
//                Toast.makeText(context, toast, Toast.LENGTH_SHORT).show();
//                into(context);
//            }
//
//            @Override
//            public void onEnd(String toast, int type) throws Exception {
//                super.onEnd(toast, type);
//            }
//        }, Integer.toString(UtilApp.versionCode()), "1").execute(toastshow);
    }

    private void showUpdateDialog(final String updateurl, final String is_qiangzhi) {
        // 弹出对话框提示用户是否更新新版本
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("有可更新的版本");
        builder.setMessage("快点击下载啦");
        builder.setCancelable(false);
        builder.setPositiveButton("立即下载", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 使用apkurl下载apk文件,然后自动安装
                final HttpUtils http = new HttpUtils();
                handler = http.download(updateurl, Environment.getExternalStorageDirectory()
                        + "/update.apk", new RequestCallBack<File>() {
                    /**
                     * 开始下载时调用这个方法
                     */
                    @Override
                    public void onStart() {
                        super.onStart();
                        progressDialog.show();
                    }

                    /**
                     * 在下载的过程中调用这个方法
                     */
                    @Override
                    public void onLoading(long total, long current,
                                          boolean isUploading) {

                        super.onLoading(total, current, isUploading);
                        // 显示下载进度
                        int progress = (int) (current * 100 / total);
                        progressDialog.setProgress(progress);
                    }

                    /**
                     * 下载成功后调用这个方法
                     */
                    @Override
                    public void onSuccess(ResponseInfo<File> responseInfo) {
                        progressDialog.dismiss();
                        // 下载成功后,得到下载后的文件,然后安装
                        // 下载后的文件对象
                        File file = responseInfo.result;
                        // 安装apk文件
                        // 安装apk文件
                        AppUtils.installApp(context, file);
                    }

                    /**
                     * 下载失败后调用这个方法
                     */
                    @Override
                    public void onFailure(HttpException error, String msg) {
                        progressDialog.dismiss();
                        error.printStackTrace();
                        Toast.makeText(context, "下载失败", Toast.LENGTH_SHORT).show();
                        // 进入主界面
                        if (is_qiangzhi.equals("1")) {
                            System.exit(0);
                        } else {
                            into(context);
                        }
                    }
                });
            }
        });
        /*builder.setNegativeButton("以后再说", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 使用apkurl下载apk文件,然后自动安装
                if (is_qiangzhi.equals("1")) {
                    System.exit(1);
                } else {
                    into(context);
                }

            }
        });*/
        builder.create().show();
    }

    private static void into(Context context) {

    }


}
