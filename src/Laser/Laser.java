package Laser;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.lang.model.element.Element;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class Laser {

	private JFrame frame;
	private JTable table;
	private JTextField txtImePrezime;
	private JTextField txtBrojTelefona;
	private JTextField txtOperater;
	int x = 0;
	int y = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Laser window = new Laser();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Laser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 850, 700);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 350, 830, 339);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.getTableHeader().setBackground(Color.RED);
		table.getTableHeader().setForeground(Color.white);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "IME I PREZIME", "BROJ TELEFONA", "OPERATER", "KOMENTAR", "MESEC"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, String.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(64);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(103);
		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(JLabel.LEFT);
		table.setDefaultRenderer(String.class, leftRenderer);
		for(int i = 0; i < 6; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(leftRenderer);
		}
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 11, 830, 72);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String[] opcije = new String[2];
				opcije[0] = "Da";
				opcije[1] = "Ne";
				int izlaz = JOptionPane.showOptionDialog(frame.getContentPane(),"Da li zelite da napustite aplikaciju?","IZLAZ", 0,JOptionPane.INFORMATION_MESSAGE,null,opcije,null);
				if(izlaz==0) {
					System.exit(0);
				}
				else {}
			}
		});
		lblX.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblX.setBounds(798, 27, 22, 26);
		panel.add(lblX);
		
		JLabel label = new JLabel("_");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(frame.ICONIFIED);
			}
		});
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(766, 27, 22, 23);
		panel.add(label);
		
		JLabel lblLaser = new JLabel("LASER");
		lblLaser.setForeground(Color.WHITE);
		lblLaser.setBackground(Color.WHITE);
		lblLaser.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				x = arg0.getX();
				y = arg0.getY();
			}
		});
		lblLaser.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				frame.setLocation(arg0.getXOnScreen() - x, arg0.getYOnScreen() - y);
			}
		});
		lblLaser.setHorizontalAlignment(SwingConstants.CENTER);
		lblLaser.setFont(new Font("Stencil", Font.BOLD, 42));
		lblLaser.setBounds(0, 0, 830, 72);
		panel.add(lblLaser);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.RED);
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(10, 94, 830, 245);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblImeIPrezime = new JLabel("Ime i prezime:");
		lblImeIPrezime.setForeground(Color.WHITE);
		lblImeIPrezime.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblImeIPrezime.setBounds(10, 47, 114, 26);
		panel_1.add(lblImeIPrezime);
		
		JLabel lblBrojTelefona = new JLabel("Broj telefona:");
		lblBrojTelefona.setForeground(Color.WHITE);
		lblBrojTelefona.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBrojTelefona.setBounds(10, 84, 114, 26);
		panel_1.add(lblBrojTelefona);
		
		JLabel lblOperater = new JLabel("Operater:");
		lblOperater.setForeground(Color.WHITE);
		lblOperater.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOperater.setBounds(10, 121, 114, 26);
		panel_1.add(lblOperater);
		
		JLabel lblMeseci = new JLabel("Meseci:");
		lblMeseci.setForeground(Color.WHITE);
		lblMeseci.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMeseci.setBounds(10, 158, 114, 26);
		panel_1.add(lblMeseci);
		
		JLabel lblKomentar = new JLabel("Komentar:");
		lblKomentar.setForeground(Color.WHITE);
		lblKomentar.setHorizontalAlignment(SwingConstants.CENTER);
		lblKomentar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblKomentar.setBounds(419, 11, 401, 26);
		panel_1.add(lblKomentar);
		
		txtImePrezime = new JTextField();
		txtImePrezime.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if (!Character.isAlphabetic(arg0.getKeyChar()) && !Character.isWhitespace(arg0.getKeyChar()))
                    arg0.consume();
			}
		});
		txtImePrezime.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtImePrezime.setBounds(120, 52, 223, 20);
		panel_1.add(txtImePrezime);
		txtImePrezime.setColumns(10);
		
		txtBrojTelefona = new JTextField();
		txtBrojTelefona.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		txtBrojTelefona.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtBrojTelefona.setColumns(10);
		txtBrojTelefona.setBounds(120, 89, 223, 20);
		panel_1.add(txtBrojTelefona);
		
		txtOperater = new JTextField();
		txtOperater.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (Character.isDigit(e.getKeyChar()))
                    e.consume();
			}
		});
		txtOperater.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtOperater.setColumns(10);
		txtOperater.setBounds(120, 126, 223, 20);
		panel_1.add(txtOperater);
		
		JComboBox box2 = new JComboBox();
		box2.setBackground(Color.WHITE);
		box2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		box2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		box2.setModel(new DefaultComboBoxModel(new String[] {"Januar", "Februar", "Mart", "April", "Maj", "Jun", "Jul", "Avgust", "Septembar", "Oktobar", "Novembar", "Decembar"}));
		box2.setBounds(120, 158, 145, 26);
		panel_1.add(box2);
		
		JComboBox box3 = new JComboBox();
		box3.setBackground(Color.WHITE);
		box3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		box3.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		box3.setBounds(275, 158, 68, 26);
		panel_1.add(box3);
		
		JLabel lblInformacijeOKorisniku = new JLabel("Informacije o korisnicima:");
		lblInformacijeOKorisniku.setForeground(Color.WHITE);
		lblInformacijeOKorisniku.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformacijeOKorisniku.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInformacijeOKorisniku.setBounds(10, 10, 333, 26);
		panel_1.add(lblInformacijeOKorisniku);
		
		for(int i = 2018; i <=2050; i++) {
			box3.addItem(i);
		}
		
		JTextArea textArea = new JTextArea();
		textArea.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textArea.setBounds(419, 51, 401, 133);
		panel_1.add(textArea);
		
		JButton btnDodajKorisnika = new JButton("Nije platio");
		btnDodajKorisnika.setBackground(Color.WHITE);
		btnDodajKorisnika.setFont(new Font("Rockwell", Font.BOLD, 14));
		btnDodajKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {
					table.setSelectionBackground(Color.red);
				}
				else {
					JOptionPane.showMessageDialog(frame, "Izaberite red u tabeli", "Greska", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnDodajKorisnika.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, Color.BLACK, null));
		btnDodajKorisnika.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDodajKorisnika.setBounds(686, 195, 134, 36);
		panel_1.add(btnDodajKorisnika);
		
		JButton btnPlatio = new JButton("Platio");
		btnPlatio.setBackground(Color.WHITE);
		btnPlatio.setFont(new Font("Rockwell", Font.BOLD, 14));
		btnPlatio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {
					table.setSelectionBackground(Color.green);
				}
				else {
					JOptionPane.showMessageDialog(frame, "Izaberite red u tabeli", "Greska", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnPlatio.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, Color.BLACK, null));
		btnPlatio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPlatio.setBounds(542, 195, 134, 36);
		panel_1.add(btnPlatio);
		
		JButton btnObrisiKorisnika = new JButton("Obrisi korisnika");
		btnObrisiKorisnika.setBackground(Color.WHITE);
		btnObrisiKorisnika.setFont(new Font("Rockwell", Font.BOLD, 14));
		btnObrisiKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {
					((DefaultTableModel)table.getModel()).removeRow(table.getSelectedRow());
				}
				else {
					JOptionPane.showMessageDialog(frame, "Izaberite red u tabeli", "Greska", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnObrisiKorisnika.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, Color.BLACK, null));
		btnObrisiKorisnika.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnObrisiKorisnika.setBounds(399, 195, 134, 36);
		panel_1.add(btnObrisiKorisnika);
		
		JButton button_2 = new JButton("Dodaj korisnika");
		button_2.setBackground(Color.WHITE);
		button_2.setFont(new Font("Rockwell", Font.BOLD, 14));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtImePrezime.getText().equals("")) { 
					JOptionPane.showMessageDialog(frame, "Popunite ime. ", "Greska", JOptionPane.WARNING_MESSAGE);
				}
				else if(txtBrojTelefona.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "Popunite prezime. ", "Greska", JOptionPane.WARNING_MESSAGE);
				}
				else if(txtOperater.getText().equals("")) {
						JOptionPane.showMessageDialog(frame, "Popunite godinu rodjenja. ", "Greska", JOptionPane.WARNING_MESSAGE);
				}
				else {
					Object[] redTabele = {
										  "1",
										  txtImePrezime.getText(), 
										  txtBrojTelefona.getText(), 
										  txtOperater.getText(),
										  textArea.getText(),
										  box2.getSelectedItem().toString() + " " + box3.getSelectedItem().toString()};
										  ((DefaultTableModel)table.getModel()).addRow(redTabele);
				}
			}
		});
		button_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, Color.BLACK, null));
		button_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_2.setBounds(255, 195, 134, 36);
		panel_1.add(button_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setBorder(new LineBorder(Color.WHITE, 2));
		label_1.setBounds(0, 0, 850, 700);
		frame.getContentPane().add(label_1);
		

	}
}
