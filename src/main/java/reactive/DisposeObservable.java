package reactive;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.TimeUnit;

public class DisposeObservable {

  private static final CompositeDisposable COMPOSITE_DISPOSABLE = new CompositeDisposable();
  public static void main(String[] args) throws InterruptedException {
    @NonNull Observable<Long> source = Observable.interval(1, TimeUnit.SECONDS);

    Disposable d1 = source.subscribe(e -> System.out.println("Observable 1 : " + e));
    Disposable d2 = source.subscribe(e->System.out.println("Observable 2 : "+e));
    Thread.sleep(5000);
    COMPOSITE_DISPOSABLE.addAll(d1,d2);
    COMPOSITE_DISPOSABLE.dispose();
    Thread.sleep(10000);

  }
}
