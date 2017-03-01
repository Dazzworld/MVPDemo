package org.chenzc.mvpdemo.api;

import org.chenzc.mvpdemo.model.entity.Yiyan;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * creator: czc
 * date: 2017/3/1
 * description:
 */

public interface YiyanApi {

    @GET("rand")
    Observable<Yiyan> getYiyan();
}
