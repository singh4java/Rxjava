package reactive;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class Subjects {

  public static void main(String[] args) throws InterruptedException {

    Observable<String> src1 = Observable.just("Java", "MongoDB", "Redis")
        .subscribeOn(Schedulers.newThread());
    Observable<String> src2 = Observable.just("Micro", "OpenShift", "Db2")
        .subscribeOn(Schedulers.newThread());

    //src1.subscribe(o -> System.out.println(o));
    //src2.subscribe(o -> System.out.println(o));

    Subject<Object> subject = PublishSubject.create();

    subject.subscribe(o -> System.out.println(o+" : "+Thread.currentThread().getName()));
    src1.subscribe(subject);
    src2.subscribe(subject);

    Thread.sleep(3000);

  }

}
