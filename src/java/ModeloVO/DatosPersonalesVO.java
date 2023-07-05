/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author User
 */
public class DatosPersonalesVO {
    
    //inicializamos las variable 
    private String datId, usuId, datNombre, datApellido, datTipoId, datNumeroId, datTelefono, datCorreo;

    //constructor recibe los datos y los mantiene de forma segura 

    public DatosPersonalesVO(String datId, String usuId, String datNombre, String datApellido, String datTipoId, String datNumeroId, String datTelefono, String datCorreo) {
        this.datId = datId;
        this.usuId = usuId;
        this.datNombre = datNombre;
        this.datApellido = datApellido;
        this.datTipoId = datTipoId;
        this.datNumeroId = datNumeroId;
        this.datTelefono = datTelefono;
        this.datCorreo = datCorreo;
    }

    public DatosPersonalesVO() {
    }

    public DatosPersonalesVO(String datNombre, String datApellido, String datTipoId, String datNumeroId, String datTelefono, String datCorreo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String getDatId() {
        return datId;
    }

    public void setDatId(String datId) {
        this.datId = datId;
    }

    public String getUsuId() {
        return usuId;
    }

    public void setUsuId(String usuId) {
        this.usuId = usuId;
    }

    public String getDatNombre() {
        return datNombre;
    }

    public void setDatNombre(String datNombre) {
        this.datNombre = datNombre;
    }

    public String getDatApellido() {
        return datApellido;
    }

    public void setDatApellido(String datApellido) {
        this.datApellido = datApellido;
    }

    public String getDatTipoId() {
        return datTipoId;
    }

    public void setDatTipoId(String datTipoId) {
        this.datTipoId = datTipoId;
    }

    public String getDatNumeroId() {
        return datNumeroId;
    }

    public void setDatNumeroId(String datNumeroId) {
        this.datNumeroId = datNumeroId;
    }

    public String getDatTelefono() {
        return datTelefono;
    }

    public void setDatTelefono(String datTelefono) {
        this.datTelefono = datTelefono;
    }

    public String getDatCorreo() {
        return datCorreo;
    }

    public void setDatCorreo(String datCorreo) {
        this.datCorreo = datCorreo;
    }
    
                                                
}
