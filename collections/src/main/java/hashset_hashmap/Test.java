package hashset_hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by barin.huseyin on 2/5/2016.
 */
public class Test {


    Set<Employee> employeeSet;
    HashMap<Integer, Employee> employeeHashMap;


    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }


    public Test() {


        Employee emp1 = new Employee("ali");
        Employee emp2 = new Employee("ali");


        emp2.setNum(2);
        emp1.setNum(1);


        System.out.println(String.format("Hashcode of %s:%d", emp1.getName(), hash(emp1)));
        System.out.println(String.format("Hashcode of %s:%d", emp2.getName(), hash(emp2)));


        employeeSet = new HashSet<>();
        employeeHashMap = new HashMap<>();


        employeeSet.add(emp2);
        employeeSet.add(emp1);


        employeeHashMap.put(1, emp1);
        employeeHashMap.put(2, emp2);


        System.out.println("Size of set:" + employeeSet.size());
        System.out.println("Size of hashmap:" + employeeHashMap.size());


        Iterator<Employee> iterator = employeeSet.iterator();
        while (iterator.hasNext()) {

            Employee emp = iterator.next();
            System.out.println("Emp I am worried:" + emp.getNum());
        }


    }


    public static void main(String[] args) {
        new Test();
    }

}
