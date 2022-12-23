package by.it.group151002.saprin.lesson07;

import by.it.group151002.saprin.lesson07.A_EditDist;
import by.it.group151002.saprin.lesson07.B_EditDist;
import by.it.group151002.saprin.lesson07.C_EditDist;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Lesson7Test {
    @Test
    public void A() throws Exception {
        by.it.group151002.saprin.lesson07.A_EditDist instance = new A_EditDist();
        assertEquals("A1 failed", instance.getDistanceEdinting("ab","ab"),0);
        assertEquals("A2 failed", instance.getDistanceEdinting("short","ports"),3);
        assertEquals("A3 failed", instance.getDistanceEdinting("distance","editing"),5);
    }


    @Test
    public void B() throws Exception {
        by.it.group151002.saprin.lesson07.B_EditDist instance = new B_EditDist();
        assertEquals("B1 failed", instance.getDistanceEdinting("ab","ab"),0);
        assertEquals("B2 failed", instance.getDistanceEdinting("short","ports"),3);
        assertEquals("B3 failed", instance.getDistanceEdinting("distance","editing"),5);
    }

    @Test
    public void C() throws Exception {
        by.it.group151002.saprin.lesson07.C_EditDist instance = new C_EditDist();
        assertEquals("C1 failed", instance.getDistanceEditing("ab","ab"),"#,#,");
        //путей может быть много, поэтому тут жестко проверить все сложно
        //надо найти и проверить их все, что делает тест сложнее реализации
        //возможно, что хватит только подсчета повторов.

        //ожидается     -s,~p,#,#,#,+s,
        assertEquals("C2 failed", instance.getDistanceEditing("short","ports").split("#").length,4);

        //ожидается     +e,#,#,-s,#,~i,#,-c,~g,
        assertEquals("C3 failed", instance.getDistanceEditing("distance","editing").split("#").length,5);
    }

}
