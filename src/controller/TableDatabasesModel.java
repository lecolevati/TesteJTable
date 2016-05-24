package controller;

import javax.swing.table.DefaultTableModel;

public class TableDatabasesModel extends DefaultTableModel {

	private static final long serialVersionUID = 1L;

	public TableDatabasesModel(Object[][] dados, Object[] cabecalho) {
		super.setDataVector(dados, cabecalho);
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

}
