package reactive;

import io.reactivex.rxjava3.core.Observable;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

public class Buffering {

  public static void main(String[] args) throws InterruptedException {

    Observable.range(1,30)
        .buffer(9)
        .subscribe(System.out::println);
    System.out.println("------------");
    Observable.interval(500,TimeUnit.MILLISECONDS)
        .buffer(1,TimeUnit.SECONDS)
        .subscribe(System.out::println);
    Thread.sleep(8000);

  }

}
