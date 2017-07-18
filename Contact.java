
/**
 * Creates an object that represents an object
 * @author Lars Beutlich 
 * @version 5/2/2017
 */
public class Contact
{
    private String name; 
    private String relation; 
    private String bday;
    private String phone; 
    private String email; 
    
    public Contact(String name, String relation, String bday, String phone, String email)
    {
        this.name = name; 
        this.relation = relation; 
        this.bday = bday; 
        this.phone = phone;
        this.email = email; 
    }
    
    //Getter methods 
    public String getName()
    {
        return name; 
    }
    
    public String getRelation()
    {
        return relation; 
    }
    
    public String getBday()
    {
        return bday; 
    }
    
    public String getPhone()
    {
        return phone; 
    }
    
    public String getEmail()
    {
        return email;
    }
    
    //toString 
    @Override 
    public String toString()
    {
        return name + "    " + relation + "   " + bday + "   " + phone + "   " + email; 
    }
}
