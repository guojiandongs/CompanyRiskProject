package com.example.administrator.riskprojects;

import android.view.View;

/**
 * Created by Administrator on 10/13/17.
 */

public interface OnItemClickListener {

    void onItemClick(View view, int position, int flag);

    boolean onItemLongClick(View view, int position);
}
