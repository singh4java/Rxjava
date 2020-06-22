package reactive;

import io.reactivex.rxjava3.core.Observable;
import java.util.Arrays;
import java.util.List;

public class CreatingObservable {

  public static void main(String[] args) {
    Observable<Integer> source = Observable.create(
        emitter -> {
          emitter.onNext(10);
          emitter.onNext(11);
          emitter.onNext(12);
          emitter.onComplete();
        }
    );

    source.subscribe(integer -> System.out.println(integer));

    // Just()
    Observable<Integer> just = Observable.just(1, 2, 3);
    just.subscribe(integer -> System.out.println(integer));

    // formIterable
    List<Integer> list = Arrays
        .asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19);
    Observable<Integer> fromIterable = Observable.fromIterable(list);
    fromIterable.subscribe(System.out::println);

    //range
    Observable.range(1,5).subscribe(System.out::println);


  }
}
