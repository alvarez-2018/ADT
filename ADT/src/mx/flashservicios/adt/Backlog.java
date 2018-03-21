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

import mx.flashservicios.adt.POJO.Backlogcuenta;

public class Backlog {

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
			new File(archivo[3]));
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
		List<Backlogcuenta> listback = new ArrayList<Backlogcuenta>();
		// for (int i = 0; i < Hoja; i++) {
		// System.out.println("Hoja #: " + i + " Nombre: " + libro.getSheetName(i));

		Backlogcuenta generic = new Backlogcuenta();
		XSSFSheet fila = libro.getSheetAt(3);
		// Iterator<Row> rowiterator = fila.iterator();

		for (Row row : fila) {
//			for (int vc = 0; vc < row.getLastCellNum(); vc++) {
				for (Cell c : row) {

					switch (c.getColumnIndex()) {
					case 0:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
								generic.setProspect((long) c.getNumericCellValue());
							break;
						}

					case 1:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setCuenta_en_Job(date);
							} else {
								generic.setCuenta_en_Job(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setCuenta_en_Job(c.getStringCellValue());
							break;
						}

					case 2:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
								generic.setJob((long) c.getNumericCellValue());
							break;
						}
						
					case 3:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
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

					case 4:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setDireccion(date);
							} else {
								generic.setDireccion(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setDireccion(c.getStringCellValue());
							break;
						}

					case 5:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setDir_2(date);
							} else {
								generic.setDir_2(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setDir_2(c.getStringCellValue());
							break;
						}

					case 6:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setCalle(date);
							} else {
								generic.setCalle(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setCalle(c.getStringCellValue());
							break;
						}

					case 7:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setColonia(date);
							} else {
								generic.setColonia(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setColonia(String.valueOf(c.getStringCellValue()));
							break;
						}
						
					case 8:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setMunicipio(date);
							} else {
								generic.setMunicipio(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setMunicipio(c.getStringCellValue());
							break;
						}

					case 9:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setEstado(date);
							} else {
								generic.setEstado(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setEstado(c.getStringCellValue());
							break;
						}

					case 10:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setCP(date);
							} else {
								generic.setCP(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setCP(c.getStringCellValue());
							break;
						}

//					case 11:
//						switch (c.getCellType()) {
//						case Cell.CELL_TYPE_NUMERIC:
//							if (DateUtil.isCellDateFormatted(c)) {
//								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
//								String date = sdf.format(c.getDateCellValue());
//								generic.setCP(date);
//							} else {
//								generic.setCP(String.valueOf(c.getNumericCellValue()));
//							}
//							break;
//
//						case Cell.CELL_TYPE_STRING:
//							generic.setCP(c.getStringCellValue());
//							break;
//						}

					case 11:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setTelefono_1(date);
							} else {
								generic.setTelefono_1(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setTelefono_1(c.getStringCellValue());
							break;
						}

					case 12:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setTelefono_2(date);
							} else {
								generic.setTelefono_2(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setTelefono_2(c.getStringCellValue());
							break;
						}
					case 13:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setTipo_de_Monitoreo(date);
							} else {
								generic.setTipo_de_Monitoreo(String.valueOf(c.getNumericCellValue()));
							}
							break;
						case Cell.CELL_TYPE_STRING:
							generic.setTipo_de_Monitoreo(c.getStringCellValue());
							break;
						}
					case 14:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setArea_de_Servicio(date);
							} else {
								generic.setArea_de_Servicio(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setArea_de_Servicio(c.getStringCellValue());
							break;
						}
					case 15:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setMapa(date);
							} else {
								generic.setMapa(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setMapa(c.getStringCellValue());
							break;
						}
					case 16:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setCoordenadas(date);
							} else {
								generic.setCoordenadas(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setCoordenadas(c.getStringCellValue());
							break;
						}
					case 17:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setFecha_creacion(date);
							} else {
								generic.setFecha_creacion(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setFecha_creacion(c.getStringCellValue());
							break;
						}

					case 18:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setBranch(date);
							} else {
								generic.setBranch(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setBranch(c.getStringCellValue());
							break;
						}
						break;

					case 19:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setStatus_job(date);
							} else {
								generic.setStatus_job(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setStatus_job(c.getStringCellValue());
							break;
						}
						break;

					case 20:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setStatus_Prospecto(date);
							} else {
								generic.setStatus_Prospecto(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setStatus_Prospecto(c.getStringCellValue());
							break;
						}
						break;

					case 21:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setCuenta_en_Prospecto(date);
							} else {
								generic.setCuenta_en_Prospecto(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setCuenta_en_Prospecto(c.getStringCellValue());
							break;
						}
						break;

					case 22:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setSite(date);
							} else {
								generic.setSite(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setSite(c.getStringCellValue());
							break;
						}
						break;

					case 23:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setTipo_de_Job(date);
							} else {
								generic.setTipo_de_Job(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setTipo_de_Job(c.getStringCellValue());
							break;
						}
						break;

					case 24:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setFecha_compromiso(date);
							} else {
								generic.setFecha_compromiso(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setFecha_compromiso(c.getStringCellValue());
							break;
						}
						break;

					case 25:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setHora_compromiso_inicial(date);
							} else {
								generic.setHora_compromiso_inicial(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setHora_compromiso_inicial(c.getStringCellValue());
							break;
						}
						break;

					case 26:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setHora_compromiso_final(date);
							} else {
								generic.setHora_compromiso_final(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setHora_compromiso_final(c.getStringCellValue());
							break;
						}
						break;

					case 27:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setTipo_panel(date);
							} else {
								generic.setTipo_panel(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setTipo_panel(c.getStringCellValue());
							break;
						}
						break;

					case 28:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setCause(date);
							} else {
								generic.setCause(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setCause(c.getStringCellValue());
							break;
						}
						break;

					case 29:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setResolution(date);
							} else {
								generic.setResolution(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setResolution(c.getStringCellValue());
							break;
						}
						break;

					case 30:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setAsignado(date);
							} else {
								generic.setAsignado(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setAsignado(c.getStringCellValue());
							break;
						}
						break;

					case 31:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setClasificacion(date);
							} else {
								generic.setClasificacion(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setClasificacion(c.getStringCellValue());
							break;
						}
						break;

					case 32:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setRegion(date);
							} else {
								generic.setRegion(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setRegion(c.getStringCellValue());
							break;
						}
						break;

					case 33:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setOs_Asignado(date);
							} else {
								generic.setOs_Asignado(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setOs_Asignado(c.getStringCellValue());
							break;
						}
						break;

					case 34:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setOutsourcer(date);
							} else {
								generic.setOutsourcer(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setOutsourcer(c.getStringCellValue());
							break;
						}
						break;

					case 35:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setRegion(date);
							} else {
								generic.setRegion(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setRegion(c.getStringCellValue());
							break;
						}
						break;

					case 36:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setDescripción(date);
							} else {
								generic.setDescripción(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setDescripción(c.getStringCellValue());
							break;
						}
						break;

					case 37:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setComentario(date);
							} else {
								generic.setComentario(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setComentario(c.getStringCellValue());
							break;
						}
						break;

					case 38:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setTipo_Customer(date);
							} else {
								generic.setTipo_Customer(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setTipo_Customer(c.getStringCellValue());
							break;
						}
						break;

					case 39:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setTiempo_Instalacion(date);
							} else {
								generic.setTiempo_Instalacion(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setTiempo_Instalacion(c.getStringCellValue());
							break;
						}
						break;

					case 40:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
								generic.setSales_emp_no((long) c.getNumericCellValue());
							break;
						}

					case 41:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setNom_vendedor(date);
							} else {
								generic.setNom_vendedor(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setNom_vendedor(c.getStringCellValue());
							break;
						}
						break;

					case 42:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setZonas(date);
							} else {
								generic.setZonas(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setZonas(c.getStringCellValue());
							break;
						}
						break;

					case 43:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setResponsable(date);
							} else {
								generic.setResponsable(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setResponsable(c.getStringCellValue());
							break;
						}
						break;

					case 44:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setStatus(date);
							} else {
								generic.setStatus(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setStatus(c.getStringCellValue());
							break;
						}
						break;

					case 45:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setFecha_onsite(date);
							} else {
								generic.setFecha_onsite(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setFecha_onsite(c.getStringCellValue());
							break;
						}
						break;

					case 46:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setHora_onsite(date);
							} else {
								generic.setHora_onsite(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setHora_onsite(c.getStringCellValue());
							break;
						}
						break;

					case 47:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setVendedor(date);
							} else {
								generic.setVendedor(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setVendedor(c.getStringCellValue());
							break;
						}
						break;

					case 48:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setLider(date);
							} else {
								generic.setLider(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setLider(c.getStringCellValue());
							break;
						}
						break;

					case 49:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setGerente(date);
							} else {
								generic.setGerente(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setGerente(c.getStringCellValue());
							break;
						}
						break;

					case 50:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setNombre_Vendedor(date);
							} else {
								generic.setNombre_Vendedor(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setNombre_Vendedor(c.getStringCellValue());
							break;
						}
						break;

					case 51:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setClasificacion(date);
							} else {
								generic.setClasificacion(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setClasificacion(c.getStringCellValue());
							break;
						}
						break;

					case 52:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setNo_Empleado(date);
							} else {
								generic.setNo_Empleado(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setNo_Empleado(c.getStringCellValue());
							break;
						}
						break;

					case 53:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setNotas_de_Direccion(date);
							} else {
								generic.setNotas_de_Direccion(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setNotas_de_Direccion(c.getStringCellValue());
							break;
						}
						break;

					case 54:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setPackage(date);
							} else {
								generic.setPackage(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setPackage(c.getStringCellValue());
							break;
						}
						break;
					case 55:
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
								generic.setTecchnicalType((long) c.getNumericCellValue());
							break;
						}
					}

//				}
			}
			// }
			listback.add(generic);
		}
		
//		for (int j = 0; j < listback.size(); j++) {
//			System.out.println("Lista: " + " " + listback.get(j).getProspect() + ", "
//					+ listback.get(j).getCuenta_en_Job() + ", " + listback.get(j).getJob() + " ,"
//					+ listback.get(j).getCliente() + ", " + listback.get(j).getDireccion() + " "
//					+ listback.get(j).getDir_2() + " ," + listback.get(j).getCalle() + ", "
//					+ listback.get(j).getColonia() + ", " + listback.get(j).getMunicipio() + ", "
//					+ listback.get(j).getEstado() + ", " + listback.get(j).getCp() + ", "
//					+ listback.get(j).getTelefono() + ", " + listback.get(j).getTelefono_1() + ", "
//					+ listback.get(j).getTipo_de_Monitoreo() + ", " + listback.get(j).getArea_de_Servicio() + ", "
//					+ listback.get(j).getMapa() + ", " + listback.get(j).getCoordenadas() + ", "
//					+ listback.get(j).getFecha_creacion() + ", " + listback.get(j).getBranch() + ", "
//					+ listback.get(j).getStatus_job() + ", " + listback.get(j).getStatus_Prospecto() + ", "
//					+ listback.get(j).getCuenta_en_Prospecto() + ", " + listback.get(j).getSite() + " ,"
//					+ listback.get(j).getTipo_de_Job() + ", " + listback.get(j).getFecha_compromiso() + ", "
//					+ listback.get(j).getHora_compromiso_inicial() + ", " + listback.get(j).getHora_compromiso_final() + ", "
//					+ listback.get(j).getTipo_panel() + ", " + listback.get(j).getCause() + ", " + listback.get(j).getMes()
//					+ ", " + listback.get(j).getResolution() + ", " + listback.get(j).getAsignado() + ", "
//					+ listback.get(j).getClasificacion() + ", " + listback.get(j).getRegion() + ", " + listback.get(j).getOs_Asignado()
//					+ ", " + listback.get(j).getOutsourcer() + ", " + listback.get(j).getRegion() + ", " + listback.get(j).getDescripción()
//					+ ", " + listback.get(j).getComentario() + ", " + listback.get(j).getTipo_Customer() + ", " + listback.get(j).getTiempo_Instalacion()
//					+ ", " + listback.get(j).getSales_emp_no()+ ", " + listback.get(j).getNombre_vendedor() + ", " + listback.get(j).getZonas()
//					+ ", " + listback.get(j).getResponsable() + ", " + listback.get(j).getStatus() + ", " + listback.get(j).getFecha_onsite()
//					+ ", " + listback.get(j).getHora_onsite() + ", " + listback.get(j).getVendedor() + ", " + listback.get(j).getLider()
//					+ ", " + listback.get(j).getGerente() + ", " + listback.get(j).getNombre_Vendedor() + ", " + listback.get(j).getClarificado()
//					+ ", " + listback.get(j).getNo_Empleado() + ", " + listback.get(j).getNotas_de_Direccion() + ", " + listback.get(j).getPackage()
//					+ ", " + listback.get(j).getTecchnicalType());
//		}

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
				System.out.println(generic.getCuenta_en_Job());
				// Ingresa a base de datos para verificar si existe
				if (rs.getString(1).equals(generic.getCs_no())) {
					System.out.println("si existe");
				}else {
					System.out.println("no existe");
				}
			}
					PreparedStatement stmt = (PreparedStatement) conexionbd.getConnection().prepareStatement(
							"UPDATE ADT_CLIENTESTEST set cuenta=?, nombre=?, calle=?, colonia=?, cp=?, municipio=?, estado=?, telefono=?, tipo_servicio=?, plan=?, fecha_venta=?, fecha_activacion=?, fecha_cancelacion=?, fecha_instalacion=?, fecha_update=?, status=?, desripcion=?, no_bl=?, facturacion=?, revenue_counter=?, service_details=?, no_cliente=? WHERE cuenta='"+generic.getCuenta_en_Job()+"'");
		
//					List<Crearcuenta> listrsnv = new ArrayList<Crearcuenta>();
//					for (Crearcuenta crearcuenta : listrsnv) {
//						
//						System.out.println(crearcuenta.getEjecutivo_TLMK());
//						
//					}
					
					 stmt.setString(1, generic.getCuenta_en_Job());
					 stmt.setString(2, generic.getCliente());
					 stmt.setString(3, generic.getCalle());
					 stmt.setString(4, generic.getColonia());
					 stmt.setInt(5, generic.getCp());
					 stmt.setString(6, generic.getMunicipio());
					 stmt.setString(7, generic.getEstado());
					 stmt.setInt(8, generic.getTelefono());
					 stmt.setString(9, generic.getTipo_de_Monitoreo());
					 stmt.setString(10, generic.getOutsourcer());
					 stmt.setObject(11, convert(generic.getFecha_creacion()));
					 stmt.setObject(12, convert(generic.getFecha_activacion()));
					 stmt.setObject(13, convert(generic.getFecha_cancelacion()));
					 stmt.setObject(14, convert(generic.getBranch()));
					 stmt.setObject(15, new java.sql.Date(date.getTime()));
					 stmt.setString(16, generic.getStatus_Prospecto());
					 stmt.setString(17, generic.getComentario());
					 stmt.setLong(18, generic.getNo_BranLeader());
					 stmt.setDouble(19, 0);
					 stmt.setInt(20, 0);
				 stmt.setString(21, generic.getOutsourcer());
					 stmt.setLong(22, generic.getNo_BranLeader());
					
					stmt.executeUpdate();
					
					 System.out.println("Se actualizaron los datos correctamente");

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
