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

import geometry.Circle;
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

public class DlgDrawCircle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textYCoordinate;
	private JTextField textXCoordinate;
	private JTextField textRadius;
	JButton btnOutlineColor = new JButton("                  ");
	JButton btnFillColor = new JButton("                  ");


	private boolean isOk;
	private Circle obj;
	private Color outlineColor;
	private Color fillColor;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDrawCircle dialog = new DlgDrawCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDrawCircle() {
		setModal(true);
		setBounds(100, 100, 384, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblXCoordinate = new JLabel("X:");
			GridBagConstraints gbc_lblXCoordinate = new GridBagConstraints();
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
			JLabel lblRadius = new JLabel("Radius:");
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblRadius.gridx = 0;
			gbc_lblRadius.gridy = 2;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			textRadius = new JTextField();
			textRadius.setColumns(10);
			GridBagConstraints gbc_textRadius = new GridBagConstraints();
			gbc_textRadius.anchor = GridBagConstraints.WEST;
			gbc_textRadius.insets = new Insets(0, 0, 5, 0);
			gbc_textRadius.gridx = 1;
			gbc_textRadius.gridy = 2;
			contentPanel.add(textRadius, gbc_textRadius);
		}
		{
			JLabel lblOutlineColor = new JLabel("Outline color");
			GridBagConstraints gbc_lblOutlineColor = new GridBagConstraints();
			gbc_lblOutlineColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblOutlineColor.gridx = 0;
			gbc_lblOutlineColor.gridy = 3;
			contentPanel.add(lblOutlineColor, gbc_lblOutlineColor);
		}
		{
			btnOutlineColor.setBackground(Color.BLACK);
			btnOutlineColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			        JColorChooser outlineColorChooser = new JColorChooser();
			    	
			        // Retrieve the current panels from the JColorChooser instance
			        AbstractColorChooserPanel[] panels = outlineColorChooser.getChooserPanels();
			        List<AbstractColorChooserPanel> newPanels = new ArrayList<>();
	
			        // Add the swatches panel to the new list of panels
			        for (AbstractColorChooserPanel panel : panels) {
			            if (panel.getClass().getName().equals("javax.swing.colorchooser.DefaultSwatchChooserPanel")) {
			                newPanels.add(panel);
			            }
			        }
	
			        // Set the new list of panels to the JColorChooser instance
			        outlineColorChooser.setChooserPanels(newPanels.toArray(new AbstractColorChooserPanel[0]));
	
			        // Show the modified JColorChooser dialog
			        JDialog dialog = JColorChooser.createDialog(null, "Choose color", true, outlineColorChooser, null, null);
			        dialog.setVisible(true);
	
			        // Retrieve the selected color
			        outlineColor = outlineColorChooser.getColor();
			        btnOutlineColor.setBackground(outlineColor);
				}
			});
			GridBagConstraints gbc_btnOutlineColor = new GridBagConstraints();
			gbc_btnOutlineColor.anchor = GridBagConstraints.WEST;
			gbc_btnOutlineColor.insets = new Insets(0, 0, 5, 0);
			gbc_btnOutlineColor.gridx = 1;
			gbc_btnOutlineColor.gridy = 3;
			contentPanel.add(btnOutlineColor, gbc_btnOutlineColor);
		}
		{
			JLabel lblFillColor = new JLabel("Fill color");
			GridBagConstraints gbc_lblFillColor = new GridBagConstraints();
			gbc_lblFillColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblFillColor.gridx = 0;
			gbc_lblFillColor.gridy = 4;
			contentPanel.add(lblFillColor, gbc_lblFillColor);
		}
		{
			btnFillColor.setBackground(Color.BLACK);
			btnFillColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			        JColorChooser fillColorChooser = new JColorChooser();
			    	
			        // Retrieve the current panels from the JColorChooser instance
			        AbstractColorChooserPanel[] panels = fillColorChooser.getChooserPanels();
			        List<AbstractColorChooserPanel> newPanels = new ArrayList<>();
	
			        // Add the swatches panel to the new list of panels
			        for (AbstractColorChooserPanel panel : panels) {
			            if (panel.getClass().getName().equals("javax.swing.colorchooser.DefaultSwatchChooserPanel")) {
			                newPanels.add(panel);
			            }
			        }
	
			        // Set the new list of panels to the JColorChooser instance
			        fillColorChooser.setChooserPanels(newPanels.toArray(new AbstractColorChooserPanel[0]));
	
			        // Show the modified JColorChooser dialog
			        JDialog dialog = JColorChooser.createDialog(null, "Choose color", true, fillColorChooser, null, null);
			        dialog.setVisible(true);
	
			        // Retrieve the selected color
			        fillColor = fillColorChooser.getColor();
			        btnFillColor.setBackground(fillColor);
				}
			});
			GridBagConstraints gbc_btnFillColor = new GridBagConstraints();
			gbc_btnFillColor.insets = new Insets(0, 0, 5, 0);
			gbc_btnFillColor.anchor = GridBagConstraints.WEST;
			gbc_btnFillColor.gridx = 1;
			gbc_btnFillColor.gridy = 4;
			contentPanel.add(btnFillColor, gbc_btnFillColor);
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
							int x = Integer.parseInt(textXCoordinate.getText());
							int y = Integer.parseInt(textYCoordinate.getText());
							int r = Integer.parseInt(textRadius.getText());
							outlineColor = btnOutlineColor.getBackground();
							fillColor = btnFillColor.getBackground();
							
				            if (x < 0 || y < 0) {
				                JOptionPane.showMessageDialog(null, "Invalid input! Please ensure that x and y coordinates are not negative.");
				            } else if( r <= 0) {
				            	JOptionPane.showMessageDialog(null, "Invalid input! Radius must be greater than 0.");
				        	}else {
				                outlineColor = btnOutlineColor.getBackground();
				                fillColor = btnFillColor.getBackground();
								isOk = true;
								obj = new Circle(new Point(x, y), r, getOutlineColor(), getFillColor());
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

	public JTextField getXCoordinate() {
		return textXCoordinate;
	}

	public JTextField getYCoordinate() {
		return textYCoordinate;
	}
	
	public JTextField getTextRadius() {
		return textRadius;
	}
	
	public Color getOutlineColor() {
		return outlineColor;
	}
	
	public void setBtnOutlineBackground(Color color) {
		btnOutlineColor.setBackground(color);
	}
		
	public Color getFillColor() {
		return fillColor;
	}
	
	public void setBtnFillBackground(Color color) {
		btnFillColor.setBackground(color);
	}
		
	public Circle getCircleObj() {
		return obj;
	}
	
	public boolean isOk() {
		return isOk;
	}

}
