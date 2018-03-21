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

import mx.flashservicios.adt.POJO.Activarcuenta;

public class Activación {

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
			new File(archivo[2]));
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
		List<Activarcuenta> listraab = new ArrayList<Activarcuenta>();
		// for (int i = 0; i < Hoja; i++) {
		// System.out.println("Hoja #: " + i + " Nombre: " + libro.getSheetName(i));

		Activarcuenta generic = new Activarcuenta();
		XSSFSheet fila = libro.getSheetAt(1);

		for (Row row : fila) {
			for (int vc = 0; vc < row.getLastCellNum(); vc++) {
				for (Cell c : row) {
// 	

					switch (c.getColumnIndex()) {
					case 0:
//						branch_site
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							generic.setBranch((long) c.getNumericCellValue());
							break;
						}

					case 1:
//						no_vendedor
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							generic.setNo_vendedor((long) c.getNumericCellValue());
							break;
						}

					case 2:
//						vendedor
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
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
					case 3:
//						commmercial_rep_ID
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
								String date = sdf.format(c.getDateCellValue());
								generic.setCommmercial_rep_ID(date);
							} else {
								generic.setCommmercial_rep_ID(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setCommmercial_rep_ID(c.getStringCellValue());
							break;
						}

					case 4:
//						cust_no
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							generic.setCust_no((long) c.getNumericCellValue());
							break;
						}

					case 5:
//						status_cust
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
								String date = sdf.format(c.getDateCellValue());
								generic.setStatus_cust(date);
							} else {
								generic.setStatus_cust(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setStatus_cust(c.getStringCellValue());
							break;
						}

					case 6:
//						status_site
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
								String date = sdf.format(c.getDateCellValue());
								generic.setStatus_site(date);
							} else {
								generic.setStatus_site(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setStatus_site(c.getStringCellValue());
							break;
						}

					case 7:
//						site_no	tipo_site
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
								String date = sdf.format(c.getDateCellValue());
								generic.setSite_no(date);
							} else {
								generic.setSite_no(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setSite_no(String.valueOf(c.getStringCellValue()));
							break;
						}
						
					case 8:
//						estado_site
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
								String date = sdf.format(c.getDateCellValue());
								generic.setTipo_site(date);
							} else {
								generic.setTipo_site(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setTipo_site(c.getStringCellValue());
							break;
						}
						
					case 9:
//						estado_site
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
								String date = sdf.format(c.getDateCellValue());
								generic.setEstado_site(date);
							} else {
								generic.setEstado_site(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setEstado_site(c.getStringCellValue());
							break;
						}
//						

					case 10:
//						CS_NO
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setCs_no(date);
							} else {
								generic.setCs_no(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setCs_no(c.getStringCellValue());
							break;
						}

					case 11:
//						status_job
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setStatus_Job(date);
							} else {
								generic.setStatus_Job(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setStatus_Job(c.getStringCellValue());
							break;
						}

					case 12:
//						fecha_creacion
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
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

					case 13:
//						fecha_activacion
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setFecha_activacion(date);
							} else {
								generic.setFecha_activacion(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setFecha_activacion(c.getStringCellValue());
							break;
						}

					case 14:
//						estado_customer
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
								String date = sdf.format(c.getDateCellValue());
								generic.setEstado_customer(date);
							} else {
								generic.setEstado_customer(String.valueOf(c.getNumericCellValue()));
							}
							break;
						case Cell.CELL_TYPE_STRING:
							generic.setEstado_customer(c.getStringCellValue());
							break;
						}
						
					case 15:
//						no_instalador
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							generic.setNo_instalador((long) c.getNumericCellValue());
							break;
						}
						
					case 16:
//						compañia_instalo
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
								String date = sdf.format(c.getDateCellValue());
								generic.setCompañia_instalo(date);
							} else {
								generic.setCompañia_instalo(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setCompañia_instalo(c.getStringCellValue());
							break;
						}
						
					case 17:
//						tipo_customer
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
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
						
					case 18:
//						ENTRY_CHANNELID
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
								String date = sdf.format(c.getDateCellValue());
								generic.setENTRY_CHANNELID(date);
							} else {
								generic.setENTRY_CHANNELID(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setENTRY_CHANNELID(c.getStringCellValue());
							break;
						}
					case 19:
//						formapago
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
								String date = sdf.format(c.getDateCellValue());
								generic.setForma_de_Pago(date);
							} else {
								generic.setForma_de_Pago(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setForma_de_Pago(c.getStringCellValue());
							break;
						}

					case 20:
//						PROSPECTID
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							generic.setPROSPECTID((long) c.getNumericCellValue());
							break;
						}
						break;

					case 21:
//						systype_id
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
								String date = sdf.format(c.getDateCellValue());
								generic.setSystype_id(date);
							} else {
								generic.setSystype_id(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setSystype_id(c.getStringCellValue());
							break;
						}
						break;

					case 22:
//						Nom_vendedor
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
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

					case 23:
//						# Brand leader
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							generic.setNo_BranLeader((long) c.getNumericCellValue());
							break;
						}

					case 24:
//						Lider
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd yyyy-MM-dd hh:mm:ss:ss");
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

					case 25:
//						Localidad
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd yyyy-MM-dd hh:mm:ss:ss");
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
						break;

					case 26:
//						Gerente
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd yyyy-MM-dd hh:mm:ss:ss");
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
						
					case 27:
//						consolidadoaliado
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
								String date = sdf.format(c.getDateCellValue());
								generic.setConsolidadoaliado(date);
							} else {
								generic.setConsolidadoaliado(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setConsolidadoaliado(c.getStringCellValue());
							break;
						}
						break;

					case 28:
//						canal
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
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
						break;

					case 29:
//						oficina
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
								String date = sdf.format(c.getDateCellValue());
								generic.setOficina(date);
							} else {
								generic.setOficina(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setOficina(c.getStringCellValue());
							break;
						}
						break;

					case 30:
//						zona
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
								String date = sdf.format(c.getDateCellValue());
								generic.setZona(date);
							} else {
								generic.setZona(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setZona(c.getStringCellValue());
							break;
						}
						break;
						

					case 31:
//							mes
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
								String date = sdf.format(c.getDateCellValue());
								generic.setMes(date);
							} else {
								generic.setMes(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setMes(c.getStringCellValue());
							break;
						}
						break;
						

					case 32:
//						periodo_sem
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
								String date = sdf.format(c.getDateCellValue());
								generic.setPeriodo_sem(date);
							} else {
								generic.setPeriodo_sem(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setPeriodo_sem(c.getStringCellValue());
							break;
						}
						break;
						

					case 33:
//						nombre_customer
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
								String date = sdf.format(c.getDateCellValue());
								generic.setNombre_customer(date);
							} else {
								generic.setNombre_customer(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setNombre_customer(c.getStringCellValue());
							break;
						}
						break;

					case 34:
//						nombre_sup
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
								String date = sdf.format(c.getDateCellValue());
								generic.setNombre_sup(date);
							} else {
								generic.setNombre_sup(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setNombre_sup(c.getStringCellValue());
							break;
						}
						break;

					case 35:
//						user_creo_SIV
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
								String date = sdf.format(c.getDateCellValue());
								generic.setUser_creo_SIV(date);
							} else {
								generic.setUser_creo_SIV(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setUser_creo_SIV(c.getStringCellValue());
							break;
						}
						break;
						

					case 36:
//						codeword
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
								String date = sdf.format(c.getDateCellValue());
								generic.setCodeword(date);
							} else {
								generic.setCodeword(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setCodeword(c.getStringCellValue());
							break;
						}
						break;

					case 37:
//						agency
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
								String date = sdf.format(c.getDateCellValue());
								generic.setAgency(date);
							} else {
								generic.setAgency(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setAgency(c.getStringCellValue());
							break;
						}
						break;

					case 38:
//						cs_no_old_cust
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
								String date = sdf.format(c.getDateCellValue());
								generic.setCs_no_old_cust(date);
							} else {
								generic.setCs_no_old_cust(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setCs_no_old_cust(c.getStringCellValue());
							break;
						}
						break;

					case 39:
//						cs#GPRS
						switch (c.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(c)) {
								SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
								String date = sdf.format(c.getDateCellValue());
								generic.setGPRS(date);
							} else {
								generic.setGPRS(String.valueOf(c.getNumericCellValue()));
							}
							break;

						case Cell.CELL_TYPE_STRING:
							generic.setGPRS(c.getStringCellValue());
							break;
						}
						break;
					}
				}
			}
			// }
			listraab.add(generic);
		}
		
//		for (int j = 0; j < listraab.size(); j++) {
//			System.out.println("Lista: " + " " + listraab.get(j).getBranch() + ", "
//					+ listraab.get(j).getNo_vendedor() + ", " + listraab.get(j).getNom_vendedor() + " ,"
//					+ listraab.get(j).getCommmercial_rep_ID() + ", " + listraab.get(j).getCust_no() + " "
//					+ listraab.get(j).getStatus_cust() + " ," + listraab.get(j).getStatus_site() + ", "
//					+ listraab.get(j).getSite_no()+ ", " + listraab.get(j).getTipo_site() + ", " + listraab.get(j).getEstado_site() + ", "
//					+ listraab.get(j).getNo_de_Cuenta() + ", " + listraab.get(j).getStatus_Job() + ", "
//					+ listraab.get(j).getFecha_creacion() + ", " + listraab.get(j).getFecha_activacion() + ", "
//					+ listraab.get(j).getEstado_customer() + ", " + listraab.get(j).getNo_instalador() + ", "
//					+ listraab.get(j).getCompañia_instalo() + ", " + listraab.get(j).getTipo_Customer() + ", "
//					+ listraab.get(j).getENTRY_CHANNELID() + ", " + listraab.get(j).getForma_de_Pago() + ", "
//					+ listraab.get(j).getPROSPECTID() + ", " + listraab.get(j).getSystype_id() + ", "
//					+ listraab.get(j).getNom_vendedor() + ", " + listraab.get(j).getNo_BranLeader() + " ,"
//					+ listraab.get(j).getLider() + ", " + listraab.get(j).getLocalidad() + ", "
//					+ listraab.get(j).getGerente() + ", " + listraab.get(j).getConsolidadoaliado() + ", "
//					+ listraab.get(j).getCanal()+ ", " + listraab.get(j).getOficina() + ", " + listraab.get(j).getZona() + ", " + listraab.get(j).getMes()
//					+ ", " + listraab.get(j).getPeriodo_sem() + ", " + listraab.get(j).getNombre_customer() + ", "
//					+ listraab.get(j).getNombre_sup() + ", " + listraab.get(j).getUser_creo_SIV()+ ", " + listraab.get(j).getCodeword()
//					+ ", " + listraab.get(j).getAgency()+ ", " + listraab.get(j).getCs_no_old_cust()+ ", " + listraab.get(j).getGPRS());
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
				System.out.println(generic.getNo_de_Cuenta());
				// Ingresa a base de datos para verificar si existe
				if (rs.getString(1).equals(generic.getCs_no())) {
					System.out.println("si existe");
				}else {
					System.out.println("no existe");
				}
			}
					PreparedStatement stmt = (PreparedStatement) conexionbd.getConnection().prepareStatement(
							"UPDATE ADT_CLIENTESTEST set cuenta=?, nombre=?, calle=?, colonia=?, cp=?, municipio=?, estado=?, telefono=?, tipo_servicio=?, plan=?, fecha_venta=?, fecha_activacion=?, fecha_cancelacion=?, fecha_instalacion=?, fecha_update=?, status=?, desripcion=?, no_bl=?, facturacion=?, revenue_counter=?, service_details=?, no_cliente=? WHERE cuenta='"+generic.getCs_no()+"'");
				
//					List<Crearcuenta> listrsnv = new ArrayList<Crearcuenta>();
//					for (Crearcuenta crearcuenta : listrsnv) {
//						
//						System.out.println(crearcuenta.getEjecutivo_TLMK());
//						
//					}
					
					 stmt.setString(1, generic.getCs_no());
					 stmt.setString(2, generic.getNombre_customer());
					 stmt.setString(3, "n/a");
					 stmt.setString(4, "n/a");
					 stmt.setInt(5, 0);
					 stmt.setString(6, "n/a");
					 stmt.setString(7, "n/a");
					 stmt.setInt(8, 0);
					 stmt.setString(9, generic.getTipo_Customer());
					 stmt.setString(10, generic.getENTRY_CHANNELID());
					 stmt.setObject(11, convert(generic.getFecha_creacion()));
					 stmt.setObject(12, convert(generic.getFecha_activacion()));
					 stmt.setObject(13, convert(generic.getFecha_cancelacion()));
					 stmt.setObject(14, convert(generic.getFecha_instalacion()));
					 stmt.setObject(15, new java.sql.Date(date.getTime()));
					 stmt.setString(16, generic.getStatus_cust());
					 stmt.setString(17, generic.getCommmercial_rep_ID());
					 stmt.setLong(18, generic.getNo_BranLeader());
					 stmt.setDouble(19, 0);
					 stmt.setInt(20, 0);
				 stmt.setString(21, generic.getENTRY_CHANNELID());
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
