package reactive;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HotObservable {

  public static void main(String[] args) throws InterruptedException {
    Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);
    ConnectableObservable<Long> publish = source.publish();
    publish.connect();
    publish.subscribe(System.out::println);
    Thread.sleep(10000);
    publish.subscribe(System.out::println);
    Thread.sleep(10000);
  }
}
