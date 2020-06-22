package reactive;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;

public class CompletableObservable {

  public static void main(String[] args) throws InterruptedException {
    Observable<String> source = Observable.just("Java", "Spring");

    Completable completable = Completable.complete();
    completable.subscribe(() -> System.out.println("Completed"));
    Completable.fromRunnable(() -> System.out.println("from Runnable "))
        .subscribe(() -> System.out.println("The Process Completed"));

  }
}
