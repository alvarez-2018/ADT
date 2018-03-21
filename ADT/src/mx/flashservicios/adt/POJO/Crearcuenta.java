package mx.flashservicios.adt.POJO;

//import java.sql.Date;

public class Crearcuenta {

	// no_cliente

	private String Ejecutivo_TLMK;
	private String Tipo_de_ingreso;
	private String Fecha_Vta;
	private String Horaing;
	private String Canal;
	private String Localidad;
	private String Líder_Comercial;
	private String No_Asesor;
	private String Asesor;
	private long No_BranLeader;
	private String Cliente;
	private long Núm_SIV;
	private long Núm_BM;
	private String No_de_Cuenta;
	private long No_Customer;
	private long Customer;
	private String Tipo_de_cuenta;
	private String Promoción;
	private String Fecha_de_Envió_a_DD;
	private String Horavta;
	private String Status_SIV;
	private String Motivos;
	private int NO_BL;
	private String Nombre;
	private String calle;
	private String colonia;
	private int cp;
	private String municipio;
	private String estado;
	private int telefono;
	private String fecha_activacion;
	private String fecha_cancelacion;
	private String fecha_instalacion;
	private String fecha_update;
	private Double facturacion;
	private int revenue_counter;	
	private String tipo_servicio;	

	public long getNo_Customer() {
		return No_Customer;
	}

	public void setNo_Customer(long no_Customer) {
		No_Customer = no_Customer;
	}

	public long getCustomer() {
		return Customer;
	}

	public void setCustomer(long customer) {
		Customer = customer;
	}

	public long getNo_BranLeader() {		
		return No_BranLeader;
	}

	public void setNo_BranLeader(long no_BranLeader) {		
		No_BranLeader = no_BranLeader;
	}

	public String getNo_Asesor() {
		return No_Asesor;
	}

	public void setNo_Asesor(String no_Asesor) {
		No_Asesor = no_Asesor;
	}

	public String getTipo_servicio() {
		return tipo_servicio;
	}

	public void setTipo_servicio(String tipo_servicio) {
		this.tipo_servicio = tipo_servicio;
	}

	public Double getFacturacion() {
		return facturacion;
	}

	public void setFacturacion(Double facturacion) {
		this.facturacion = facturacion;
	}

	public int getRevenue_counter() {
		return revenue_counter;
	}

	public void setRevenue_counter(int revenue_counter) {
		this.revenue_counter = revenue_counter;
	}

	public String getService_details() {
		return service_details;
	}

	public void setService_details(String service_details) {
		this.service_details = service_details;
	}

	private String service_details;

	public String getFecha_activacion() {
		setFecha_activacion("1990-01-01 00:00:00");
		return fecha_activacion;
	}

	public void setFecha_activacion(String fecha_activacion) {
		this.fecha_activacion = fecha_activacion;
	}

	public String getFecha_cancelacion() {
		setFecha_cancelacion("1990-01-01 00:00:00");
		return fecha_cancelacion;
	}

	public void setFecha_cancelacion(String fecha_cancelacion) {
		this.fecha_cancelacion = fecha_cancelacion;
	}

	public String getFecha_instalacion() {
		setFecha_instalacion("1990-01-01 00:00:00");
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

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
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

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getNO_BL() {
		return NO_BL;
	}

	public void setNO_BL(int nO_BL) {
		NO_BL = nO_BL;
	}

	public String getEjecutivo_TLMK() {
		return Ejecutivo_TLMK;
	}

	public void setEjecutivo_TLMK(String ejecutivo_TLMK) {
		Ejecutivo_TLMK = ejecutivo_TLMK;
	}

	public String getTipo_de_ingreso() {
		return Tipo_de_ingreso;
	}

	public void setTipo_de_ingreso(String tipo_de_ingreso) {
		Tipo_de_ingreso = tipo_de_ingreso;
	}

	public String getFecha_Vta() {
		return Fecha_Vta;
	}

	public void setFecha_Vta(String date) {
		Fecha_Vta = date;
	}

	public String getHoraing() {
		return Horaing;
	}

	public void setHoraing(String horaing) {
		Horaing = horaing;
	}

	public String getCanal() {
		return Canal;
	}

	public void setCanal(String canal) {
		Canal = canal;
	}

	public String getLocalidad() {
		return Localidad;
	}

	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}

	public String getLíder_Comercial() {
		return Líder_Comercial;
	}

	public void setLíder_Comercial(String líder_Comercial) {
		Líder_Comercial = líder_Comercial;
	}

	public String getAsesor() {
		return Asesor;
	}

	public void setAsesor(String asesor) {
		Asesor = asesor;
	}

	public String getCliente() {
		return Cliente;
	}

	public void setCliente(String cliente) {
		Cliente = cliente;
	}

	public long getNúm_SIV() {
		return Núm_SIV;
	}

	public void setNúm_SIV(long núm_SIV) {
		Núm_SIV = núm_SIV;
	}

	public long getNúm_BM() {
		return Núm_BM;
	}

	public void setNúm_BM(long núm_BM) {
		Núm_BM = núm_BM;
	}

	public String getNo_de_Cuenta() {
		if (No_de_Cuenta.length() < 11) {
			setNo_de_Cuenta(No_de_Cuenta + "-0");
		}else {
			setNo_de_Cuenta(No_de_Cuenta);
		}
		return No_de_Cuenta;
	}

	public void setNo_de_Cuenta(String no_de_Cuenta) {
			No_de_Cuenta = no_de_Cuenta;
		
	}

	public String getTipo_de_cuenta() {		
		return Tipo_de_cuenta;
	}

	public void setTipo_de_cuenta(String tipo_de_cuenta) {
		Tipo_de_cuenta = tipo_de_cuenta;
	}

	public String getPromoción() {
		if (Promoción.isEmpty()) {
			setPromoción("ADT PLAN");
		}else {
			setPromoción(Promoción);
		}
		
		return Promoción;
	}

	public void setPromoción(String promoción) {
		Promoción = promoción;
	}

	public String getFecha_de_Envió_a_DD() {
		return Fecha_de_Envió_a_DD;
	}

	public void setFecha_de_Envió_a_DD(String fecha_de_Envió_a_DD) {
		Fecha_de_Envió_a_DD = fecha_de_Envió_a_DD;
	}

	public String getHoravta() {
		return Horavta;
	}

	public void setHoravta(String horavta) {
		Horavta = horavta;
	}

	public String getStatus_SIV() {
		if (Status_SIV.contains("APROBADO") || Status_SIV.contains("") || Status_SIV.contains("aprobado")) {
			setStatus_SIV("SOLICITUD INGRESADA");
		} else {
			setStatus_SIV("SOLICITUD RECHAZADA");
		}
		return Status_SIV;
	}

	public void setStatus_SIV(String status_SIV) {
		Status_SIV = status_SIV;
	}

	public String getMotivos() {
		if (Motivos.isEmpty()) {
			setMotivos("SOLICITUD INGRESADA");
		} else {
			setMotivos("SOLICITUD EN PROCESO");
		}
		return Motivos;
	}

	public void setMotivos(String motivos) {
		Motivos = motivos;
	}
}
