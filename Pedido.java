

/**
 * Modela un pedido realizado por un cliente en una determinada fecha
 * El pedido incluye dos líneas de pedido que describen a cada uno de los dos
 * productos comprados en el pedido
 */
public class Pedido
{
    private final double IVA = 0.21;  // iva a aplicar
    private Fecha fecha;
    private Cliente cliente;
    private LineaPedido linea1;
    private LineaPedido linea2;

    /**
     * Constructor  
     */
    public Pedido(Fecha fecha, Cliente cliente, LineaPedido linea1, LineaPedido linea2)    {
        this.fecha = fecha;
        this.cliente = cliente;
        this.linea1 = linea1;
        this.linea2 = linea2;
    }

    /**
     * accesor para la fecha del pedido
     */
    public Fecha  getFecha() {
      return fecha;   
    }

    /**
     * accesor para el cliente
     */
    public Cliente  getCliente() {
       return cliente;  
    }
    
    
    /**
     * calcular y devolver el importe total del pedido sin Iva
     */
    public double getImporteAntesIva() {
    double precio = linea2.getProducto().getPrecio() * linea2.getCantidad() + linea1.getProducto().getPrecio() * linea1.getCantidad();     
    return precio;
    
    }

    /**
     * calcular y devolver el iva a aplicar
     */
    public double   getIva() {
        double conIva = getImporteAntesIva() * IVA;
        return conIva;
    }

    /**
     * calcular y devolver el importe total del pedido con Iva
     */
    public double  getImporteTotal() {
       return getImporteAntesIva() + getIva();  
    }

    /**
     * Representación textual del pedido
     * (ver enunciado)
     */
    public String toString() {
        String siIva = "IVA:"; 
        String noIva = "IMPORTE SIN IVA:";
        String total ="IMPORTE TOTAL:";
        
        String pedidoCreado = String.format("------------\nFECHA PEDIDO: ")
        + fecha.toString() + "\nDATOS DEL CLIENTE\n" + cliente.toString()
        + String.format("\n\n**** Artículos en el pedido **** \n\n")
        + linea1.toString() + "\n" + linea2.toString()
        + String.format("\n\n*** A pagar *** \n\n")
        + String.format("%20s%8.2f€\n%20s%8.2f€\n%20s%8.2f€\n",
        noIva, getImporteAntesIva(), siIva, getIva(), total, getImporteTotal()); 
        return pedidoCreado;
    }
    
    
    /**
     * devuelve true si el pedido actual es más antiguo que el recibido 
     * como parámetro
     */
    public boolean masAntiguoQue(Pedido otro) {
    Fecha fecha2 = otro.fecha;
    return fecha2.antesQue(fecha);     
    }
    
     /**
     * devuelve una referencia al pedido actual
     */
    public Pedido   getPedidoActual() {
        Pedido pedidoActual = new Pedido(fecha, cliente, linea1, linea2);
        return pedidoActual;   
    }

}
