package reactive;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.function.Consumer;

public class SingleScheduler {

  static Consumer<String> consumer = s -> System.out
      .println("Data :" + s + "Thread Name : " + Thread.currentThread().getName());

  public static void main(String[] args) throws InterruptedException {
    Observable<String> source = Observable.just("java", "Spring", "Sql")
        .subscribeOn(Schedulers.single());
    source.subscribe(s -> task());
    source.subscribe(s -> task());
    source.subscribe(s -> task());
    source.subscribe(s -> task());



    Thread.sleep(50000);
  }

  private static void task() throws InterruptedException {
    Thread.sleep(1000);
    System.out.println("Computation Done By : " + Thread.currentThread().getName());
  }
}
