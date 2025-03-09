import java.util.*;

public class Main {
    public static void main(String[] args){
        String literal01 = "string";
        String literal02 = "ing";

        /* 同じ文字列で同じ参照のため、trueと判定される */
        System.out.println(literal01 == "string");

        /* コンパイル時の時点で"string"となるためtrue判定される */
        System.out.println(literal01 == ("str"+"ing"));

        /* 文字列結合によって新しいオブジェクトへの参照となってしまうために、false判定される */
        System.out.println(literal01 == ("str" + literal02));
    }
}
