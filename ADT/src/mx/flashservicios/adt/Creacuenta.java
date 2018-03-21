package mx.flashservicios.adt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

import mx.flashservicios.adt.POJO.Crearcuenta;
import mx.flashservicios.adt.lista.ListaAprobacion;

public class Creacuenta {

	@SuppressWarnings("deprecation")
	public static void main(String archivo[])
			throws IOException, InvalidFormatException, ClassNotFoundException, SQLException {

		REPORTE_SEGUIMIENTO_DE_VENTAS_NVAS();
	}

	//
	@SuppressWarnings({ "deprecation", "static-access" })
	public static void REPORTE_SEGUIMIENTO_DE_VENTAS_NVAS()
			throws IOException, InvalidFormatException, ClassNotFoundException, SQLException {

		FileInputStream arc = new FileInputStream(
				new File("C:\\Users\\Soporte\\workspace\\PoiJava\\Archivos\\REPORTE_SEGUIMIENTO_DE_VENTAS_NVAS.xlsx"));

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

		List<Crearcuenta> listrsnv = new ArrayList<Crearcuenta>();

		// for (int i = 0; i < Hoja; i++) {
		// System.out.println("Hoja #: " + i + " Nombre: " + libro.getSheetName(i));

		Crearcuenta generic = new Crearcuenta();
		XSSFSheet fila = libro.getSheetAt(0);
		// Iterator<Row> rowiterator = fila.iterator();

		for (Row row : fila) {
//			for (int vc = 0; vc < row.getLastCellNum(); vc++) {
				// Cell cell = row.getCell(vc, CREATE_NULL_AS_BLANK);
				for (Cell c : row) {

					// System.out.println("Columna: " + c.getColumnIndex());

					switch (c.getColumnIndex()) {
					case 0:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setEjecutivo_TLMK(date);
							} else {
								generic.setEjecutivo_TLMK(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setEjecutivo_TLMK(c.getStringCellValue());
							System.out.println(generic.getEjecutivo_TLMK());
							break;
						}

					case 1:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setTipo_de_ingreso(date);
							} else {
								generic.setTipo_de_ingreso(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setTipo_de_ingreso(c.getStringCellValue());
							System.out.println(generic.getTipo_de_ingreso());
							break;
						}

					case 2:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
							String date = sdf.format(c.getDateCellValue());
							generic.setFecha_Vta(date);
							break;
						}

					case 3:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
								String date = sdf.format(c.getDateCellValue());
								generic.setHoravta(date);
							} else {
								generic.setHoravta(String.valueOf(c.getNumericCellValue()));
							}
							break;
						}

					case 4:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setCanal(date);
							} else {
								generic.setCanal(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setCanal(c.getStringCellValue());
							break;
						}

					case 5:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setLocalidad(date);
							} else {
								generic.setLocalidad(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setLocalidad(c.getStringCellValue());
							break;
						}

					case 6:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setLíder_Comercial(date);
							} else {
								generic.setLíder_Comercial(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setLíder_Comercial(c.getStringCellValue());
							break;
						}

					case 7:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							generic.setNo_BranLeader((long) c.getNumericCellValue());
							break;
						}

					case 8:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setAsesor(date);
							} else {
								generic.setAsesor(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setAsesor(c.getStringCellValue());
							break;
						}

					case 9:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setCliente(date);
							} else {
								generic.setCliente(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setCliente(c.getStringCellValue());
							break;
						}

					case 10:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							generic.setNúm_SIV((long) c.getNumericCellValue());
							break;
						}

					case 11:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							generic.setNúm_BM((long) c.getNumericCellValue());
							break;
						}

					case 12:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setNo_de_Cuenta(date);
							} else {
								generic.setNo_de_Cuenta(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setNo_de_Cuenta(c.getStringCellValue());
							break;
						}

					case 13:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							generic.setNo_Customer((long) c.getNumericCellValue());
							break;
						}

					case 14:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
								String date = sdf.format(c.getDateCellValue());
								generic.setTipo_de_cuenta(date);
							} else {
								generic.setTipo_de_cuenta(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setTipo_de_cuenta(c.getStringCellValue());
							break;
						}

					case 15:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setPromoción(date);
							} else {
								generic.setPromoción(String.valueOf(c.getNumericCellValue()));
							}
							break;
						case Cell.CELL_TYPE_STRING:
							generic.setPromoción(c.getStringCellValue());
							break;
						}
					case 16:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss" + "");
								String date = sdf.format(c.getDateCellValue());
								generic.setFecha_de_Envió_a_DD(date);
							} else {
								generic.setFecha_de_Envió_a_DD(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setFecha_de_Envió_a_DD(c.getStringCellValue());
							break;
						}
					case 17:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
								String date = sdf.format(c.getDateCellValue());
								generic.setHoraing(date);
							} else {
								generic.setHoraing(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setHoraing(c.getStringCellValue());
							break;
						}
					case 18:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
								String date = sdf.format(c.getDateCellValue());
								generic.setStatus_SIV(date);
							} else {
								generic.setStatus_SIV(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setStatus_SIV(c.getStringCellValue());
							break;
						}
					case 19:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
								String date = sdf.format(c.getDateCellValue());
								generic.setMotivos(date);
							} else {
								generic.setMotivos(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setMotivos(c.getStringCellValue());
							break;
						}

					}
//				}
			}

			listrsnv.add(generic);
		}

//		for (int j = 0; j < listrsnv.size(); j++) {
//
//			System.out.println("0.- " + listrsnv.get(j).getEjecutivo_TLMK());
//			System.out.println("1.- " + listrsnv.get(j).getTipo_de_ingreso());
//			System.out.println("2.- " + listrsnv.get(j).getFecha_Vta());
//			System.out.println("3.- " + listrsnv.get(j).getHoravta());
//			System.out.println("4.- " + listrsnv.get(j).getCanal());
//			System.out.println("5.- " + listrsnv.get(j).getLocalidad());
//			System.out.println("6.- " + listrsnv.get(j).getLíder_Comercial());
//			System.out.println("7.- " + listrsnv.get(j).getNo_BranLeader());
//			System.out.println("8.- " + listrsnv.get(j).getAsesor());
//			System.out.println("9.- " + listrsnv.get(j).getCliente());
//			System.out.println("10.- " + listrsnv.get(j).getNúm_SIV());
//			System.out.println("11.- " + listrsnv.get(j).getNúm_BM());
//			System.out.println("12.- " + listrsnv.get(j).getNo_de_Cuenta());
//			System.out.println("13.- " + listrsnv.get(j).getNo_Customer());
//			System.out.println("14.- " + listrsnv.get(j).getTipo_de_cuenta());
//			System.out.println("15.- " + listrsnv.get(j).getPromoción());
//			System.out.println("16.- " + listrsnv.get(j).getFecha_de_Envió_a_DD());
//			System.out.println("17.- " + listrsnv.get(j).getHoraing());
//			System.out.println("18.- " + listrsnv.get(j).getStatus_SIV());
//			System.out.println("19.- " + listrsnv.get(j).getMotivos());

			 Conexionbd conexionbd = new Conexionbd();
			
			 try {
			
			 java.util.Date date = new Date();
			 java.sql.Date fechaActual = new java.sql.Date(date.getTime());
			
			 PreparedStatement stmt = (PreparedStatement)
			 conexionbd.getConnection().prepareStatement(
			 "INSERT INTO ADT_CLIENTESTEST (cuenta, nombre, calle, colonia, cp, municipio, estado, telefono, tipo_servicio, plan, fecha_venta, fecha_activacion, fecha_cancelacion, fecha_instalacion, fecha_update, status, desripcion, no_bl, facturacion, revenue_counter, service_details, no_cliente) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			 stmt.setString(1, generic.getNo_de_Cuenta()); // '1000-0000-0'
			 stmt.setString(2, generic.getCliente()); // MIGUEL ALVAREZ AGUILERA
			 stmt.setString(3, "n/a"); // n/a
			 stmt.setString(4, "n/a"); // n/a
			 stmt.setInt(5, 0); // 0
			 stmt.setString(6, "n/a"); // n/a
			 stmt.setString(7, "n/a"); // n/a 
			 stmt.setInt(8, 0); // 0
			 stmt.setString(9, generic.getTipo_de_cuenta()); // NULL
			 stmt.setString(10, generic.getPromoción()); // ADT PLAN
			 stmt.setObject(11, convert(generic.getFecha_Vta())); // 2018-2-13 0:0:0.000000 -6:0
			 stmt.setObject(12, convert(generic.getFecha_activacion())); // 1990-1-1 0:0:0.000000 -6:0
			 stmt.setObject(13, convert(generic.getFecha_cancelacion())); // 1990-1-1 0:0:0.000000 -6:0
			 stmt.setObject(14, convert(generic.getFecha_instalacion())); // 1990-1-1 0:0:0.000000 -6:0
			 stmt.setObject(15, new java.sql.Date(date.getTime())); // 2018-3-6 -6:0
			 stmt.setString(16, generic.getStatus_SIV()); // SOLICITUD INGRESADA
			 stmt.setString(17, generic.getMotivos()); // SOLICITUD EN PROCESO
			 stmt.setLong(18, generic.getNo_BranLeader()); // 650000009
			 stmt.setDouble(19, 0); // 0.0
			 stmt.setInt(20, 0); // 0
			 stmt.setString(21, generic.getPromoción()); // ADT PLAN
			 stmt.setLong(22, generic.getNo_Customer()); // 12345678
			 
//			 ListaAprobacion listaAprobacion = new ListaAprobacion();
//				
//				 listaAprobacion.setCuenta(generic.getNo_de_Cuenta());
//				 listaAprobacion.setNombre(generic.getCliente());
//				 listaAprobacion.setCalle("N/A");
//				 listaAprobacion.setColonia("N/A");
//				 listaAprobacion.setCp(0);
//				 listaAprobacion.setMunicipio("N/A");
//				 listaAprobacion.setEstado("N/A");
//				 listaAprobacion.setTelefono((long) 0);
//				 listaAprobacion.setTipo_servicio(generic.getTipo_servicio());
//				 listaAprobacion.setPlan(generic.getPromoción());
//				// listaAprobacion.setFecha_venta(convert(generic.getFecha_Vta()));
//				// listaAprobacion.setFecha_activacion(convert(generic.getFecha_activacion()));
//				// listaAprobacion.setFecha_cancelacion(convert(generic.getFecha_cancelacion()));
//				// listaAprobacion.setFecha_instalacion(convert(generic.getFecha_instalacion()));
//				// listaAprobacion.setFecha_update(new java.sql.Date(date.getTime()));
//				 listaAprobacion.setStatus(generic.getStatus_SIV());
//				 listaAprobacion.setDesripcion(generic.getMotivos());
//				 listaAprobacion.setNo_bl(generic.getNo_BranLeader());
//				 listaAprobacion.setFacturacion(0);
//				 listaAprobacion.setRevenue_counter((double) 0);
//				 listaAprobacion.setService_details(generic.getPromoción());
//				 listaAprobacion.setNo_cliente(generic.getNo_Customer());

			 stmt.execute();
			 
			 System.out.println("Se insertaron los datos");

			// }

			 } catch (Exception e) {
			
			 System.out.println("[ERROR] No fue posible insertar datos: " +
			 e.getLocalizedMessage());

			 }
		}

//	}

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

}
