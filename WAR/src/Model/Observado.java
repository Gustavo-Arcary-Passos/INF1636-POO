package Model;

public interface Observado {
	public void add(Observador o);
	public void remove(Observador o);
	public Object get(char o);
}
