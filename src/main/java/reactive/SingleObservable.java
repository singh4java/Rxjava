package reactive;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import java.util.concurrent.TimeUnit;

public class SingleObservable {

  public static void main(String[] args) throws InterruptedException {
    Observable<String> source = Observable.just("Java","Spring");

    source.first("Name")
        .subscribe(System.out::println);
    Single.just("Spring Boot")
        .subscribe(System.out::println);

  }
}
