package by.it.group151002.shatko.lesson09;


import by.it.HomeWork;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@SuppressWarnings("all")

//��������� ������ �� ��������� ������ � ������� Ctrl+Shift+F10
public class Test_jd01_11 extends HomeWork {


    @Test(timeout = 1500)
    public void testTaskA__ListA() throws Exception {
        System.out.println("\nA. ����������� ������������ � ���������� �������:");
        Class<?> aclass = findClass("ListA");
        List<Integer> a = (List<Integer>) aclass.getDeclaredConstructor().newInstance();
        List<Integer> e = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            e.add(i * 2);
            a.add(i * 2);
            assertEquals("������ add ��� toString() �� ��������", e.toString(), a.toString());
        }
        assertEquals("����� add(T e) ��� toString �� ��������", e.toString(), a.toString());
        System.out.println("add(T e) toString() ok: " + a);
        System.out.flush();

        assertEquals("������ remove(int index) �� ��������", e.remove(0), a.remove(0));
        assertEquals("������ remove(int index) ��� toString() �� ��������", e.toString(), a.toString());

        assertEquals("������ remove(int index) �� ��������", e.remove(8), a.remove(8));
        assertEquals("������ remove(int index) ��� toString() �� ��������", e.toString(), a.toString());

        assertEquals("������ remove(int index) �� ��������", e.remove(4), a.remove(4));
        assertEquals("������ remove(int index) ��� toString() �� ��������", e.toString(), a.toString());
        System.out.println("  remove(int index) ok: " + a);
        System.out.flush();

        assertEquals("������ get(int index) �� ��������", e.get(6), a.get(6));
        assertEquals("������ get(int index) �� ��������", e.get(0), a.get(0));
        System.out.println("     get(int index) ok: " + a);
        System.out.flush();
    }

    @Test(timeout = 1500)
    public void testTaskB__ListB() throws Exception {
        System.out.println("\nB. ����������� ������������ � ���������� �������:");
        Class<?> aclass = findClass("ListB");
        List<Long> a = (List<Long>) aclass.getDeclaredConstructor().newInstance();
        List<Long> e = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            e.add(i * 2L);
            a.add(i * 2L);
            assertEquals("������ add ��� toString() �� ��������", e.toString(), a.toString());
        }
        assertEquals("����� add(T e) ��� toString �� ��������", e.toString(), a.toString());
        System.out.println("add(T e) toString() ok: " + a);
        System.out.flush();

        assertEquals("������ remove(int index) �� ��������", e.remove(0), a.remove(0));
        assertEquals("������ remove(int index) ��� toString() �� ��������", e.toString(), a.toString());

        assertEquals("������ remove(int index) �� ��������", e.remove(8), a.remove(8));
        assertEquals("������ remove(int index) ��� toString() �� ��������", e.toString(), a.toString());

        assertEquals("������ remove(int index) �� ��������", e.remove(4), a.remove(4));
        assertEquals("������ remove(int index) ��� toString() �� ��������", e.toString(), a.toString());
        System.out.println("  remove(int index) ok: " + a);
        System.out.flush();

        assertEquals("������ get(int index) �� ��������", e.get(6), a.get(6));
        assertEquals("������ get(int index) �� ��������", e.get(0), a.get(0));
        System.out.println("     get(int index) ok: " + a);
        System.out.flush();

        assertEquals("������ set(int index, T e) �� ��������", e.set(0, 0L), a.set(0, 0L));
        assertEquals("������ set(int index, T e) ��� toString() �� ��������", e.toString(), a.toString());

        assertEquals("������ set(int index, T e) �� ��������", e.set(6, null), a.set(6, null));
        assertEquals("������ set(int index, T e) ��� toString() �� ��������", e.toString(), a.toString());
        System.out.println("     set(int index) ok: " + a);
        System.out.flush();

        e.add(0, null);
        a.add(0, null);
        assertEquals("������ add(int index, T e)", e.toString(), a.toString());

        e.add(4, 444L);
        a.add(4, 444L);
        assertEquals("������ add(int index, T e)", e.toString(), a.toString());

        e.add(9, 999L);
        a.add(9, 999L);
        assertEquals("������ add(int index, T e)", e.toString(), a.toString());
        System.out.println("add(int index, T e) ok: " + a);
        System.out.flush();

        List<Long> added = new ArrayList<>();
        added.add(1000L);
        added.add(1001L);
        added.add(1002L);
        e.addAll(added);
        a.addAll(added);
        assertEquals("������ addAll", e.toString(), a.toString());
        System.out.println("  addAll(List<?> c) ok: " + a);
        System.out.flush();

        System.out.println("\nB. ����������� �������������� � ���������� �������:");
        if (e.contains(null) != a.contains(null) ||
                e.contains(0) != a.contains(0) ||
                e.contains(1002) != a.contains(1002)
                )
            System.out.println("�����������: contains �� ���������� ��� �������� �� ��� ��� � ArrayList");
        else
            System.out.println("      contains(T e) ok: " + a);

        if (e.size() != a.size())
            System.out.println("�����������: size �� ���������� ��� �������� �� ��� ��� � ArrayList");
        else
            System.out.println("             size() ok: " + a);

        if (e.indexOf(444) != a.indexOf(444))
            System.out.println("�����������: indexOf �� ���������� ��� �������� �� ��� ��� � ArrayList");
        else
            System.out.println("          indexOf() ok: " + a);

        if (e.remove(Integer.valueOf(444)) != a.remove(Integer.valueOf(444)))
            System.out.println("�����������: remove(Object o) �� ���������� ��� �������� �� ��� ��� � ArrayList");
        else
            System.out.println("   remove(Object o) ok: " + a);
    }

    private void assertSet(String message, Set<Short> e, Set<Short> a){
        List<Short> arr=new ArrayList<>(e);
        boolean ok=true;
        if (e.size()!=a.size())
            fail(message+" e.size()!=a.size()");
        for (Short i : arr) {
            if (!a.contains(i)) {
                fail(message+"\n+!a.contains("+i+")\nexpected:"+e.toString()+")\nactual:"+a.toString());
            }
        }
    };

    @Test(timeout = 1500)
    public void testTaskC__SetC() throws Exception {
        System.out.println("\nC. ����������� ������������ � ���������� �������:");
        Class<?> aclass = findClass("SetC");
        Set<Short> a = (Set<Short>) aclass.getDeclaredConstructor().newInstance();
        Set<Short> e = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            e.add((short) (i * 2));
            a.add((short) (i * 2));
            assertSet("������ add ��� toString() �� ��������", e, a);
        }
        assertSet("����� add(T e) ��� toString �� ��������", e, a);
        System.out.println("add(T e) toString() ok: " + a);
        System.out.flush();

        assertEquals("������ remove(Object o) �� ��������", e.remove(0), a.remove(0));
        assertSet("������ remove(Object o) ��� toString() �� ��������", e, a);

        assertEquals("������ remove(Object o) �� ��������", e.remove(8), a.remove(8));
        assertSet("������ remove(Object o) ��� toString() �� ��������", e, a);

        assertEquals("������ remove(Object o) �� ��������", e.remove(4), a.remove(4));
        assertSet("������ remove(Object o) ��� toString() �� ��������", e, a);
        assertSet("������ size", e, a);

        System.out.println("   remove(Object o) ok: " + a);
        System.out.flush();

        List<Short> added = new ArrayList<>();
        added.add(null);
        added.add(null);
        added.add((short) 1000);
        added.add((short) 1000);
        added.add((short) 1001);
        added.add((short) 1002);
        e.addAll(added);
        a.addAll(added);
        assertSet("������ addAll", e, a);
        System.out.println("  addAll(List<?> c) ok: " + a);
        System.out.flush();

        assertEquals("������ contains �� ��������", e.contains(1001), a.contains(1001));
        assertEquals("������ contains �� ��������", e.contains(-1), a.contains(-1));
        assertSet("������ contains", e, a);
        System.out.println("      contains(T e) ok: " + a);
        System.out.flush();

        assertEquals("������ size �� ��������", e.size(), a.size());
        assertSet("������ size", e, a);
        System.out.println("             size() ok: " + a);
        System.out.flush();


        assertEquals("������ containsAll �� ��������", e.containsAll(added), a.containsAll(added));
        assertSet("������ containsAll", e, a);
        System.out.println("        containsAll ok: " + a);
        System.out.flush();

        assertEquals("������ removeAll �� ��������", e.removeAll(added), a.removeAll(added));
        assertSet("������ removeAll", e, a);
        System.out.println("          removeAll ok: " + a);
        System.out.flush();

        assertEquals("������ isEmpty �� ��������", e.isEmpty(), a.isEmpty());
        assertSet("������ isEmpty", e, a);
        assertSet("������ isEmpty", e, a);
        e.clear(); a.clear();
        assertEquals("������ clear", 0, a.size());
        assertEquals("������ clear ��� isEmpty �� ��������", e.size(), a.size());
        System.out.println("    clear � isEmpty ok: " + a);
        System.out.flush();
    }

}