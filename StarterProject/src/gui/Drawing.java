package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;

public class Drawing extends JFrame {

	private JPanel contentPane;
	private JToggleButton tglDrawPoint = new JToggleButton("");
	private JToggleButton tglDrawLine = new JToggleButton("");
	private JToggleButton tglDrawRectangle = new JToggleButton("");
	private JToggleButton tglDrawCircle = new JToggleButton("");
	private JToggleButton tglDrawDonut = new JToggleButton("");

	private ArrayList<Shape> shapes;
	private Shape selectedShape = null;
	private Point linePoints[] = new Point[2];

	private PnlDrawing canvas;
	private String btnShapeName = "";
	private int toolTgl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Drawing frame = new Drawing();
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
	public Drawing() {
		setTitle("Drawing Jevic Marko IT56/2022");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel menu = new JPanel();
		menu.setBackground(new Color(192, 192, 192));
		contentPane.add(menu, BorderLayout.NORTH);
		GridBagLayout gbl_menu = new GridBagLayout();
		gbl_menu.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_menu.rowHeights = new int[] { 67, 0, 0 };
		gbl_menu.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_menu.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		menu.setLayout(gbl_menu);

		JPanel tools = new JPanel();
		tools.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_tools = new GridBagConstraints();
		gbc_tools.insets = new Insets(0, 0, 5, 5);
		gbc_tools.gridx = 1;
		gbc_tools.gridy = 0;
		menu.add(tools, gbc_tools);
		GridBagLayout gbl_tools = new GridBagLayout();
		gbl_tools.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_tools.rowHeights = new int[] { 0, 0 };
		gbl_tools.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_tools.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		tools.setLayout(gbl_tools);

		ButtonGroup toolsGroup = new ButtonGroup();

		JToggleButton tglDraw = new JToggleButton("");
		tglDraw.setSelected(true);
		tglDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toolTgl = 0;
			}
		});

		JToggleButton tglSelect = new JToggleButton("");
		tglSelect.setToolTipText("Select object");
		tglSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toolTgl = 1;
			}
		});

		tglDraw.setIcon(new ImageIcon(Drawing.class.getResource("/images/tools/draw.png")));
		tglDraw.setToolTipText("Select object");
		tglDraw.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_tglDraw = new GridBagConstraints();
		gbc_tglDraw.insets = new Insets(0, 0, 0, 5);
		gbc_tglDraw.gridx = 0;
		gbc_tglDraw.gridy = 0;
		tools.add(tglDraw, gbc_tglDraw);
		tglSelect.setBackground(new Color(192, 192, 192));
		tglSelect.setIcon(new ImageIcon(Drawing.class.getResource("/images/tools/select.png")));
		GridBagConstraints gbc_tglSelect = new GridBagConstraints();
		gbc_tglSelect.insets = new Insets(0, 0, 0, 5);
		gbc_tglSelect.gridx = 1;
		gbc_tglSelect.gridy = 0;
		tools.add(tglSelect, gbc_tglSelect);

		JButton btnEdit = new JButton("");
		btnEdit.setToolTipText("Edit object");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedShape != null) {
		            if (selectedShape instanceof Point) {
		                DlgDrawPoint dlgPoint = new DlgDrawPoint();
		                Point point = (Point) selectedShape;
		                dlgPoint.getXCoordinate().setText(Integer.toString(point.getX()));
		                dlgPoint.getYCoordinate().setText(Integer.toString(point.getY()));
		                dlgPoint.setBtnColorBackground(point.getFillColor());
		                dlgPoint.setVisible(true);
		                if (dlgPoint.isOk()) {

		                    point.setX(Integer.parseInt(dlgPoint.getXCoordinate().getText()));
		                    point.setY(Integer.parseInt(dlgPoint.getYCoordinate().getText()));
		                    point.setFillColor(dlgPoint.getPointColor());
		                }
		            } else if (selectedShape instanceof Line) {
		                DlgDrawLine dlgLine = new DlgDrawLine();
		                Line line = (Line) selectedShape;
		                dlgLine.getX1Coordinate().setText(Integer.toString(line.getStartPoint().getX()));
		                dlgLine.getY1Coordinate().setText(Integer.toString(line.getStartPoint().getY()));
		                dlgLine.getX2Coordinate().setText(Integer.toString(line.getEndPoint().getX()));
		                dlgLine.getY2Coordinate().setText(Integer.toString(line.getEndPoint().getY()));
		                dlgLine.setBtnColorBackground(line.getFillColor());
		                dlgLine.setVisible(true);
		                if (dlgLine.isOk()) {

		                    line.getStartPoint().setX(Integer.parseInt(dlgLine.getX1Coordinate().getText()));
		                    line.getStartPoint().setY(Integer.parseInt(dlgLine.getY1Coordinate().getText()));
		                    line.getEndPoint().setX(Integer.parseInt(dlgLine.getX2Coordinate().getText()));
		                    line.getEndPoint().setY(Integer.parseInt(dlgLine.getY2Coordinate().getText()));
		                    line.setFillColor(dlgLine.getLineColor());
		                }
		            } else if (selectedShape instanceof Rectangle) {
		                DlgDrawRectangle dlgRectangle = new DlgDrawRectangle();
		                Rectangle rectangle = (Rectangle) selectedShape;
		                dlgRectangle.getXCoordinate().setText(Integer.toString(rectangle.getUpperLeftPoint().getX()));
		                dlgRectangle.getYCoordinate().setText(Integer.toString(rectangle.getUpperLeftPoint().getY()));
		                dlgRectangle.getTextWidth().setText(Integer.toString(rectangle.getWidth()));
		                dlgRectangle.getTextHeight().setText(Integer.toString(rectangle.getHeight()));
		                dlgRectangle.setBtnOutlineBackground(rectangle.getOutlineColor());
		                dlgRectangle.setBtnFillBackground(rectangle.getFillColor());
		                
		                dlgRectangle.setVisible(true);
		                if (dlgRectangle.isOk()) {
		                    try {
		                    	rectangle.getUpperLeftPoint().setX(Integer.parseInt(dlgRectangle.getXCoordinate().getText()));
		                    	rectangle.getUpperLeftPoint().setY(Integer.parseInt(dlgRectangle.getYCoordinate().getText()));
		                    	rectangle.setWidth(Integer.parseInt(dlgRectangle.getTextWidth().getText()));
		                    	rectangle.setHeight(Integer.parseInt(dlgRectangle.getTextHeight().getText()));
		                    	rectangle.setOutlineColor(dlgRectangle.getOutlineColor());
		                    	rectangle.setFillColor(dlgRectangle.getFillColor());
								
							} catch (NumberFormatException e1) {
					            JOptionPane.showMessageDialog(null, e1.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
							} catch (Exception e1) {
					            JOptionPane.showMessageDialog(null, e1.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);

							}
		                }
		            } else if (selectedShape instanceof Donut) {
		            	DlgDrawDonut dlgDonut= new DlgDrawDonut();
		                Donut donut= (Donut) selectedShape;
		                dlgDonut.getXCoordinate().setText(Integer.toString(donut.getCenter().getX()));
		                dlgDonut.getYCoordinate().setText(Integer.toString(donut.getCenter().getY()));
		                dlgDonut.getOuterRadius().setText(Integer.toString(donut.getRadius()));
		                dlgDonut.getInnerRadius().setText(Integer.toString(donut.getInnerRadius()));
		                dlgDonut.setBtnOutlineBackground(donut.getOutlineColor());
		                dlgDonut.setBtnFillBackground(donut.getFillColor());
		                
		                dlgDonut.setVisible(true);
		                if (dlgDonut.isOk()) {
		                    try {
			                    donut.getCenter().setX(Integer.parseInt(dlgDonut.getXCoordinate().getText()));
			                    donut.getCenter().setY(Integer.parseInt(dlgDonut.getYCoordinate().getText()));
								donut.setRadius(Integer.parseInt(dlgDonut.getOuterRadius().getText()));
								donut.setInnerRadius(Integer.parseInt(dlgDonut.getInnerRadius().getText()));
								donut.setOutlineColor(dlgDonut.getOutlineColor());
								donut.setFillColor(dlgDonut.getFillColor());
								
							} catch (NumberFormatException e1) {
					            JOptionPane.showMessageDialog(null, e1.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
							} catch (Exception e1) {
					            JOptionPane.showMessageDialog(null, e1.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);

							}
		                }
		            } else if (selectedShape instanceof Circle) {
		                DlgDrawCircle dlgCircle = new DlgDrawCircle();
		                Circle circle = (Circle) selectedShape;
		                dlgCircle.getXCoordinate().setText(Integer.toString(circle.getCenter().getX()));
		                dlgCircle.getYCoordinate().setText(Integer.toString(circle.getCenter().getY()));
		                dlgCircle.getTextRadius().setText(Integer.toString(circle.getRadius()));
		                dlgCircle.setBtnOutlineBackground(circle.getOutlineColor());
		                dlgCircle.setBtnFillBackground(circle.getFillColor());
		                
		                dlgCircle.setVisible(true);
		                if (dlgCircle.isOk()) {
		                    try {
			                    circle.getCenter().setX(Integer.parseInt(dlgCircle.getXCoordinate().getText()));
			                    circle.getCenter().setY(Integer.parseInt(dlgCircle.getYCoordinate().getText()));
								circle.setRadius(Integer.parseInt(dlgCircle.getTextRadius().getText()));
								circle.setOutlineColor(dlgCircle.getOutlineColor());
								circle.setFillColor(dlgCircle.getFillColor());
								
							} catch (NumberFormatException e1) {
					            JOptionPane.showMessageDialog(null, e1.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
							} catch (Exception e1) {
					            JOptionPane.showMessageDialog(null, e1.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);

							}
		                }
		            } 
					canvas.paintComponent(canvas.getGraphics(), shapes);
		        } else {
		            JOptionPane.showMessageDialog(null, "No shape selected.", "Warning", JOptionPane.WARNING_MESSAGE);
		        }
			}
		});
		btnEdit.setBackground(new Color(192, 192, 192));
		btnEdit.setIcon(new ImageIcon(Drawing.class.getResource("/images/tools/modify.png")));
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.insets = new Insets(0, 0, 0, 5);
		gbc_btnEdit.gridx = 2;
		gbc_btnEdit.gridy = 0;
		tools.add(btnEdit, gbc_btnEdit);

		JButton btnDelete = new JButton("");
		btnDelete.setToolTipText("Delete object");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        if (selectedShape != null) {
		            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the selected shape?", "Confirmation", JOptionPane.YES_NO_OPTION);
		            if (option == JOptionPane.YES_OPTION) {
		                shapes.remove(selectedShape);
		                selectedShape = null;
		                canvas.paintComponent(canvas.getGraphics(), shapes);
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "No shape selected.", "Warning", JOptionPane.WARNING_MESSAGE);
		        }
			}
		});
		btnDelete.setBackground(new Color(192, 192, 192));
		btnDelete.setIcon(new ImageIcon(Drawing.class.getResource("/images/tools/eraser.png")));
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.gridx = 3;
		gbc_btnDelete.gridy = 0;
		tools.add(btnDelete, gbc_btnDelete);

		toolsGroup.add(tglDraw);
		toolsGroup.add(tglSelect);

		JPanel geometries = new JPanel();
		geometries.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_geometries = new GridBagConstraints();
		gbc_geometries.insets = new Insets(0, 0, 5, 5);
		gbc_geometries.gridx = 3;
		gbc_geometries.gridy = 0;
		menu.add(geometries, gbc_geometries);
		GridBagLayout gbl_geometries = new GridBagLayout();
		gbl_geometries.columnWidths = new int[] { 31, 0, 0, 0, 0, 0 };
		gbl_geometries.rowHeights = new int[] { 0, 0 };
		gbl_geometries.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_geometries.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		geometries.setLayout(gbl_geometries);

		ButtonGroup geometriesGroup = new ButtonGroup();

		tglDrawPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnShapeName = "point";
			}
		});
		tglDrawPoint.setBackground(new Color(192, 192, 192));
		tglDrawPoint.setIcon(new ImageIcon(Drawing.class.getResource("/images/Shapes/dot.png")));
		GridBagConstraints gbc_tglDrawPoint = new GridBagConstraints();
		gbc_tglDrawPoint.insets = new Insets(0, 0, 0, 5);
		gbc_tglDrawPoint.gridx = 0;
		gbc_tglDrawPoint.gridy = 0;
		geometries.add(tglDrawPoint, gbc_tglDrawPoint);

		tglDrawLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnShapeName = "line";
			}
		});
		tglDrawLine.setBackground(new Color(192, 192, 192));
		tglDrawLine.setIcon(new ImageIcon(Drawing.class.getResource("/images/Shapes/line.png")));
		GridBagConstraints gbc_tglDrawLine = new GridBagConstraints();
		gbc_tglDrawLine.insets = new Insets(0, 0, 0, 5);
		gbc_tglDrawLine.gridx = 1;
		gbc_tglDrawLine.gridy = 0;
		geometries.add(tglDrawLine, gbc_tglDrawLine);

		tglDrawRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnShapeName = "rectangle";
			}
		});
		tglDrawRectangle.setBackground(new Color(192, 192, 192));
		tglDrawRectangle.setIcon(new ImageIcon(Drawing.class.getResource("/images/Shapes/rectangle.png")));
		GridBagConstraints gbc_tglDrawRectangle = new GridBagConstraints();
		gbc_tglDrawRectangle.insets = new Insets(0, 0, 0, 5);
		gbc_tglDrawRectangle.gridx = 2;
		gbc_tglDrawRectangle.gridy = 0;
		geometries.add(tglDrawRectangle, gbc_tglDrawRectangle);

		tglDrawCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnShapeName = "circle";
			}
		});
		tglDrawCircle.setBackground(new Color(192, 192, 192));
		tglDrawCircle.setIcon(new ImageIcon(Drawing.class.getResource("/images/Shapes/circle.png")));
		GridBagConstraints gbc_tglDrawCircle = new GridBagConstraints();
		gbc_tglDrawCircle.insets = new Insets(0, 0, 0, 5);
		gbc_tglDrawCircle.gridx = 3;
		gbc_tglDrawCircle.gridy = 0;
		geometries.add(tglDrawCircle, gbc_tglDrawCircle);

		tglDrawDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnShapeName = "donut";
			}
		});
		tglDrawDonut.setBackground(new Color(192, 192, 192));
		tglDrawDonut.setIcon(new ImageIcon(Drawing.class.getResource("/images/Shapes/donut.png")));
		GridBagConstraints gbc_tglDrawDonut = new GridBagConstraints();
		gbc_tglDrawDonut.gridx = 4;
		gbc_tglDrawDonut.gridy = 0;
		geometries.add(tglDrawDonut, gbc_tglDrawDonut);

		geometriesGroup.add(tglDrawPoint);
		geometriesGroup.add(tglDrawLine);
		geometriesGroup.add(tglDrawRectangle);
		geometriesGroup.add(tglDrawCircle);
		geometriesGroup.add(tglDrawDonut);

		JLabel lblTools = new JLabel("Tools");
		GridBagConstraints gbc_lblTools = new GridBagConstraints();
		gbc_lblTools.insets = new Insets(0, 0, 0, 5);
		gbc_lblTools.gridx = 1;
		gbc_lblTools.gridy = 1;
		menu.add(lblTools, gbc_lblTools);

		JLabel lblNewLabel = new JLabel("Shapes");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 1;
		menu.add(lblNewLabel, gbc_lblNewLabel);

		canvas = new PnlDrawing();
		shapes = new ArrayList<Shape>();
		canvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Shape obj = null;
				e.getX();
				e.getY();

				if (toolTgl == 0) {

					switch (btnShapeName) {
						case "point": {
							DlgDrawPoint dlgPoint = new DlgDrawPoint();
							dlgPoint.getXCoordinate().setText(Integer.toString(e.getX()));
							dlgPoint.getYCoordinate().setText(Integer.toString(e.getY()));

							try {
								dlgPoint.setVisible(true);

								if (dlgPoint.isOk()) {
									int x = Integer.parseInt(dlgPoint.getXCoordinate().getText());
									int y = Integer.parseInt(dlgPoint.getYCoordinate().getText());

									obj = new Point(x, y, dlgPoint.getPointColor());

									// Add the shape to the shapes list
									addShape(obj);
								}

							} catch (Exception e1) {}
						}
							break;
						case "line": {
							DlgDrawLine dlgLine = new DlgDrawLine();
							if (linePoints[0] == null) {
								linePoints[0] = new Point(e.getX(), e.getY());
							} else if (linePoints[1] == null) {
								linePoints[1] = new Point(e.getX(), e.getY());
								try {
									dlgLine.getX1Coordinate().setText(Integer.toString(linePoints[0].getX()));
									dlgLine.getY1Coordinate().setText(Integer.toString(linePoints[0].getY()));
									dlgLine.getX2Coordinate().setText(Integer.toString(linePoints[1].getX()));
									dlgLine.getY2Coordinate().setText(Integer.toString(linePoints[1].getY()));
									dlgLine.setVisible(true);
									if (dlgLine.isOk()) {
										int x1 = Integer.parseInt(dlgLine.getX1Coordinate().getText());
										int y1 = Integer.parseInt(dlgLine.getY1Coordinate().getText());
										int x2 = Integer.parseInt(dlgLine.getX2Coordinate().getText());
										int y2 = Integer.parseInt(dlgLine.getY2Coordinate().getText());
										Color color = dlgLine.getLineColor();
										
										obj = new Line(new Point(x1, y1), new Point(x2, y2), color);
										addShape(obj);

									}
								} catch (Exception e1) {}		
								linePoints[0] = null;
								linePoints[1] = null;
							}


						}
							break;
						case "rectangle": {
							DlgDrawRectangle dlgRectangle = new DlgDrawRectangle();
							dlgRectangle.getXCoordinate().setText(Integer.toString(e.getX()));
							dlgRectangle.getYCoordinate().setText(Integer.toString(e.getY()));

							try {
								dlgRectangle.setVisible(true);

								if (dlgRectangle.isOk()) {
									int x = Integer.parseInt(dlgRectangle.getXCoordinate().getText());
									int y = Integer.parseInt(dlgRectangle.getYCoordinate().getText());
									int width = Integer.parseInt(dlgRectangle.getTextWidth().getText());
									int height = Integer.parseInt(dlgRectangle.getTextHeight().getText());

									obj = new Rectangle(new Point(x, y), width, height, dlgRectangle.getOutlineColor(),
											dlgRectangle.getFillColor());

									// Add the shape to the shapes list
									addShape(obj);
								}

							} catch (Exception e1) {}

						}
							break;
						case "circle": {
							DlgDrawCircle dlgCircle = new DlgDrawCircle();
							dlgCircle.getXCoordinate().setText(Integer.toString(e.getX()));
							dlgCircle.getYCoordinate().setText(Integer.toString(e.getY()));

							try {
								dlgCircle.setVisible(true);

								if (dlgCircle.isOk()) {
									int x = Integer.parseInt(dlgCircle.getXCoordinate().getText());
									int y = Integer.parseInt(dlgCircle.getYCoordinate().getText());
									int r = Integer.parseInt(dlgCircle.getTextRadius().getText());

									obj = new Circle(new Point(x, y), r, dlgCircle.getOutlineColor(),
											dlgCircle.getFillColor());

									// Add the shape to the shapes list
									addShape(obj);
								}

							} catch (Exception e1) {}
						}
							break;
						case "donut": {
							DlgDrawDonut dlgDonut = new DlgDrawDonut();
							dlgDonut.getXCoordinate().setText(Integer.toString(e.getX()));
							dlgDonut.getYCoordinate().setText(Integer.toString(e.getY()));

							try {
								dlgDonut.setVisible(true);

								if (dlgDonut.isOk()) {
									int x = Integer.parseInt(dlgDonut.getXCoordinate().getText());
									int y = Integer.parseInt(dlgDonut.getYCoordinate().getText());
									int outer = Integer.parseInt(dlgDonut.getOuterRadius().getText());
									int inner = Integer.parseInt(dlgDonut.getInnerRadius().getText());

									obj = new Donut(new Point(x, y), outer, inner, dlgDonut.getFillColor(),
											dlgDonut.getOutlineColor());

									// Add the shape to the shapes list
									addShape(obj);
								}

							} catch (Exception e1) {}

						}
							break;
					}

				} else if (toolTgl == 1) {
					Shape clickedShape = null;

					// Find the last drawn shape that contains the click point
					for (int i = shapes.size() - 1; i >= 0; i--) {
						Shape shape = shapes.get(i);
						if (shape.contains(e.getX(), e.getY())) {
							clickedShape = shape;
							break;
						}
					}

					if (clickedShape != null) {
						// Check if the clicked shape is already selected
						if (selectedShape != clickedShape) {
							// Deselect the previously selected shape
							if (selectedShape != null) {
								selectedShape.setSelected(false);
							}

							// Select the clicked shape
							selectedShape = clickedShape;
							selectedShape.setSelected(true);
						} else {
							// Deselect the clicked shape
							selectedShape.setSelected(false);
							selectedShape = null;
						}
					} else {
						// Deselect the previously selected shape if no shape was clicked
						if (selectedShape != null) {
							selectedShape.setSelected(false);
							selectedShape = null;
						}
					}
				}

				canvas.paintComponent(canvas.getGraphics(), shapes);

			}

		});

		canvas.setBackground(Color.WHITE);
		contentPane.add(canvas, BorderLayout.CENTER);
	}

	public void addShape(Shape shape) {
		shapes.add(shape);
	}

}
