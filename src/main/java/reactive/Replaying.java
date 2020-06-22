package reactive;

import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

public class Replaying {

  public static void main(String[] args) throws InterruptedException {

    Observable<Long> observableReplay = Observable.interval(1, TimeUnit.SECONDS)
        .replay()
        .autoConnect();


    observableReplay.subscribe(e->System.out.println("Observer 1 :"+e));

    Thread.sleep(5000);

    observableReplay.subscribe(e->System.out.println("Observer 2 :"+e));

    Thread.sleep(3000);





  }

}
