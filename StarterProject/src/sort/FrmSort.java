package sort;

import geometry.Point;
import geometry.Circle;
import stack.DlgCircle;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import javax.swing.DefaultListModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FrmSort extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<Circle> model = new DefaultListModel<Circle>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSort frame = new FrmSort();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmSort() {
		setTitle("Stack Jevic Marko IT56/2022");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		GridBagLayout gbl_pnlCenter = new GridBagLayout();
		gbl_pnlCenter.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_pnlCenter.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_pnlCenter.columnWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_pnlCenter.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		pnlCenter.setLayout(gbl_pnlCenter);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		pnlCenter.add(scrollPane, gbc_scrollPane);

		JList<Circle> lstCircles = new JList<Circle>();
		scrollPane.setViewportView(lstCircles);
		lstCircles.setModel(model);

		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(new Color(0, 255, 0));
		contentPane.add(pnlNorth, BorderLayout.NORTH);

		JLabel labelTitle = new JLabel("Sort Circle Area");
		labelTitle.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 14));
		pnlNorth.add(labelTitle);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		JButton btnAddCircle = new JButton("Add circle");
		btnAddCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgCircle dlg = new DlgCircle();
				dlg.setVisible(true);

				if (dlg.isOk() == true) {
					try {
						int x = Integer.parseInt(dlg.getXCoordinate().getText().replace(" ", ""));
						int y = Integer.parseInt(dlg.getYCoordinate().getText().replace(" ", ""));
						int radius = Integer.parseInt(dlg.getCircleRadius().getText().replace(" ", ""));

						Circle circle = new Circle(new Point(x, y), radius);
						model.add(0, circle);
					} catch (NumberFormatException ex) {
						//Reason to be explained, WARNING_MESSAGE not needed for better UX
						/*
						JOptionPane.showMessageDialog(null, "Are you sure you wanna cancel.", "Message",
								JOptionPane.WARNING_MESSAGE);
						*/

					}
				}

			}
		});
		panel.add(btnAddCircle);

		JButton btnSortCircles = new JButton("Sort");
		btnSortCircles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (model.getSize() == 0) {
		            JOptionPane.showMessageDialog(null, "No circles in the list.", "Error",
		                    JOptionPane.ERROR_MESSAGE);
		        } else {
		            List<Circle> circleList = new ArrayList<>();
		            for (int i = 0; i < model.getSize(); i++) {
		                circleList.add(model.getElementAt(i));
		            }

		            Collections.sort(circleList);

		            model.clear();
		            for (Circle circle : circleList) {
		                model.addElement(circle);
		            }
		        }
			}
		});
		panel.add(btnSortCircles);
	}
}

