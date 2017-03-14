package tasks.p90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Tex {
  public static void main(String[] argv) throws Exception {
      
      List<A> aasss = new ArrayList<>();
      A a = new A("1");
      List<A> as = new ArrayList<>();
      as.add(new A("2"));
      as.add(new A("3"));
      a.list = as;
      
      aasss.add(a);
      a = new A("11");
      as = new ArrayList<>();
      as.add(new A("12"));
      as.add(new A("13"));
      a.list = as;
      
      aasss.add(a);
      Stream<A> c = aasss.stream().map(A::getList)
              .flatMap(List::stream);
      
      Stream.concat(aasss.stream(), c).forEach(assd -> System.out.println(assd.name));
  }
}

class A {
    
    List<A> list;
    
    String name;
    
    public A(String aa) {
        list = new ArrayList();
        name = aa;
    }
    
    List<A> getList() {
        return list;
    }
}
