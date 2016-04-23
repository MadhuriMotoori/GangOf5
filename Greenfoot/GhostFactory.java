public class GhostFactory  
{
	public Ghost makeGhost(int id){
		Ghost ghost = null;
		
		if(id == 1){
			return new Ghost1();
		} else if(id == 2){
			return new Ghost2();
		} else if(id == 3){
			return new Ghost3();
		} else if(id == 4){
			return new Ghost4();
		} else if(id == 5){
			return new Ghost5();
		} else {
			return null;
		}
	}
}

