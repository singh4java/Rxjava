package reactive;

import io.reactivex.rxjava3.core.Observable;
import java.util.ArrayList;
import java.util.List;

public class ColdObservable {

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    Observable<Integer> source = Observable.fromIterable(list);
    source.subscribe(System.out::println);
    System.out.println("----------------");
    list = getData(list);
    source.subscribe(System.out::println);
  }

  private static List<Integer> getData(List<Integer> list) {
    list.add(4);
    return list;
  }
}
