package reactive;

import io.reactivex.rxjava3.core.Observable;

public class MaybeObservable {

  public static void main(String[] args) throws InterruptedException {
    Observable<String> source = Observable.just("Java", "Spring");
    Observable<String> source1 = Observable.empty();

    source1
        .firstElement()
        .subscribe(System.out::println, e -> e.printStackTrace(),
            () -> System.out.println("completed"));

  }
}
