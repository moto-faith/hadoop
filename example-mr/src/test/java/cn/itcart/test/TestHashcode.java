package cn.itcart.test;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 10640
 * Date: 2018-11-04
 * Time: 13:10
 */
public class TestHashcode {
    public static void main(String[] args) {
        String a = "1346662255";
        String b = "13455662266";
        System.out.println((a.hashCode() & Integer.MAX_VALUE) % 3);
        System.out.println((b.hashCode() & Integer.MAX_VALUE) % 3);

    }
}
