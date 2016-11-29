package com.pengwl.newstop.appaction;

import com.pengwl.newstop.entry.Subject;
import com.pengwl.newstop.https.HttpMethods;
import com.pengwl.newstop.https.HttpResultFunc;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by pengwl on 2016/11/25 0025.
 */

public class AppAction {
    public static HttpMethods mHttpMethods;

    public AppAction() {
        mHttpMethods = HttpMethods.getInstance();
    }

    /**
     * 用于获取豆瓣电影Top250的数据
     * @param subscriber  由调用者传过来的观察者对象
     * @param start 起始位置
     * @param count 获取长度
     */
    public void getTopMovie(Subscriber<List<Subject>> subscriber, int start, int count){

        Observable observable = HttpMethods.mHttpService.getTopMovie(start, count)
                .map(new HttpResultFunc<List<Subject>>());

        toSubscribe(observable, subscriber);
    }

    private <T> void toSubscribe(Observable<T> o, Subscriber<T> s){
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }

}
