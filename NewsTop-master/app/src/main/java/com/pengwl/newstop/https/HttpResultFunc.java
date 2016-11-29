package com.pengwl.newstop.https;

/**
 * Created by Administrator on 2016/11/25 0025.
 */

import com.pengwl.newstop.entry.HttpResult;
import com.pengwl.newstop.https.Exception.ApiException;

import rx.functions.Func1;

/**
 * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
 *
 * @param <T>   Subscriber真正需要的数据类型，也就是Data部分的数据类型
 */
public class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {

    @Override
    public T call(HttpResult<T> httpResult) {
        if (httpResult.getCount() == 0) {
            throw new ApiException(100);
        }
        return httpResult.getSubjects();
    }
}
