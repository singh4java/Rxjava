package reactive;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class CollectionOperators {

  private static final CompositeDisposable COMPOSITE_DISPOSABLE = new CompositeDisposable();

  public static void main(String[] args) throws InterruptedException {
    //toList
    Observable.just(1,7,8,4,6,9).toList().subscribe(list -> list.stream().forEach(System.out::println));
    //toSortedList
    System.out.println("-------------");
    Observable.just(1,7,8,4,6,9).toSortedList().subscribe(list -> list.stream().forEach(System.out::println));
    //toMap
    System.out.println("-------------");
    Observable.just(1,7,8,4,6,9).toMap(integer -> integer).subscribe((integerIntegerMap, throwable) -> {System.out.println(integerIntegerMap);});




  }
}
