package reactive;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.function.Consumer;

public class IOScheduler {

  static Consumer<String> consumer = s -> System.out
      .println("Data :" + s + "Thread Name : " + Thread.currentThread().getName());

  public static void main(String[] args) throws InterruptedException {
    Observable<String> source = Observable.just("java", "Spring", "Sql")
        .subscribeOn(Schedulers.io());
    source.subscribe(s -> ioCompute());
    source.subscribe(s -> ioCompute());
    source.subscribe(s -> ioCompute());
    source.subscribe(s -> ioCompute());



    Thread.sleep(50000);
  }

  private static void ioCompute() throws InterruptedException {
    Thread.sleep(1000);
    System.out.println("Computation Done By : " + Thread.currentThread().getName());
  }
}
