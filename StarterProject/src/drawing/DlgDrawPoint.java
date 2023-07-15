package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.colorchooser.AbstractColorChooserPanel;

import geometry.Point;

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

public class DlgDrawPoint extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textXCoordinate;
	private JTextField textYCoordinate;
	private JButton btnColor = new JButton("                  ");

	private Color color;
	private Point obj;
	private boolean isOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDrawPoint dialog = new DlgDrawPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDrawPoint() {
		setModal(true);
		setBounds(100, 100, 384, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblXCoordinate = new JLabel("X:");
			GridBagConstraints gbc_lblXCoordinate = new GridBagConstraints();
			gbc_lblXCoordinate.anchor = GridBagConstraints.EAST;
			gbc_lblXCoordinate.insets = new Insets(0, 0, 5, 5);
			gbc_lblXCoordinate.gridx = 0;
			gbc_lblXCoordinate.gridy = 0;
			contentPanel.add(lblXCoordinate, gbc_lblXCoordinate);
		}
		{
			textXCoordinate = new JTextField();
			textXCoordinate.setColumns(10);
			GridBagConstraints gbc_textXCoordinate = new GridBagConstraints();
			gbc_textXCoordinate.anchor = GridBagConstraints.WEST;
			gbc_textXCoordinate.insets = new Insets(0, 0, 5, 0);
			gbc_textXCoordinate.gridx = 1;
			gbc_textXCoordinate.gridy = 0;
			contentPanel.add(textXCoordinate, gbc_textXCoordinate);
		}
		{
			JLabel lblYCoordinate = new JLabel("Y:");
			GridBagConstraints gbc_lblYCoordinate = new GridBagConstraints();
			gbc_lblYCoordinate.anchor = GridBagConstraints.EAST;
			gbc_lblYCoordinate.insets = new Insets(0, 0, 5, 5);
			gbc_lblYCoordinate.gridx = 0;
			gbc_lblYCoordinate.gridy = 1;
			contentPanel.add(lblYCoordinate, gbc_lblYCoordinate);
		}
		{
			textYCoordinate = new JTextField();
			GridBagConstraints gbc_textYCoordinate = new GridBagConstraints();
			gbc_textYCoordinate.anchor = GridBagConstraints.WEST;
			gbc_textYCoordinate.insets = new Insets(0, 0, 5, 0);
			gbc_textYCoordinate.gridx = 1;
			gbc_textYCoordinate.gridy = 1;
			contentPanel.add(textYCoordinate, gbc_textYCoordinate);
			textYCoordinate.setColumns(10);
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
						try {
					        int x = Integer.parseInt(getXCoordinate().getText());
					        int y = Integer.parseInt(getYCoordinate().getText());

							if (x >= 0 && y >= 0) {
								isOk = true;
								obj = new Point(x, y, getPointColor());
								setVisible(false);
							} else {
								JOptionPane.showMessageDialog(null, "Coordinates cannot be negative!", "Error",
									JOptionPane.ERROR_MESSAGE);
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
	
	public JTextField getXCoordinate() {
		return textXCoordinate;
	}

	public JTextField getYCoordinate() {
		return textYCoordinate;
	}
	
	public Color getPointColor() {
		return btnColor.getBackground();
	}
	
	public void setBtnColorBackground(Color color) {
	    btnColor.setBackground(color);
	}
	
	public Point getPointObj() {
		return obj;
	}
	
	public boolean isOk() {
		return isOk;
	}

}
