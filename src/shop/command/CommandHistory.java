package shop.command;

public interface CommandHistory {
	
	public void add(UndoableCommand cmd);
	public RerunnableCommand getUndo();
	public RerunnableCommand getRedo();
}
