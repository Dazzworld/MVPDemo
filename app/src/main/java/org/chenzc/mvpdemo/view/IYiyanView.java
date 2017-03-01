package org.chenzc.mvpdemo.view;

import org.chenzc.mvpdemo.model.entity.Yiyan;

/**
 * creator: czc
 * date: 2017/2/28
 * description:
 */

public interface IYiyanView {
    void showLoading();

    void showError();

    void showData(Yiyan yiyan);
}
