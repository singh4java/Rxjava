package reactive;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import java.util.concurrent.TimeUnit;

public class TransformingOperators {

  private static final CompositeDisposable COMPOSITE_DISPOSABLE = new CompositeDisposable();

  public static void main(String[] args) throws InterruptedException {
    @NonNull Observable<String> source = Observable
        .just("java spring", "spring", " spring boot", "web");

    // map
    source.map(s -> s.toUpperCase()).subscribe(System.out::println);
    //cast
    System.out.println("---------------");
    //Observable.just(1.0, 3.0, 5.0, 7.0).cast(Integer.class).subscribe(System.out::println);
    //Delay
    source.delay(1, TimeUnit.SECONDS).subscribe(System.out::println);
    Thread.sleep(5000);
    // scan
    System.out.println("------------");
    Observable.just(1,2,3).scan((i1, i2) -> i1*i2).subscribe(System.out::println);
    // sorted
    System.out.println("--------------");
    Observable.just(9,4,7,2,6).sorted().subscribe(System.out::println);


  }
}
