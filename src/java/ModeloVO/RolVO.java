/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author SENA
 */
public class RolVO {
    
    private String rolId, rolTipo;

    public RolVO(String rolId, String rolTipo) {
        this.rolId = rolId;
        this.rolTipo = rolTipo;
    }

    public RolVO() {
    }

    public String getRolId() {
        return rolId;
    }

    public void setRolId(String rolId) {
        this.rolId = rolId;
    }

    public String getRolTipo() {
        return rolTipo;
    }

    public void setRolTipo(String rolTipo) {
        this.rolTipo = rolTipo;
    }
    
    
}
