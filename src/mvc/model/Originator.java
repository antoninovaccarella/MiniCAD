package mvc.model;

public interface Originator {

     public Memento saveState();

     public void undo(Memento memento);
}
