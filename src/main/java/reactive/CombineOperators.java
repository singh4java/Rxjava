package reactive;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class CombineOperators {


  public static void main(String[] args) {

    Observable<Integer> source1 = Observable.just(1, 3, 6, 8);
    Observable<Integer> source2 = Observable.just(1, 2,4,5 ,7);
    //marge
    Observable.merge(source1,source2).subscribe(System.out::println);
    //concat
    System.out.println("-------------");
    Observable.concat(source1,source2).subscribe(System.out::println);



  }
}
