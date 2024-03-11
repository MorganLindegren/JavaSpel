package grafikPaket;

import javafx.scene.image.Image;

public class ImageBackground {
	
	Image background = new Image(getClass().getResourceAsStream(("GreenGrass.jpg")));
	
	public ImageBackground() {
			
	}
	
	public void setBackground() {
		background = new Image(getClass().getResourceAsStream(("DarkGrass.jpg")));
	}
	
	public Image getImage() {
		return background;
	}

}
