package org.chenzc.mvpdemo.ui.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.chenzc.mvpdemo.R;
import org.chenzc.mvpdemo.model.entity.Yiyan;
import org.chenzc.mvpdemo.presenter.IYiyanPresenter;
import org.chenzc.mvpdemo.presenter.YiyanPresenterImpl;
import org.chenzc.mvpdemo.view.IYiyanView;

public class MainActivity extends AppCompatActivity implements IYiyanView {

    IYiyanPresenter yiyanPresenter;

    TextView mTvYiyan;
    Button mBtnGet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yiyanPresenter = new YiyanPresenterImpl(this);
        mTvYiyan = (TextView) findViewById(R.id.tv_yiyan);
        mBtnGet = (Button) findViewById(R.id.btn_get);
        mBtnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yiyanPresenter.getYiyan();
            }
        });
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError() {
        mTvYiyan.setText("Error");
    }

    @Override
    public void showData(Yiyan yiyan) {
        mTvYiyan.setText(yiyan.getHitokoto()+"\nfrom "+yiyan.getSource());
    }
}
