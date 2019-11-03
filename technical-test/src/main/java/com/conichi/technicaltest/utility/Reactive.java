package com.conichi.technicaltest.utility;

import com.conichi.technicaltest.model.EnumCurrency;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Function;

public class Reactive<T, U> {

    private static Reactive SINGLE_INSTANCE = null;

    private Reactive() {
    }

    public static Reactive getInstance() {
        if (Objects.isNull(SINGLE_INSTANCE)) {
            synchronized (Reactive.class) {
                SINGLE_INSTANCE = new Reactive();
            }
        }
        return SINGLE_INSTANCE;
    }

    public void doSilently(Function<U, T> function) {
        BlockingQueue<EnumCurrency> list = new LinkedBlockingQueue<>(Arrays.asList(EnumCurrency.values()));
        Observable.create(emitter -> {
            list.forEach(emitter::onNext);
        }).observeOn(Schedulers.single()).subscribeOn(Schedulers.single()).subscribe((element -> function.apply((U) element)), Throwable::printStackTrace);
    }

}
