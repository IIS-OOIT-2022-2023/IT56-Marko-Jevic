package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.colorchooser.AbstractColorChooserPanel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class DlgDrawLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textY1Coordinate;
	private JTextField textX1Coordinate;
	private JTextField textX2Coordinate;
	private JTextField textY2Coordinate;

	private JButton btnColor = new JButton("                  ");

	private Color color;
	private boolean isOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Drawing drawing = new Drawing();
			DlgDrawLine dialog = new DlgDrawLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDrawLine() {
		setModal(true);
		setBounds(100, 100, 384, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblX1Coordinate = new JLabel("X1:");
			GridBagConstraints gbc_lblX1Coordinate = new GridBagConstraints();
			gbc_lblX1Coordinate.anchor = GridBagConstraints.EAST;
			gbc_lblX1Coordinate.insets = new Insets(0, 0, 5, 5);
			gbc_lblX1Coordinate.gridx = 0;
			gbc_lblX1Coordinate.gridy = 0;
			contentPanel.add(lblX1Coordinate, gbc_lblX1Coordinate);
		}
		{
			textX1Coordinate = new JTextField();
			textX1Coordinate.setColumns(10);
			GridBagConstraints gbc_textX1Coordinate = new GridBagConstraints();
			gbc_textX1Coordinate.anchor = GridBagConstraints.WEST;
			gbc_textX1Coordinate.insets = new Insets(0, 0, 5, 5);
			gbc_textX1Coordinate.gridx = 1;
			gbc_textX1Coordinate.gridy = 0;
			contentPanel.add(textX1Coordinate, gbc_textX1Coordinate);
		}
		{
			JLabel lblX2Coordinate = new JLabel("X2:");
			GridBagConstraints gbc_lblX2Coordinate = new GridBagConstraints();
			gbc_lblX2Coordinate.anchor = GridBagConstraints.EAST;
			gbc_lblX2Coordinate.insets = new Insets(0, 0, 5, 5);
			gbc_lblX2Coordinate.gridx = 2;
			gbc_lblX2Coordinate.gridy = 0;
			contentPanel.add(lblX2Coordinate, gbc_lblX2Coordinate);
		}
		{
			textX2Coordinate = new JTextField();
			textX2Coordinate.setColumns(10);
			GridBagConstraints gbc_textX2Coordinate = new GridBagConstraints();
			gbc_textX2Coordinate.anchor = GridBagConstraints.WEST;
			gbc_textX2Coordinate.insets = new Insets(0, 0, 5, 0);
			gbc_textX2Coordinate.gridx = 3;
			gbc_textX2Coordinate.gridy = 0;
			contentPanel.add(textX2Coordinate, gbc_textX2Coordinate);
		}
		{
			JLabel lblY1Coordinate = new JLabel("Y1:");
			GridBagConstraints gbc_lblY1Coordinate = new GridBagConstraints();
			gbc_lblY1Coordinate.anchor = GridBagConstraints.EAST;
			gbc_lblY1Coordinate.insets = new Insets(0, 0, 5, 5);
			gbc_lblY1Coordinate.gridx = 0;
			gbc_lblY1Coordinate.gridy = 1;
			contentPanel.add(lblY1Coordinate, gbc_lblY1Coordinate);
		}
		{
			textY1Coordinate = new JTextField();
			GridBagConstraints gbc_textY1Coordinate = new GridBagConstraints();
			gbc_textY1Coordinate.anchor = GridBagConstraints.WEST;
			gbc_textY1Coordinate.insets = new Insets(0, 0, 5, 5);
			gbc_textY1Coordinate.gridx = 1;
			gbc_textY1Coordinate.gridy = 1;
			contentPanel.add(textY1Coordinate, gbc_textY1Coordinate);
			textY1Coordinate.setColumns(10);
		}
		{
			JLabel lblY2Coordinate = new JLabel("Y2:");
			GridBagConstraints gbc_lblY2Coordinate = new GridBagConstraints();
			gbc_lblY2Coordinate.anchor = GridBagConstraints.EAST;
			gbc_lblY2Coordinate.insets = new Insets(0, 0, 5, 5);
			gbc_lblY2Coordinate.gridx = 2;
			gbc_lblY2Coordinate.gridy = 1;
			contentPanel.add(lblY2Coordinate, gbc_lblY2Coordinate);
		}
		{
			textY2Coordinate = new JTextField();
			textY2Coordinate.setColumns(10);
			GridBagConstraints gbc_textY2Coordinate = new GridBagConstraints();
			gbc_textY2Coordinate.anchor = GridBagConstraints.WEST;
			gbc_textY2Coordinate.insets = new Insets(0, 0, 5, 0);
			gbc_textY2Coordinate.gridx = 3;
			gbc_textY2Coordinate.gridy = 1;
			contentPanel.add(textY2Coordinate, gbc_textY2Coordinate);
		}
		{
			JLabel lblColor = new JLabel("Color");
			GridBagConstraints gbc_lblColor = new GridBagConstraints();
			gbc_lblColor.insets = new Insets(0, 0, 0, 5);
			gbc_lblColor.gridx = 0;
			gbc_lblColor.gridy = 2;
			contentPanel.add(lblColor, gbc_lblColor);
		}
		{
			btnColor.setBackground(Color.BLACK);
			btnColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			        JColorChooser colorChooser = new JColorChooser();

			        // Retrieve the current panels from the JColorChooser instance
			        AbstractColorChooserPanel[] panels = colorChooser.getChooserPanels();
			        List<AbstractColorChooserPanel> newPanels = new ArrayList<>();

			        // Add the swatches panel to the new list of panels
			        for (AbstractColorChooserPanel panel : panels) {
			            if (panel.getClass().getName().equals("javax.swing.colorchooser.DefaultSwatchChooserPanel")) {
			                newPanels.add(panel);
			            }
			        }

			        // Set the new list of panels to the JColorChooser instance
			        colorChooser.setChooserPanels(newPanels.toArray(new AbstractColorChooserPanel[0]));

			        // Show the modified JColorChooser dialog
			        JDialog dialog = JColorChooser.createDialog(null, "Choose color", true, colorChooser, null, null);
			        dialog.setVisible(true);

			        // Retrieve the selected color
			        color = colorChooser.getColor();
			        btnColor.setBackground(color);
				}
			});
			GridBagConstraints gbc_btnColor = new GridBagConstraints();
			gbc_btnColor.insets = new Insets(0, 0, 0, 5);
			gbc_btnColor.anchor = GridBagConstraints.WEST;
			gbc_btnColor.gridx = 1;
			gbc_btnColor.gridy = 2;
			contentPanel.add(btnColor, gbc_btnColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						isOk = true;
			            try {
			                int x1 = Integer.parseInt(textX1Coordinate.getText());
			                int y1 = Integer.parseInt(textY1Coordinate.getText());
			                int x2 = Integer.parseInt(textX2Coordinate.getText());
			                int y2 = Integer.parseInt(textY2Coordinate.getText());

			                if (x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0) {
			                    JOptionPane.showMessageDialog(null, "Coordinates cannot be negative!");
			                } else {
			                    color = btnColor.getBackground();
			                    setVisible(false);
			                }
			            } catch (NumberFormatException ex) {
			                JOptionPane.showMessageDialog(null, "Values cant be type of string or empty!");
			            } 
			            
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JTextField getX1Coordinate() {
		return textX1Coordinate;
	}

	public JTextField getY1Coordinate() {
		return textY1Coordinate;
	}

	public JTextField getX2Coordinate() {
		return textX2Coordinate;
	}

	public JTextField getY2Coordinate() {
		return textY2Coordinate;
	}

	public Color getLineColor() {
		return btnColor.getBackground();
	}
	
	public void setBtnColorBackground(Color color) {
	    btnColor.setBackground(color);
	}

	public boolean isOk() {
		return isOk;
	}

}
