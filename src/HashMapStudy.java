import java.util.HashMap;

public class HashMapStudy {
    public static void main(String[] args){
        //创建HashMap
        HashMap<Integer, String> Sites = new HashMap<Integer, String>();
        //添加键值对
        Sites.put(1, "11");
        Sites.put(2, "22");
        Sites.put(3, "33");
        System.out.println(Sites);
        System.out.println(Sites.size());
        for(Integer i : Sites.keySet()){
            System.out.println("key: " + i + " value: " + Sites.get(i));
        }

        for(String values : Sites.values()){
            System.out.println(values + " ");
        }
    }
}
