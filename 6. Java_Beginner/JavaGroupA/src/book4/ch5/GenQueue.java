package book4.ch5;

import java.util.LinkedList;

//queue is first in first out
//stack is first in last out

public class GenQueue<E>
{
    private LinkedList<E> list = new LinkedList<>();

    public void enqueue(E item)
    {
        list.addLast(item);
    }

    public E dequeue()
    {
        return list.poll();
    }

    public boolean hasItems()
    {
        return !list.isEmpty();
    }

    public int size()
    {
        return list.size();
    }

    public void addItems(GenQueue<? extends E> q)
    {
        while (q.hasItems())
        {
            list.addLast(q.dequeue());
        }
    }
}
