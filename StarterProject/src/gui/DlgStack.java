package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgStack extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtXCoordinate;
	private JTextField txtYCoordinate;
	private JTextField txtCircleRadius;
	private boolean isOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgStack dialog = new DlgStack();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgStack() {
		setModal(true);
		setTitle("Add circle");
		setBounds(500, 400, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblYCoordinate = new JLabel("x:");
			GridBagConstraints gbc_lblYCoordinate = new GridBagConstraints();
			gbc_lblYCoordinate.insets = new Insets(0, 0, 5, 5);
			gbc_lblYCoordinate.anchor = GridBagConstraints.EAST;
			gbc_lblYCoordinate.gridx = 1;
			gbc_lblYCoordinate.gridy = 1;
			contentPanel.add(lblYCoordinate, gbc_lblYCoordinate);
		}
		{
			txtXCoordinate = new JTextField();
			GridBagConstraints gbc_txtXCoordinate = new GridBagConstraints();
			gbc_txtXCoordinate.insets = new Insets(0, 0, 5, 0);
			gbc_txtXCoordinate.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtXCoordinate.gridx = 2;
			gbc_txtXCoordinate.gridy = 1;
			contentPanel.add(txtXCoordinate, gbc_txtXCoordinate);
			txtXCoordinate.setColumns(10);
		}
		{
			JLabel lblYCoordinate = new JLabel("y:");
			GridBagConstraints gbc_lblYCoordinate = new GridBagConstraints();
			gbc_lblYCoordinate.anchor = GridBagConstraints.EAST;
			gbc_lblYCoordinate.insets = new Insets(0, 0, 5, 5);
			gbc_lblYCoordinate.gridx = 1;
			gbc_lblYCoordinate.gridy = 2;
			contentPanel.add(lblYCoordinate, gbc_lblYCoordinate);
		}
		{
			txtYCoordinate = new JTextField();
			txtYCoordinate.setColumns(10);
			GridBagConstraints gbc_txtYCoordinate = new GridBagConstraints();
			gbc_txtYCoordinate.insets = new Insets(0, 0, 5, 0);
			gbc_txtYCoordinate.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtYCoordinate.gridx = 2;
			gbc_txtYCoordinate.gridy = 2;
			contentPanel.add(txtYCoordinate, gbc_txtYCoordinate);
		}
		{
			JLabel lblCircleRadius = new JLabel("r:");
			GridBagConstraints gbc_lblCircleRadius = new GridBagConstraints();
			gbc_lblCircleRadius.anchor = GridBagConstraints.EAST;
			gbc_lblCircleRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblCircleRadius.gridx = 1;
			gbc_lblCircleRadius.gridy = 3;
			contentPanel.add(lblCircleRadius, gbc_lblCircleRadius);
		}
		{
			txtCircleRadius = new JTextField();
			txtCircleRadius.setColumns(10);
			GridBagConstraints gbc_txtCircleRadius = new GridBagConstraints();
			gbc_txtCircleRadius.insets = new Insets(0, 0, 5, 0);
			gbc_txtCircleRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtCircleRadius.gridx = 2;
			gbc_txtCircleRadius.gridy = 3;
			contentPanel.add(txtCircleRadius, gbc_txtCircleRadius);
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
							validateIntegerInput(getXCoordinate(), "X Coordinate");
							validateIntegerInput(getYCoordinate(), "Y Coordinate");
							validatePositiveIntegerInput(getCircleRadius(), "Circle Radius");

							setVisible(false);
						} catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(null, "Values must be integers", "Error",
									JOptionPane.WARNING_MESSAGE);
						} catch (IllegalArgumentException ex) {
							JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
						} catch (EmptyFieldException ex) {
							JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
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
		return txtXCoordinate;
	}

	public JTextField getYCoordinate() {
		return txtYCoordinate;
	}

	public JTextField getCircleRadius() {
		return txtCircleRadius;
	}

	public boolean isOk() {
		return isOk;
	}

	class EmptyFieldException extends Exception {
		public EmptyFieldException(String message) {
			super(message);
		}
	}

	private int validateIntegerInput(JTextField textField, String fieldName)
			throws EmptyFieldException, NumberFormatException {
		String text = textField.getText().trim();
		if (text.isEmpty()) {
			throw new EmptyFieldException(fieldName + " cannot be empty");
		}
		return Integer.parseInt(text);
	}

	private int validatePositiveIntegerInput(JTextField textField, String fieldName)
			throws EmptyFieldException, NumberFormatException, IllegalArgumentException {
		int value = validateIntegerInput(textField, fieldName);
		if (value <= 0) {
			throw new IllegalArgumentException(fieldName + " must be greater than 0");
		}
		return value;
	}

}
