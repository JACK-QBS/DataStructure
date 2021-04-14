package MapUse;

import java.util.Map;
import java.util.TreeMap;

public class MapDemo {
    public static void main(String[] args) {
        /*Map<String,Integer> con = new TreeMap<>();

        Integer v = con.put("qbs",666);
        System.out.println(v);
        System.out.println(con);
        v = con.put("qbs",999);

        System.out.println(con.get("qbs"));

        System.out.println(con.remove("gg"));
        System.out.println(con.remove("qbs"));
        System.out.println(con);*/

        myTreeMap con = new myTreeMap();
        Integer v = con.put("qbs",666);
        System.out.println(v);
        System.out.println(con);
        v = con.put("qbs",999);
    }
}
