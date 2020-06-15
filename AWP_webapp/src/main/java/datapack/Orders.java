/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datapack;

/**
 *
 * @author Dell
 */
public class Orders {
    private int professional_id;
    private int service_id;
    private int user_id;
    
    public int getProfessional_id() {
        return professional_id;
    }

    public void setProfessional_id(int professional_id) {
        this.professional_id = professional_id;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int user_id) {
        this.service_id = user_id;
    }
    
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
