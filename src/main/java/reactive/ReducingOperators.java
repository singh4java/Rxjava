package reactive;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class ReducingOperators {

  private static final CompositeDisposable COMPOSITE_DISPOSABLE = new CompositeDisposable();

  public static void main(String[] args) throws InterruptedException {
    //count
    Observable.just(1,7,8,4).count().subscribe(System.out::println);
    //reduce
    System.out.println("-----------");
    Observable.just(7,5,4,1).reduce(Integer::sum).subscribe(System.out::println);
    // contains
    System.out.println("---------------");
    Observable.just(7,9,4).contains(9).subscribe(System.out::println);
    // all
    System.out.println("--------------");
    Observable.just(8,5,3).all(i->i>2).subscribe(System.out::println);
    // any
    System.out.println("--------------");
    Observable.just(8,5,3).any(i->i%2==0).subscribe(System.out::println);



  }
}
