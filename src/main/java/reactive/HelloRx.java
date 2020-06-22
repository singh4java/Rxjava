package reactive;

import io.reactivex.rxjava3.core.Observable;
import java.time.LocalDateTime;

public class HelloRx {

  public static void main(String[] args) {
    Observable<String> source = Observable.create(
        e -> {
          e.onNext("Hello");
          e.onNext("Hello Java");
          e.onNext("Hello Rx");
        }
    );
    source.subscribe(e -> System.out.println("Observer 1 : " + e+" Thread name :"+Thread.currentThread().getName()));
    source.subscribe(s -> System.out
        .println("Observer 2 : " + s.concat(" " + LocalDateTime.now().toString()).toUpperCase()+" Thread name :"+Thread.currentThread().getName()));

    System.out.println("CPU core : "+Runtime.getRuntime().availableProcessors());

  }

}
