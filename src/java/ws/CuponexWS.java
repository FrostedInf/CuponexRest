/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONException;
import org.json.JSONObject;
import pojos.Empresa;
import pojos.Promocion;
import pojos.Sucursal;
import pojos.Usuario;

/**
 * REST Web Service
 *
 * @author alex
 */
@Path("cuponex")
public class CuponexWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CuponexWS
     */
    public CuponexWS() {
    }
    //Modulo de usuarios
    @Path("/usuario/getByEmail")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario getUsuarioByEmail(@QueryParam("email")String email ) {
        Usuario usuario = null;
        SqlSession conn = MyBatisUtil.getSession();
        if(conn != null){
            try {
                usuario = conn.selectOne("Usuario.getUsuarioByEmail", email);
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                conn.close();
            }
        }
        
        return usuario;
       
    }
    
    @Path("/usuario/create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createUsuario(Usuario usuario) throws JSONException {
         SqlSession conn = MyBatisUtil.getSession();
         JSONObject json = new JSONObject();
         System.out.println(usuario);
        
        try {
            conn.insert("Usuario.createUsuario", usuario );
            System.out.println("record inserted successfully");
            conn.commit();
            json.put("Exito", "True");
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
            json.put("Exito", "False");
        } finally {
            conn.close();
        }
        
        
        return json.toString();
    }

    //modulo de promocion
    @Path("/sucursal/getAllSucursal/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Promocion> getAllPromociones(@PathParam("id") Integer idSucursal) {
        List<Promocion> list = null;
        SqlSession conn = MyBatisUtil.getSession();
        if(conn != null){
            try {
                
                list = conn.selectList("Promocion.getAllEmpresas", idSucursal);
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                conn.close();
            }
        }
        
        return list;
       
    }


    //modulo de Empresa
    @Path("/empresa/getAllEmpresa")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Empresa> getAllEmpresa() {
        List<Empresa> list = null;
        SqlSession conn = MyBatisUtil.getSession();
        if(conn != null){
            try {
                list = conn.selectList("Empresa.getAllEmpresas");
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                conn.close();
            }
        }
        
        return list;
       
    }
    
    
    //modulo de sucursal
    
    @Path("/sucursal/getAllSucursal/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sucursal> getAllSucursal(@PathParam("id") Integer idEmpresa) {
        List<Sucursal> list = null;
        SqlSession conn = MyBatisUtil.getSession();
        if(conn != null){
            try {
                
                list = conn.selectList("Sucursal.getAllEmpresas", idEmpresa);
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                conn.close();
            }
        }
        
        return list;
       
    }
    
}
