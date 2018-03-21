package mx.flashservicios.adt.lista;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ListaAprobacion {
	
	private String cuenta;
	private String nombre;
	private String calle;
	private String colonia;
	private int cp;
	private String municipio;
	private String estado;
	private Long telefono;
	private String tipo_servicio;
	private String plan;
	private String fecha_venta;
	private String fecha_activacion;
	private String fecha_cancelacion;
	private String fecha_instalacion;
	private String fecha_update;
	private String status;
	private String desripcion;
	private Long no_bl;
	private int facturacion;
	private Double revenue_counter;				
	private String service_details;
	private long no_cliente;
	private String Tipo_de_cuenta;
	private long No_Customer;
	
	private void listapadre(String cuenta, String nombre, String calle, String colonia, int cp, String municipio, String estado, Long telefono, String tipo_servicio, String plan, String fecha_venta, String fecha_activacion, String fecha_cancelacion, String fecha_instalacion, String fecha_update, String status, String desripcion, Long no_bl, int facturacion, double revenue_counter, String service_details, long no_cliente, String Tipo_de_cuenta, long No_Customer) {
		
		
		
	}
	
	public long getNo_Customer() {
		return No_Customer;
	}

	public void setNo_Customer(long no_Customer) {
		No_Customer = no_Customer;
	}
	
	public String getTipo_de_cuenta() {		
		return Tipo_de_cuenta;
	}

	public void setTipo_de_cuenta(String tipo_de_cuenta) {
		Tipo_de_cuenta = tipo_de_cuenta;
	}
	
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Long getTelefono() {
		return telefono;
	}
	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}
	public String getTipo_servicio() {
		return tipo_servicio;
	}
	public void setTipo_servicio(String tipo_servicio) {
		this.tipo_servicio = tipo_servicio;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getFecha_venta() {
		return fecha_venta;
	}
	public void setFecha_venta(String fecha_venta) {
		this.fecha_venta = fecha_venta;
	}
	public String getFecha_activacion() {
		return fecha_activacion;
	}
	public void setFecha_activacion(String fecha_activacion) {
		this.fecha_activacion = fecha_activacion;
	}
	public String getFecha_cancelacion() {
		return fecha_cancelacion;
	}
	public void setFecha_cancelacion(String fecha_cancelacion) {
		this.fecha_cancelacion = fecha_cancelacion;
	}
	public String getFecha_instalacion() {
		return fecha_instalacion;
	}
	public void setFecha_instalacion(String fecha_instalacion) {
		this.fecha_instalacion = fecha_instalacion;
	}
	public String getFecha_update() {
		return fecha_update;
	}
	public void setFecha_update(String fecha_update) {
		this.fecha_update = fecha_update;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDesripcion() {
		return desripcion;
	}
	public void setDesripcion(String desripcion) {
		this.desripcion = desripcion;
	}
	public Long getNo_bl() {
		return no_bl;
	}
	public void setNo_bl(Long no_bl) {
		this.no_bl = no_bl;
	}
	public int getFacturacion() {
		return facturacion;
	}
	public void setFacturacion(int facturacion) {
		this.facturacion = facturacion;
	}
	public Double getRevenue_counter() {
		return revenue_counter;
	}
	public void setRevenue_counter(Double revenue_counter) {
		this.revenue_counter = revenue_counter;
	}

	public String getService_details() {
		return service_details;
	}
	public void setService_details(String service_details) {
		this.service_details = service_details;
	}
	public long getNo_cliente() {
		return no_cliente;
	}
	public void setNo_cliente(long no_cliente) {
		this.no_cliente = no_cliente;
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
