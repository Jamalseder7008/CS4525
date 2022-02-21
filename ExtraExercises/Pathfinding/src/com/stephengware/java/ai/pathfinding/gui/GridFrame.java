package com.stephengware.java.ai.pathfinding.gui;

import javax.swing.JFrame;

/**
 * The high-leve container that holds a visualization of the path search.
 * 
 * @author Stephen G. Ware
 */
public class GridFrame extends JFrame {

	/** Version 1 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new JFrame with a given {@link GridPanel}.
	 * 
	 * @param panel the grid panel to visualize
	 */
	public GridFrame(GridPanel panel) {
		super("Pathfinding");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
