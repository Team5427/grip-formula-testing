package com.Team5427.VisionProcessing;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class VisionFrame extends JFrame {

	public static final String title = "Vision Filtering Test";

	/*
	 * Change this if we're using camera or images - Image w:h - 720:502 -
	 * Multiply the width and height by the resize
	 */

	public static final int width = 632;
	public static final int height = 600;

	public final ImageIcon icon = getIcon();

	private GraphicsPanel graphicsPanel;

	public VisionFrame() {
		super(title);

		if (icon != null)
			setIconImage(icon.getImage());

		pack();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Insets insect = getInsets();
		int fWidth = insect.left + insect.right + width;
		int fHeight = insect.top + insect.bottom + height;

		graphicsPanel = new GraphicsPanel(fWidth, fHeight);

		setPreferredSize(new Dimension(fWidth, fHeight));

		add(graphicsPanel);

		// May change this later
		setResizable(false);

		pack();

		setVisible(true);

	}

	public GraphicsPanel getPanel() {
		return graphicsPanel;
	}

	public ImageIcon getIcon() {
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("resources/images/icon/oths.png").getFile());
			return new ImageIcon(ImageIO.read(file));
		} catch (Exception e) {
			System.err.println("Image not found in jar");
		}

		try {
			Image img = ImageIO.read(new File("resources\\images\\icon\\oths.png"));
			return new ImageIcon(img);
		} catch (Exception e) {
			System.err.println("Error loading image");
		}

		return null;
	}
}
