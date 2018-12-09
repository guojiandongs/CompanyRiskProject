package com.example.administrator.riskprojects.activity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;
import com.example.administrator.riskprojects.R;

public class SocketActivity extends Activity implements OnClickListener {

    private EditText mIPEdt, mPortEdt, mSocketIDEdt, mMessageEdt;
    private TextView mConsoleTxt;

    private StringBuffer mConsoleStr = new StringBuffer();
    private Socket mSocket;
    private boolean isStartRecieveMsg;

    private SocketHandler mHandler;
    protected BufferedReader mReader;
    protected BufferedWriter mWriter;
    private Handler handler=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.socket_main);
        handler=new Handler();
        initView();
    }

    private void initView() {
        mIPEdt = (EditText) findViewById(R.id.ip_edt);
        mPortEdt = (EditText) findViewById(R.id.port_edt);
        mSocketIDEdt = (EditText) findViewById(R.id.socket_id_edt);
        mMessageEdt = (EditText) findViewById(R.id.msg_edt);
        mConsoleTxt = (TextView) findViewById(R.id.console_txt);
        findViewById(R.id.start_btn).setOnClickListener(this);
        findViewById(R.id.send_btn).setOnClickListener(this);
        findViewById(R.id.clear_btn).setOnClickListener(this);
        mHandler = new SocketHandler();
    }

    private void initSocket() {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                String ip = mIPEdt.getText().toString();
                int port = Integer.parseInt(mPortEdt.getText().toString());

                try {
                    isStartRecieveMsg = true;
                    mSocket = new Socket(ip, port);
                    System.out.print("mSocket============="+mSocket+"ip======="+ip+"port======="+port);
                    mReader = new BufferedReader(new InputStreamReader(mSocket.getInputStream(), "utf-8"));
                    mWriter = new BufferedWriter(new OutputStreamWriter(mSocket.getOutputStream(), "utf-8"));
                    while(isStartRecieveMsg) {
                        if(mReader.ready()) {
                            mHandler.obtainMessage(0, mReader.readLine()).sendToTarget();
                        }
                        Thread.sleep(200);
                    }
                    mWriter.close();
                    mReader.close();
                    mSocket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_btn:
                send();
                break;
            case R.id.clear_btn:
                mConsoleStr.delete(0, mConsoleStr.length());
                mConsoleTxt.setText(mConsoleStr.toString());
                break;
            case R.id.start_btn:
                if(!isStartRecieveMsg) {
                    initSocket();
                }
                break;
            default:
                break;
        }
    }

    private void send() {
        new AsyncTask<String, Integer, String>() {

            @Override
            protected String doInBackground(String... params) {
                sendMsg();
                return null;
            }
        }.execute();
    }

    protected void sendMsg() {
        try {
            String socketID = mSocketIDEdt.getText().toString().trim();
            String msg = mMessageEdt.getText().toString().trim();
            JSONObject json = new JSONObject();
            json.put("to", socketID);
            json.put("msg", msg);
            System.out.println("启动server,端口："+mWriter);
            System.out.println("启动server,端口："+json);
            mWriter.write(json.toString()+"\n");
            mWriter.flush();
            mConsoleStr.append("我:" +msg+"   "+getTime(System.currentTimeMillis())+"\n");
            handler.post(runable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class SocketHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    try {
                        JSONObject json = new JSONObject((String)msg.obj);
                        mConsoleStr.append(json.getString("from")+":" +json.getString("msg")+"   "+getTime(System.currentTimeMillis())+"\n");
                        mConsoleTxt.setText(mConsoleStr);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;

                default:
                    break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        isStartRecieveMsg = false;
    }

    private String getTime(long millTime) {
        Date d = new Date(millTime);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(d));
        return sdf.format(d);
    }

    Runnable runable = new Runnable(){
        @Override
        public void run() {
            mConsoleTxt.setText(mConsoleStr);
        }
    };




}
