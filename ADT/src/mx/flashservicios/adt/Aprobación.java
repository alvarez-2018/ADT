package mx.flashservicios.adt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import mx.flashservicios.adt.POJO.Aprobarcuenta;
import mx.flashservicios.adt.POJO.Crearcuenta;

public class Aprobación {
	
	private Crearcuenta crearcuenta = new Crearcuenta();

	@SuppressWarnings("deprecation")
	public static void main(String[] archivo)
			throws IOException, InvalidFormatException, ClassNotFoundException, SQLException {

//		Aprobadas_y_Activas_FEB_FY_18_ACN();
//	}

	@SuppressWarnings({ "deprecation", "null" })
//	public static void Aprobadas_y_Activas_FEB_FY_18_ACN()
//			throws IOException, InvalidFormatException, ClassNotFoundException, SQLException {
//		FileInputStream archivo = new FileInputStream(new File(
//				"C:\\Users\\Soporte\\workspace\\PoiJava\\Archivos\\REPORTE_DE_AUTORIZACIONES_ACTIVACIONES_Y_BACKLOG.xlsx"));
	
	FileInputStream arc = new FileInputStream(
			new File(archivo[1]));

		// Se crea el objeto que contendra el libro XLS
		@SuppressWarnings("resource")
		XSSFWorkbook libro = new XSSFWorkbook(arc);

		/**
		 * Obtenemos la primera pestaña a la que se quiera procesar indicando el indice.
		 * Una vez obtenida la hoja excel con las filas que se quieren leer obtenemos el
		 * iterator que nos permite recorrer cada una de las filas que contiene.
		 */

		// int Hoja = libro.getNumberOfSheets();
		// System.out.println("Hojas: " + Hoja);

		/**
		 * For que recorre las hojas que existen en el archivo
		 */
		List<Aprobarcuenta> listaprob = new ArrayList<Aprobarcuenta>();
		// for (int i = 0; i < Hoja; i++) {
		// System.out.println("Hoja #: " + i + " Nombre: " + libro.getSheetName(i));

		Aprobarcuenta generico = new Aprobarcuenta();
		XSSFSheet fila = libro.getSheetAt(0);
		// Iterator<Row> rowiterator = fila.iterator();

		for (Row row : fila) {
			for (int vc = 0; vc < row.getLastCellNum(); vc++) {
				for (Cell c : row) {

					// System.out.println("Columna: " + c.getColumnIndex());

					switch (c.getColumnIndex()) {
					case 0:
						// cs_no
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generico.setNo_de_Cuenta(date);
							} else {
								generico.setNo_de_Cuenta(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generico.setNo_de_Cuenta(c.getStringCellValue());
							break;
						}

					case 1:
						// Nombre Cliente
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generico.setNombre_Cliente(date);
							} else {
								generico.setNombre_Cliente(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generico.setNombre_Cliente(c.getStringCellValue());
							break;
						}
					case 2:
						// Fecha Crea
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generico.setFecha_creacion(date);
							} else {
								generico.setFecha_creacion(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generico.setFecha_creacion(c.getStringCellValue());
							break;
						}

					case 3:
						// Status
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generico.setStatus(date);
							} else {
								generico.setStatus(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generico.setStatus(c.getStringCellValue());
							break;
						}

					case 4:
						// Tipo Monitoreo
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generico.setTipo_Monitoreo(date);
							} else {
								generico.setTipo_Monitoreo(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generico.setTipo_Monitoreo(c.getStringCellValue());
							break;
						}

					case 5:
						// Companía
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generico.setCompanía(date);
							} else {
								generico.setCompanía(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generico.setCompanía(c.getStringCellValue());
							break;
						}

					case 6:
						// Vendedor
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generico.setVendedor(date);
							} else {
								generico.setVendedor(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generico.setVendedor(String.valueOf(c.getStringCellValue()));
							break;
						}
					case 7:
						// # Brand leader
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							generico.setNo_BranLeader((long) c.getNumericCellValue());
							break;
						}

					case 8:
						// Lider
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generico.setLider(date);
							} else {
								generico.setLider(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generico.setLider(c.getStringCellValue());
							break;
						}
						break;

					case 9:
						// Localidad
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generico.setLocalidad(date);
							} else {
								generico.setLocalidad(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generico.setLocalidad(c.getStringCellValue());
							break;
						}
						break;

					case 10:
						// Gerente
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generico.setGerente(date);
							} else {
								generico.setGerente(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generico.setGerente(c.getStringCellValue());
							break;
						}
						break;

					case 11:
						// Tipo Pago
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generico.setTipo_Pago(date);
							} else {
								generico.setTipo_Pago(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generico.setTipo_Pago(c.getStringCellValue());
							break;
						}
						break;

					case 12:
						// Forma de Pago
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generico.setForma_de_Pago(date);
							} else {
								generico.setForma_de_Pago(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generico.setForma_de_Pago(c.getStringCellValue());
							break;
						}
						break;
					case 13:
						// No Dealer
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generico.setNo_Dealer(date);
							} else {
								generico.setNo_Dealer(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generico.setNo_Dealer(c.getStringCellValue());
							break;
						}
					case 14:
						// CONTRACT_TYPE
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generico.setCONTRACT_TYPE(date);
							} else {
								generico.setCONTRACT_TYPE(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generico.setCONTRACT_TYPE(c.getStringCellValue());
							break;
						}

					case 15:
						// DURATION
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generico.setDURATION(date);
							} else {
								generico.setDURATION(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generico.setDURATION(c.getStringCellValue());
							break;
						}

					case 16:
						// PACKAGE_TYPE
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generico.setPACKAGE_TYPE(date);
							} else {
								generico.setPACKAGE_TYPE(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generico.setPACKAGE_TYPE(c.getStringCellValue());
							break;
						}

					case 17:
						// RISK
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generico.setRISK(date);
							} else {
								generico.setRISK(String.valueOf(c.getNumericCellValue()));
							}
							break;
						case Cell.CELL_TYPE_STRING:
							generico.setRISK(c.getStringCellValue());
							break;
						}

					case 18:
						// INITIAL_PAYM_DIMENS_VALUE_1
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generico.setINITIAL_PAYM_DIMENS_VALUE_1(date);
							} else {
								generico.setINITIAL_PAYM_DIMENS_VALUE_1(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generico.setINITIAL_PAYM_DIMENS_VALUE_1(c.getStringCellValue());
							break;
						}

					case 19:
						// MODIFICATION_DATE
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generico.setMODIFICATION_DATE(date);
							} else {
								generico.setMODIFICATION_DATE(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generico.setMODIFICATION_DATE(c.getStringCellValue());
							break;
						}

					case 20:
						// STATUS_LOG_CONTRACT
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generico.setSTATUS_LOG_CONTRACT(date);
							} else {
								generico.setSTATUS_LOG_CONTRACT(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generico.setSTATUS_LOG_CONTRACT(c.getStringCellValue());
							break;
						}

					case 21:
						// kit
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generico.setKit(date);
							} else {
								generico.setKit(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generico.setKit(c.getStringCellValue());
							break;
						}

					case 22:
						// gastos admin
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generico.setGastos_admin(date);
							} else {
								generico.setGastos_admin(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generico.setGastos_admin(c.getStringCellValue());
							break;
						}
						break;

					case 23:
						// autorizacion
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generico.setAutorizacion(date);
							} else {
								generico.setAutorizacion(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generico.setAutorizacion(c.getStringCellValue());
							break;
						}
						break;

					case 24:
						// Calificacion
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generico.setCalificacion(date);
							} else {
								generico.setCalificacion(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generico.setCalificacion(c.getStringCellValue());
							break;
						}
						break;

					case 25:
						// Hoja de Credito
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generico.setHoja_de_Credito(date);
							} else {
								generico.setHoja_de_Credito(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generico.setHoja_de_Credito(c.getStringCellValue());
							break;
						}
						break;

					case 26:
						// STATE
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generico.setSTATE(date);
							} else {
								generico.setSTATE(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generico.setSTATE(c.getStringCellValue());
							break;
						}
						break;

					case 27:
						// nombre_sup
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generico.setNombre_sup(date);
							} else {
								generico.setNombre_sup(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generico.setNombre_sup(c.getStringCellValue());
							break;
						}
						break;

					case 28:
						// BRANCH_NAME
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generico.setBRANCH_NAME(date);
							} else {
								generico.setBRANCH_NAME(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generico.setBRANCH_NAME(c.getStringCellValue());
							break;
						}
						break;

					case 29:
						// CUSTOMER_TYPE
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generico.setCUSTOMER_TYPE(date);
							} else {
								generico.setCUSTOMER_TYPE(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generico.setCUSTOMER_TYPE(c.getStringCellValue());
							break;
						}
						break;

					case 30:
						// ENTRY_CHANNELID
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generico.setENTRY_CHANNELID(date);
							} else {
								generico.setENTRY_CHANNELID(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generico.setENTRY_CHANNELID(c.getStringCellValue());
							break;
						}
						break;

					case 31:
						// PROSPECTID
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generico.setPROSPECTID(date);
							} else {
								generico.setPROSPECTID(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generico.setPROSPECTID(c.getStringCellValue());
							break;
						}
						break;
					}

				}
			}
			listaprob.add(generico);
		}

		// for (int j = 0; j < listaprob.size(); j++) {
		// System.out.println("Lista: " + " " + listaprob.get(j).getNo_de_Cuenta() + ",
		// "
		// + listaprob.get(j).getNombre_Cliente() + ", " +
		// listaprob.get(j).getFecha_creacion() + " ,"
		// + listaprob.get(j).getStatus() + ", " + listaprob.get(j).getTipo_Monitoreo()
		// + ", "
		// + listaprob.get(j).getCompanía() + " ," + listaprob.get(j).getVendedor() + ",
		// "
		// + listaprob.get(j).getNo_BranLeader() + ", " + listaprob.get(j).getLider() +
		// ", "
		// + listaprob.get(j).getLocalidad() + ", " + listaprob.get(j).getGerente() + ",
		// "
		// + listaprob.get(j).getTipo_Pago() + ", " +
		// listaprob.get(j).getForma_de_Pago() + ", "
		// + listaprob.get(j).getNo_Dealer() + ", " +
		// listaprob.get(j).getCONTRACT_TYPE() + ", "
		// + listaprob.get(j).getDURATION() + ", " + listaprob.get(j).getPACKAGE_TYPE()
		// + ", "
		// + listaprob.get(j).getRISK() + ", " +
		// listaprob.get(j).getINITIAL_PAYM_DIMENS_VALUE_1() + ", "
		// + listaprob.get(j).getMODIFICATION_DATE() + ", " +
		// listaprob.get(j).getSTATUS_LOG_CONTRACT() + ", "
		// + listaprob.get(j).getKit() + ", " + listaprob.get(j).getGastos_admin() + ",
		// "
		// + listaprob.get(j).getAutorizacion() + ", " +
		// listaprob.get(j).getCalificacion() + ", "
		// + listaprob.get(j).getHoja_de_Credito() + ", " + listaprob.get(j).getSTATE()
		// + ", "
		// + listaprob.get(j).getNombre_sup() + ", " + listaprob.get(j).getBRANCH_NAME()
		// + ", "
		// + listaprob.get(j).getCUSTOMER_TYPE() + ", " +
		// listaprob.get(j).getENTRY_CHANNELID() + ", "
		// + listaprob.get(j).getPROSPECTID());
		// }

		Conexionbd conexionbd = new Conexionbd();

		try {

			// Realizo mi barrido de base de datos
			java.util.Date date = new Date();
			java.sql.Date fechaActual = new java.sql.Date(date.getTime());
			Statement st = (Statement) conexionbd.connection.createStatement();
			String query = "SELECT * FROM ADT_CLIENTESTEST";
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(generico.getNo_de_Cuenta());
				// Ingresa a base de datos para verificar si existe
				if (rs.getString(1).equals(generico.getNo_de_Cuenta())) {
					System.out.println("si existe");
				}else {
					System.out.println("no existe");
				}
			}
					PreparedStatement stmt = (PreparedStatement) conexionbd.getConnection().prepareStatement(
							"UPDATE ADT_CLIENTESTEST set cuenta=?, nombre=?, calle=?, colonia=?, cp=?, municipio=?, estado=?, telefono=?, tipo_servicio=?, plan=?, fecha_venta=?, fecha_activacion=?, fecha_cancelacion=?, fecha_instalacion=?, fecha_update=?, status=?, desripcion=?, no_bl=?, facturacion=?, revenue_counter=?, service_details=?, no_cliente=? WHERE cuenta='"+generico.getNo_de_Cuenta()+"'");
				
					
					 stmt.setString(1, generico.getNo_de_Cuenta());
					 stmt.setString(2, generico.getNombre_Cliente());
					 stmt.setString(3, "n/a");
					 stmt.setString(4, "n/a");
					 stmt.setInt(5, 0);
					 stmt.setString(6, "n/a");
					 stmt.setString(7, "n/a");
					 stmt.setInt(8, 0);
					 stmt.setString(9, generico.getTipo_Monitoreo());
					 stmt.setString(10, generico.getCompanía());
					 stmt.setObject(11, convert(generico.getFecha_creacion()));
					 stmt.setObject(12, convert(generico.getFecha_activacion()));
					 stmt.setObject(13, convert(generico.getFecha_cancelacion()));
					 stmt.setObject(14, convert(generico.getFecha_instalacion()));
					 stmt.setObject(15, new java.sql.Date(date.getTime()));
					 stmt.setString(16, generico.getStatus());
					 stmt.setString(17, generico.getSTATE());
					 stmt.setLong(18, generico.getNo_BranLeader());
					 stmt.setDouble(19, 0);
					 stmt.setInt(20, 0);
					 stmt.setString(21, generico.getTipo_Pago());
					 stmt.setLong(22, generico.getNo_Customer());
					
					stmt.executeUpdate();
					
					 System.out.println("Se actualizaron los datos correctamente");
					 
		} catch (Exception e) {

			System.out.println("[ERROR] No fue posible insertar datos: " + e.getLocalizedMessage());
		}

	}

	//
	public static Timestamp convert(String str_date) {
		try {
			DateFormat formatter;
			formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date date = (Date) formatter.parse(str_date);
			java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());

			return timeStampDate;
		} catch (ParseException e) {
			System.out.println("Exception :" + e);
			return null;

		}
	}
	
	static List<Crearcuenta> lstSingleton;
	
	 public static List<Crearcuenta> getlstSingleton() {
	        if(lstSingleton == null){
	            lstSingleton = new ArrayList<Crearcuenta>();
	        }
	        return lstSingleton;
	    }
}
