package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DLGTest extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtRed;
	private JTextField txtGreen;
	private JTextField txtBlue;
	private boolean isOk;

	/**
	 * Launch the application.
	 */	
	public static void main(String[] args) {
		try {
			DLGTest dialog = new DLGTest();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DLGTest() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblRed = new JLabel("Red");
			GridBagConstraints gbc_lblRed = new GridBagConstraints();
			gbc_lblRed.insets = new Insets(0, 0, 5, 5);
			gbc_lblRed.anchor = GridBagConstraints.EAST;
			gbc_lblRed.gridx = 1;
			gbc_lblRed.gridy = 1;
			contentPanel.add(lblRed, gbc_lblRed);
		}
		{
			txtRed = new JTextField();
			GridBagConstraints gbc_txtRed = new GridBagConstraints();
			gbc_txtRed.insets = new Insets(0, 0, 5, 0);
			gbc_txtRed.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtRed.gridx = 2;
			gbc_txtRed.gridy = 1;
			contentPanel.add(txtRed, gbc_txtRed);
			txtRed.setColumns(10);
		}
		{
			JLabel lblGreen = new JLabel("Green");
			GridBagConstraints gbc_lblGreen = new GridBagConstraints();
			gbc_lblGreen.anchor = GridBagConstraints.EAST;
			gbc_lblGreen.insets = new Insets(0, 0, 5, 5);
			gbc_lblGreen.gridx = 1;
			gbc_lblGreen.gridy = 2;
			contentPanel.add(lblGreen, gbc_lblGreen);
		}
		{
			txtGreen = new JTextField();
			txtGreen.setColumns(10);
			GridBagConstraints gbc_txtGreen = new GridBagConstraints();
			gbc_txtGreen.insets = new Insets(0, 0, 5, 0);
			gbc_txtGreen.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtGreen.gridx = 2;
			gbc_txtGreen.gridy = 2;
			contentPanel.add(txtGreen, gbc_txtGreen);
		}
		{
			JLabel lblBlue = new JLabel("Blue");
			GridBagConstraints gbc_lblBlue = new GridBagConstraints();
			gbc_lblBlue.anchor = GridBagConstraints.EAST;
			gbc_lblBlue.insets = new Insets(0, 0, 0, 5);
			gbc_lblBlue.gridx = 1;
			gbc_lblBlue.gridy = 3;
			contentPanel.add(lblBlue, gbc_lblBlue);
		}
		{
			txtBlue = new JTextField();
			txtBlue.setColumns(10);
			GridBagConstraints gbc_txtBlue = new GridBagConstraints();
			gbc_txtBlue.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtBlue.gridx = 2;
			gbc_txtBlue.gridy = 3;
			contentPanel.add(txtBlue, gbc_txtBlue);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						isOk=true;
						setVisible(false);
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

	public JTextField getTxtRed() {
		return txtRed;
	}

	public JTextField getTxtGreen() {
		return txtGreen;
	}

	public JTextField getTxtBlue() {
		return txtBlue;
	}

	public boolean isOk() {
		return isOk;
	}

}
