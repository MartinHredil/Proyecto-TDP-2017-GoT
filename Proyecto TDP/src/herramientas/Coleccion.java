package herramientas;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class Coleccion<E> implements Collection<E>  {
	
	protected LinkedList<E> lista;
	
	public Coleccion()
	{
		lista = new LinkedList<E>();
	}
	
	public boolean add(E e)
	{
		return lista.add(e);
	}
	
	public boolean addAll(Collection<? extends E> c)
	{
		return lista.addAll(c);
	}
	
	public void clear()
	{
		lista.clear();
	}
	
	public boolean contains(Object o)
	{
		return lista.contains(o);
	}
	
	public boolean containsAll(Collection<?> c)
	{
		return lista.containsAll(c);
	}
	
	public boolean equals(Object o)
	{
		return lista.equals(o);
	}
	
	public int hashCode()
	{
		return lista.hashCode();
	}
	
	public boolean isEmpty()
	{
		return lista.isEmpty();
	}
	
	public Iterator<E> iterator()
	{
		return lista.iterator();
	}
	
	public boolean remove(Object o)
	{
		return lista.remove(o);
	}
	
	public boolean removeAll(Collection<?> c)
	{
		return lista.removeAll(c);
	}
	
	public boolean retainAll(Collection<?> c)
	{
		return lista.retainAll(c);
	}
	
	public int size()
	{
		return lista.size();
	}
	
	public Object[] toArray()
	{
		return lista.toArray();
	}
	
	public <T> T[] toArray(T[] a)
	{
		return lista.toArray(a);
	}
}
