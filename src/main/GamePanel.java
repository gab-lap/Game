package main;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.FileInputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

public class GamePanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private MouseInputs mouseInputs;
	private float xDelta = 100;
	private float yDelta = 100;
	private BufferedImage img, subImg;

	public GamePanel() {
		mouseInputs = new MouseInputs(this);
		importImage();
		setPanelSize();
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
		addKeyListener(new KeyboardInputs(this));
	}
	
	private void importImage() {
		try {
			img = ImageIO.read(new FileInputStream("res/sprites.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void setPanelSize() {
		Dimension size = new Dimension(1248, 768); // -> 1280/32 = 39 tiles - 800/32 = 24 tiles
		setPreferredSize(size);
	}
	
	public void changeXDelta(int x) {
		this.xDelta += x;
	}
	
	public void changeYDelta(int y) {
		this.yDelta += y;
	}
	
	public void setRectPos(int x, int y) {
		this.xDelta = x;
		this.yDelta = y;
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		subImg = img.getSubimage(3*80, 3*80, 80, 80);   //if character if 80 x 80 each square containing sprite
		g.drawImage(subImg, 0, 0, 75, 75,  null);
	}
	
}
