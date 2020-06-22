package reactive;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class SuppressingOperators {

  private static final CompositeDisposable COMPOSITE_DISPOSABLE = new CompositeDisposable();

  public static void main(String[] args) throws InterruptedException {
    @NonNull Observable<String> source = Observable.just("java spring", "spring", " spring boot", "web");
    source.filter(s -> s.contains("spring")).subscribe(System.out::println);

    // filter
    @NonNull Observable<Integer> source1 = Observable.range(1,30);
    source1.filter(s -> s%2==1).subscribe(System.out::println);
    // take
    System.out.println("-------------------");
    source1.take(20).subscribe(System.out::println);
    // Skip
    System.out.println("-------------------");
    source1.skip(10).subscribe(System.out::println);
    // distinct
    System.out.println("---------------");
    Observable.just(1,4,7,2,4,5).distinct().subscribe(System.out::println);
    // elementAt
    System.out.println("-----------------");
    Observable.just(1,4,7,2,4,5).elementAt(3).subscribe(System.out::println);




  }
}
