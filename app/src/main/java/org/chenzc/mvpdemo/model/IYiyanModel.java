package org.chenzc.mvpdemo.model;

import org.chenzc.mvpdemo.model.entity.Yiyan;

/**
 * creator: czc
 * date: 2017/2/28
 * description:
 */

public interface IYiyanModel {
    void getYiyan();

    interface OnModelChangedListener{
        void OnSucessed(Yiyan yiyan);
        void onFailed();
    }
}
