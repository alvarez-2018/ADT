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

import mx.flashservicios.adt.Messages.MailServer;
import mx.flashservicios.adt.POJO.Crearcuenta;

public class Rechazada {

	public static void main(String[] archivo) {
		

	}

	@SuppressWarnings({ "deprecation", "static-access" })
	public static void REPORTE_SEGUIMIENTO_DE_VENTAS_NVAS()
			throws IOException, InvalidFormatException, ClassNotFoundException, SQLException {

		FileInputStream archivo = new FileInputStream(
				new File("C:\\Users\\Soporte\\workspace\\PoiJava\\Archivos\\REPORTE_SEGUIMIENTO_DE_VENTAS_NVAS.xlsx"));

		// Se crea el objeto que contendra el libro XLS
		@SuppressWarnings("resource")
		XSSFWorkbook libro = new XSSFWorkbook(archivo);

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
		XSSFSheet fila = libro.getSheetAt(1);
		// Iterator<Row> rowiterator = fila.iterator();

		for (Row row : fila) {
			for (Cell c : row) {

				// System.out.println("Columna: " + c.getColumnIndex());

				switch (c.getColumnIndex()) {
				case 0:
					generic.setEjecutivo_TLMK(c.getStringCellValue());
					break;

				case 1:
					generic.setTipo_de_ingreso(c.getStringCellValue());
					break;

				case 2:
					switch (c.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						if (DateUtil.isCellDateFormatted(c)) {
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd hh:mm:ss");
							String date = sdf.format(c.getDateCellValue());
							generic.setFecha_Vta(date);
						} else {
							generic.setFecha_Vta(String.valueOf(c.getNumericCellValue()));
						}
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
							SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
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
							SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
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
							SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
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
							SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
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
							SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
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
							SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
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
					break;

				case 14:
					switch (c.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						if (DateUtil.isCellDateFormatted(c)) {
							SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
							String date = sdf.format(c.getDateCellValue());
							generic.setTipo_servicio(date);
						} else {
							generic.setTipo_servicio(String.valueOf(c.getNumericCellValue()));
						}
						break;

					case Cell.CELL_TYPE_STRING:
						generic.setTipo_servicio(c.getStringCellValue());
						break;
					}

				case 15:
					switch (c.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						if (DateUtil.isCellDateFormatted(c)) {
							SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
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
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
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
			}
			// }
			listrsnv.add(generic);
		}
		// Lee lista del POJO
		// for (int j = 0; j < listrsnv.size(); j++) {
		//
		// System.out.println("Validación de lista" + " " +
		// listrsnv.get(j).getEjecutivo_TLMK() + " , "
		// + listrsnv.get(j).getTipo_de_ingreso() + " , " +
		// listrsnv.get(j).getFecha_Vta() + " , "
		// + listrsnv.get(j).getHoravta() + " , " + listrsnv.get(j).getCanal() + " , "
		// + listrsnv.get(j).getLocalidad() + " , " +
		// listrsnv.get(j).getLíder_Comercial() + " , "
		// + listrsnv.get(j).getAsesor() + " , " + listrsnv.get(j).getAsesor() + " , "
		// + listrsnv.get(j).getCliente() + " , " + listrsnv.get(j).getNúm_SIV() + " , "
		// + listrsnv.get(j).getNúm_BM() + " , " + listrsnv.get(j).getNo_de_Cuenta() + "
		// ,"
		// + listrsnv.get(j).getTipo_de_cuenta() + " , " +
		// listrsnv.get(j).getPromoción() + " , "
		// + listrsnv.get(j).getFecha_de_Envió_a_DD() + " , " +
		// listrsnv.get(j).getHoraing() + " , "
		// + listrsnv.get(j).getStatus_SIV() + " , " + listrsnv.get(j).getMotivos() + "
		// ,"
		// + listrsnv.get(j).getNO_BL());

		Conexionbd conexionbd = new Conexionbd();
		@SuppressWarnings("unused")
		java.util.Date fecha = new Date();

		try {
			
			java.util.Date date = new Date();
			java.sql.Date fechaActual = new java.sql.Date(date.getTime());

			MailServer mailServer = new MailServer();
			mailServer.setHost("587");
			mailServer.setPort(25);
			mailServer.setFrom("notreplay@operacionesflashmobile.mx");

			String query = "UPDATE adt_clientes SET nombre='tal' WHERE cuenta='123456'";

			PreparedStatement stmt = (PreparedStatement) conexionbd.getConnection().prepareStatement(query);
			stmt.setString(1, generic.getNo_de_Cuenta());
			stmt.setString(2, generic.getNombre());
			stmt.setString(3, generic.getCalle());
			stmt.setString(4, generic.getColonia());
			stmt.setInt(5, generic.getCp());
			stmt.setString(6, generic.getMunicipio());
			stmt.setString(7, generic.getEstado());
			stmt.setInt(8, generic.getTelefono());
			stmt.setString(9, generic.getTipo_servicio());
			stmt.setString(10, generic.getPromoción());
			stmt.setObject(11, convert(generic.getFecha_Vta()));
			stmt.setObject(12, convert(generic.getFecha_Vta()));
			stmt.setObject(13, convert(generic.getFecha_Vta()));
			stmt.setObject(14, convert(generic.getFecha_Vta()));
			stmt.setObject(15, new java.sql.Date(date.getTime()));
			stmt.setString(16, generic.getStatus_SIV());
			stmt.setString(17, generic.getMotivos());
			stmt.setInt(18, generic.getNO_BL());
			stmt.setDouble(19, generic.getFacturacion());
			stmt.setInt(20, generic.getRevenue_counter());
			stmt.setString(21, generic.getService_details());
			stmt.setLong(22, generic.getNo_Customer());

			stmt.executeUpdate();

			System.out.println("Se insertaron los datos");


		} catch (Exception e) {

			System.out.println("[ERROR] No fue posible insertar datos: " + e.getLocalizedMessage());

		}

	}
	
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
