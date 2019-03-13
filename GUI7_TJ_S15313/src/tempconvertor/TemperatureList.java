package tempconvertor;

import java.util.Iterator;

import javax.swing.AbstractListModel;

public class TemperatureList extends AbstractListModel{
	
	static int[] stopnie = new int[130];
	
	public TemperatureList() {
		for (int i = 0; i < 130; i++){
			stopnie[i] = i - 70;
		}
	}
	
	@Override
	public int getSize() {
		return 130;
	}

	@Override
	public Object getElementAt(int i) {
		double fahrenheit = 1.8 * stopnie[i] + 32;
		String element = "k "+ stopnie[i] + " C = f "+fahrenheit+" F";
		return element;
	}

}
