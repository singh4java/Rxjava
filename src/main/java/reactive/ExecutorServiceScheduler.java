package reactive;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;


public class ExecutorServiceScheduler {

  static Consumer<String> consumer = s -> System.out
      .println("Data :" + s + "Thread Name : " + Thread.currentThread().getName());

  public static void main(String[] args) throws InterruptedException {

    ExecutorService executorService = Executors.newFixedThreadPool(4);
    executorService.execute(()->{
      System.out.println("Async call");
    });

    Observable<String> source = Observable.just("java", "Spring", "Sql")
        .subscribeOn(Schedulers.from(executorService))
        .doFinally(executorService::shutdown);
    source.subscribe(s -> task(s));
    source.subscribe(s -> task(s));
    source.subscribe(s -> task(s));
    source.subscribe(s -> task(s));

  }

  private static void task(String s) throws InterruptedException {
    Thread.sleep(1000);
    System.out.println("Data : "+s+" Computation Done By : " + Thread.currentThread().getName());
  }
}
