/** DÃ©finir une position.  */
import java.util.Map;
import lombok.Data;
@Data

public class Position {
	private int x;
	private int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
		//<(NO_TRACE)>// <(/NO_TRACE)>System.out.println("...appel Ã  Position(" + x + "," + y + ")" + " --> " + this);
	}

	@Override public String toString() {
		return super.toString() + "(" + x + "," + y + ")";
	}

}
