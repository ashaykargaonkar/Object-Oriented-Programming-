package shop.main;

import shop.ui.UI;
import shop.ui.UIMenu;
import shop.ui.UIError;
import shop.data.Inventory;

 public class Control{
 // private static final int EXITED = 0;
 // private static final int EXIT = 1;
 // private static final int START = 2;
  private static final int NUMSTATES = 10;
  private UIMenu[] _menus;
  private StateEnum _state;

//  private UIForm _getVideoForm;
  //private UIFormTest _numberTest;
  //private UIFormTest _stringTest;
  private UIMenu _getvideoForm;  
  private Inventory _inventory;
  private UI _ui;
  
  private final MenuEnum[] arrStart = {
		  MenuEnum.Default,
		  MenuEnum.numcopiesadd,
		  MenuEnum.checkinvid,
		  MenuEnum.checkvidout,
		  MenuEnum.printinve,
		  MenuEnum.erase,
		  MenuEnum.undo,
		  MenuEnum.redo,
		  MenuEnum.printallinorder,
		  MenuEnum.exit,
		  MenuEnum.boguscontent
		  
  };
  
  private final MenuEnum[] arrExit = {
		  
		  MenuEnum.default_,
		  MenuEnum.yes,
		  MenuEnum.no

		  
  };
  
  final String WANT_TO_EXIT = "Are you sure you want to exit?";
  final String BOBS_VIDEO = "Bob's Video";
  final String ENTER_VIDEO = "Enter Video";
  final String ERROR = "UI Closed";
  
  private final MenuEnum[] testnames = {
		  
		  MenuEnum.title,
		  MenuEnum.year,
		  MenuEnum.director
  };
  
  Control(Inventory inventory, UI ui) {
    _inventory = inventory;
    _ui = ui;

    _menus = new UIMenu[NUMSTATES];
    _state = StateEnum.START;
    addStatus(StateEnum.START,arrStart,BOBS_VIDEO);
    addStatus(StateEnum.EXIT,arrExit,WANT_TO_EXIT);
    set_getVideoForm(new UIMenu(ENTER_VIDEO,testnames));
  }
    
    void run() {
    	
    	try {
    		while(get_state()!= StateEnum.EXITED) {
    			get_ui().processMenu(_menus[get_state().getnumber()],this);
    		}
    	}
    	catch (UIError e)
    	{
    		get_ui().displayError(ERROR);
    		
    	}
    }
    
    public void addStatus(StateEnum statenum, MenuEnum[] arr ,String Message) {
    	
    	_menus[statenum.getnumber()] =  new UIMenu(Message,arr);
    }
    
    public UI get_ui() {
    	
    	return _ui;
    }
    
    public void set_ui(UI _ui) {
    	
        this._ui = _ui;
    }
    
    public  UIMenu get_getVideoForm() {
    	
      return _getvideoForm;
    }
    
    public void set_getVideoForm(UIMenu _getVideoForm) {
    	
        this._getvideoForm = _getVideoForm;
    }
    
    public  Inventory get_inventory() {
    	
        return _inventory;
      }
    public  StateEnum get_state() {
    	
        return _state;
      }
    
 public void set_inventory(Inventory _inventory) {
    	
        this._inventory = _inventory;
    }
 
 public void set_state(StateEnum _state) {
 	
     this._state =_state;
 }
 

    	
  
}