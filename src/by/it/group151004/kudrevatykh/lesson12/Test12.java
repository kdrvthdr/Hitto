package by.it.group151004.kudrevatykh.lesson12;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("all")
public class Test12 {

    @Test (timeout = 3000)
    public void testTaskA() throws Exception {
        TaskA g = new TaskA();
        int v = 9;
        for (int i = 0; i < 8; i++) {
            g.matrix.add(new ArrayList<TaskA.Node>());
        }
        g.matrix.get(0).add(new TaskA.Node(4, 4));
        g.matrix.get(0).add(new TaskA.Node(5, 8));
        g.matrix.get(0).add(new TaskA.Node(1, 1));
        g.matrix.get(1).add(new TaskA.Node(5, 6));
        g.matrix.get(1).add(new TaskA.Node(6, 6));
        g.matrix.get(1).add(new TaskA.Node(2, 2));
        g.matrix.get(2).add(new TaskA.Node(6, 2));
        g.matrix.get(2).add(new TaskA.Node(3, 1));
        g.matrix.get(3).add(new TaskA.Node(6, 1));
        g.matrix.get(3).add(new TaskA.Node(7, 4));
        g.matrix.get(6).add(new TaskA.Node(5, 1));
        g.matrix.get(6).add(new TaskA.Node(7, 1));
        g.matrix.get(4).add(new TaskA.Node(5, 5));
        g.pathDijkstra(0);
        boolean ok;
        ok = (g.destination[0] == 0);
        assertTrue("INCORRECT path from 0 to 0", ok);
        ok = (g.destination[1] == 1);
        assertTrue("INCORRECT path from 0 to 1", ok);
        ok = (g.destination[2] == 3);
        assertTrue("INCORRECT path from 0 to 2", ok);
        ok = (g.destination[3] == 4);
        assertTrue("INCORRECT path from 0 to 3", ok);
        ok = (g.destination[4] == 4);
        assertTrue("INCORRECT path from 0 to 4", ok);
        ok = (g.destination[5] == 6);
        assertTrue("INCORRECT path from 0 to 5", ok);
        ok = (g.destination[6] == 5);
        assertTrue("INCORRECT path from 0 to 6", ok);
        ok = (g.destination[7] == 6);
        assertTrue("INCORRECT path from 0 to 7", ok);
    }

    @Test(timeout = 3000)
    public void testTaskB() throws Exception {
        TaskB g = new TaskB();
        g.ford(0);
        boolean ok;
        ok = (g.distance[0] == 0);
        assertTrue("INCORRECT path from 0 to 0", ok);
        ok = (g.distance[1] == 4);
        assertTrue("INCORRECT path from 0 to 1", ok);
        ok = (g.distance[2] == -2);
        assertTrue("INCORRECT path from 0 to 2", ok);
        ok = (g.distance[3] == 0);
        assertTrue("INCORRECT path from 0 to 3", ok);
        ok = (g.distance[5] == -1);
        assertTrue("INCORRECT path from 0 to 5", ok);
        ok = (g.distance[6] == 1);
        assertTrue("INCORRECT path from 0 to 6", ok);
        ok = (g.distance[7] == 0);
        assertTrue("INCORRECT path from 0 to 7", ok);
        ok = (g.distance[8] == 0);
        assertTrue("INCORRECT path from 0 to 8", ok);

    }

}