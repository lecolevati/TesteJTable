package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Databases;
import persistence.DatabasesDao;

public class TableDatabasesMouseClick implements MouseListener {

	private DefaultTableModel model;
	private JTable table;
	
	public TableDatabasesMouseClick(DefaultTableModel model, JTable table) {
		this.model = model;
		this.table = table;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.rowAtPoint(e.getPoint());
//		int col = table.columnAtPoint(e.getPoint());
		int col = 0;
		int dbid = (int) model.getValueAt(row, col);
		DatabasesDao dbDao = new DatabasesDao();
		Databases db = new Databases();
		try {
			db = dbDao.Db(dbid);
			StringBuffer sb = new StringBuffer();
			sb.append(db.getId());
			sb.append("\n");
			sb.append(db.getName());
			sb.append("\n");
			sb.append(db.getCrdate());
			JOptionPane.showMessageDialog(null, sb.toString(),db.toString(),
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(),
					"ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
