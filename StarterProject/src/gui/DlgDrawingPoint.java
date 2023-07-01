package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgDrawingPoint extends JDialog {

	private Drawing drawing;

	private final JPanel contentPanel = new JPanel();
	private JTextField textYCoordinate;
	private JTextField textXCoordinate;
	private JButton btnColor = new JButton("                  ");

	private int xCoordinate;
	private int yCoordinate;
	private Color color;
	private boolean isOk;
	PnlDrawing pnlDrawing = new PnlDrawing();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDrawingPoint dialog = new DlgDrawingPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDrawingPoint() {
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
			textXCoordinate.setText(getXCoordinate() + "");
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
			textYCoordinate.setText(getYCoordinate() + "");
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
			JButton btnColor = new JButton("                  ");
			btnColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JColorChooser colorChooser = new JColorChooser();
					color = colorChooser.showDialog(null, "Choose color", Color.BLACK);
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
							xCoordinate = Integer.parseInt(textXCoordinate.getText());
							yCoordinate = Integer.parseInt(textYCoordinate.getText());
							color = btnColor.getBackground();
							isOk = true;
							setVisible(false);
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "You didn't enter a number!", "Error",
									JOptionPane.ERROR_MESSAGE);
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

	public boolean isOk() {
		return isOk;
	}

	public int getXCoordinate() {
		return xCoordinate;
	}

	public void setXCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public int getYCoordinate() {
		return yCoordinate;
	}

	public void setYCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
