package controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Databases;
import persistence.DatabasesDao;

public class TableDatabasesController {

	public void listaDatabasesTable(DefaultTableModel model)
			throws SQLException {
		DatabasesDao dbDao = new DatabasesDao();
		List<Databases> databases = dbDao.listaDb();
		for (Databases db : databases) {
			Object[] linha = new Object[3];
			linha[0] = db.getId();
			linha[1] = db.getName();
			linha[2] = db.getCrdate();
			model.addRow(linha);
		}
	}

}
