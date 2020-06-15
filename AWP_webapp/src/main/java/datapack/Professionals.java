/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datapack;

/**
 *
 * @author kumar
 */
public class Professionals {
    
    private int id;
    private String name;
    private String username;
    private String password;
    private String profession;
    private String email;
    private String mob_no;
    private String address;
    private String gender;
    private String status;
    private String rating;
    private String salary;
    private String total_services;
    private String register;
    private int service_id;
      
    public void setid(int id)
    {
        this.id=id;
    }
    public int getid()
    {
        return this.id;
    }
    public void setname(String name)
    {
        this.name=name;
    }
    public String getname()
    {
        return this.name;
    }
    public void setusername(String username)
    {
        this.username=username;
    }
    public String getusername()
    {
        return this.username;
    }
     public void setpassword(String password)
    {
        this.password=password;
    }
    public String getpassword()
    {
        return this.password;
    }
     public void setprofession(String profession)
    {
        this.profession=profession;
    }
    public String getprofession()
    {
        return this.profession;
    }
     public void setemail(String email)
     {
        this.email=email;
    }
    public String getemail()
    {
        return this.email;
    }
     public void setmob_no(String mob_no)
    {
        this.mob_no=mob_no;
    }
    public String getmob_no()
    {
        return this.mob_no;
    }
      public void setaddress(String address)
    {
        this.address=address;
    }
    public String getaddress()
    {
        return this.address;
    }
      public void setgender(String gender)
    {
        this.gender=gender;
    }
    public String getgender()
    {
        return this.gender;
    }
      public void setstatus(String status)
    {
        this.status=status;
    }
    public String getstatus()
    {
        return this.status;
    }
      public void setrating(String rating)
    {
        this.rating=rating;
    }
    public String getrating()
    {
        return this.rating;
    }
      public void setsalary(String salary)
    {
        this.salary=salary;
    }
    public String getsalary()
    {
        return this.salary;
    }
      public void settotal_services(String total_services)
    {
        this.total_services=total_services;
    }
    public String gettotal_services()
    {
        return this.total_services;
    }
    public void approve()
    {
        if(this.register.equals("false"))
        {
            this.register="true";
        }
    }
    public String getregister()
    {
        return this.register;
    }
    public void setregister(String register)
    {
        this.register=register;
    }
    public void setservice_id(int id)
    {
        this.service_id=id;
    }
    public int getservice_id()
    {
        return this.service_id;
    }
}
