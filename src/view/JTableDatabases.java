package view;

import java.awt.EventQueue;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.TableDatabasesController;
import controller.TableDatabasesModel;
import controller.TableDatabasesMouseClick;

public class JTableDatabases extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblDatabases;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTableDatabases frame = new JTableDatabases();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JTableDatabases() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 100, 643, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 607, 431);
		contentPane.add(scrollPane);
		
		tblDatabases = new JTable();
		scrollPane.setViewportView(tblDatabases);
		String[] cabecalho = new String[3];
		cabecalho[0] = "ID";
		cabecalho[1] = "NAME";
		cabecalho[2] = "CRDATE";
		Object[][] dados = new Object[][]{};
		DefaultTableModel model = new TableDatabasesModel(dados, cabecalho);
		tblDatabases.setModel(model);
		tblDatabases.getColumnModel().getColumn(0).setPreferredWidth(82);
		tblDatabases.getColumnModel().getColumn(1).setPreferredWidth(442);
		tblDatabases.getColumnModel().getColumn(2).setPreferredWidth(100);
		
		MouseListener evento = new TableDatabasesMouseClick(model, tblDatabases);
		tblDatabases.addMouseListener(evento);
		
		TableDatabasesController tbc = new TableDatabasesController();
		try {
			tbc.listaDatabasesTable(model);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), 
					"ERRO", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
