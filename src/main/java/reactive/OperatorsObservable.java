package reactive;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class OperatorsObservable {

  private static final CompositeDisposable COMPOSITE_DISPOSABLE = new CompositeDisposable();

  public static void main(String[] args) throws InterruptedException {
    @NonNull Observable<String> source = Observable.just("java spring", "spring", " spring boot", "web");
    source.filter(s -> s.contains("spring")).subscribe(System.out::println);

    @NonNull Observable<Integer> source1 = Observable.range(1,100);
    source1.filter(s -> s%2==1).subscribe(System.out::println);


  }
}
