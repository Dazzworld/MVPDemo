package org.chenzc.mvpdemo.model;

import android.os.Looper;
import android.util.Log;

import org.chenzc.mvpdemo.api.ApiUtils;
import org.chenzc.mvpdemo.api.YiyanApi;
import org.chenzc.mvpdemo.model.entity.Yiyan;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * creator: czc
 * date: 2017/2/28
 * description:
 */

public class YiyanModelImpl implements IYiyanModel {

    OnModelChangedListener listener;

    public YiyanModelImpl(OnModelChangedListener listener) {
        this.listener = listener;
    }

    @Override
    public void getYiyan() {
        YiyanApi yiyanApi = ApiUtils.getYiyanApi();
        Observable<Yiyan> yiyanObservable = yiyanApi.getYiyan();
        Log.d("thread", "-"+Thread.currentThread().getId());
        yiyanObservable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<Yiyan>() {
                    @Override
                    public void accept(Yiyan yiyan) throws Exception {
                        Log.d("thread(subj)", "-"+Thread.currentThread().getId());
                        listener.OnSucessed(yiyan);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        listener.onFailed();
                    }
                });

    }
}
