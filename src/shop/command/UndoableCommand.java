package shop.command;

public interface UndoableCommand {
	public boolean run();
	public void undo();
	public void redo();

}
