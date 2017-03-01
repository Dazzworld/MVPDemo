package org.chenzc.mvpdemo.presenter;

import org.chenzc.mvpdemo.model.IYiyanModel;
import org.chenzc.mvpdemo.model.YiyanModelImpl;
import org.chenzc.mvpdemo.model.entity.Yiyan;
import org.chenzc.mvpdemo.view.IYiyanView;

/**
 * creator: czc
 * date: 2017/2/28
 * description:
 */

public class YiyanPresenterImpl implements IYiyanPresenter,IYiyanModel.OnModelChangedListener {
    IYiyanView yiyanView;
    IYiyanModel iYiyanModel;

    public YiyanPresenterImpl(IYiyanView yiyanView) {
        this.yiyanView = yiyanView;
        iYiyanModel = new YiyanModelImpl(this);
    }

    @Override
    public void getYiyan() {
        iYiyanModel.getYiyan();
    }

    @Override
    public void OnSucessed(Yiyan data) {
        yiyanView.showData(data);
    }

    @Override
    public void onFailed() {
        yiyanView.showError();
    }
}
