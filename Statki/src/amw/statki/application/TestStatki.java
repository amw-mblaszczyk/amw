package amw.statki.application;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import amw.statki.model.Port;

public class TestStatki {
	
	
	public static SessionFactory getSessionFactory() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
        SessionFactory factory = meta.getSessionFactoryBuilder().build();  
    
    return factory;
	}

	public static void main(String[] args) {
	
    SessionFactory factory = getSessionFactory();  
    Session session = factory.openSession();  
    Transaction t = session.beginTransaction();  
    
     Port p1=new Port();    
        //p1.setId(1);    
        p1.setNazwa("Maersk 1"); 
        p1.setSkrot("M1");
        p1.setFi(54.53);
        p1.setLa(18.23);
     
   session.save(p1);  
   t.commit();  
   
   //Pobranie listy portów
   Criteria criteria = session.createCriteria(Port.class);
   List<Port> porty = criteria.list();
   
   System.out.println("Odczytano "+porty.size()+" portów."); 
   
   //Zamykanie połączeń.
   System.out.println("Closing factory ...");    
    factory.close();  
    System.out.println("Closing session ...");   
    session.close();     

    System.out.println("Application finished.");   
	}

}
