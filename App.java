package com.ProjectAssignment.Movies2;

import javax.persistence.Cache;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class App 
{
    public static void main( String[] args )
    {
        
    	 ServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
         Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
         SessionFactory factory=meta.getSessionFactoryBuilder().build();
         Session session=factory.openSession();
         Transaction t=session.beginTransaction();
         System.out.println("Session Created");
    	
         MoviesCache mc=new MoviesCache();
         mc.setName("Dinesh Dixit");
         mc.setAge(22);
         mc.setEmail("dixitdinesh52@gmail.com");
         mc.setFavouriteMovie("John Wick");
        
        // session.save(mc);
         System.out.println("Saved Successfully\n");
         
         
         //first level cache=> without @cache and @cacheable
         Session session1=factory.openSession();
         MoviesCache ch1= session1.load(MoviesCache.class,1);
         System.out.println("Name:"+ch1.getAge()+" Age:"+ch1.getAge()+" E-mail:"+ch1.getEmail()+" Favourite movie:"+ch1.getFavouriteMovie());
         session1.close();
         System.out.println("Name:"+ch1.getAge()+" Age:"+ch1.getAge()+" E-mail:"+ch1.getEmail()+" Favourite movie:"+ch1.getFavouriteMovie());
         session1.close();
         
         
         //second level=> cache with @cache and @cacheable...use for multisession data retrieve
         Session session2=factory.openSession();
         MoviesCache ch2= session2.load(MoviesCache.class,1);
         System.out.println("Name:"+ch2.getAge()+" Age:"+ch2.getAge()+" E-mail:"+ch2.getEmail()+" Favourite movie:"+ch2.getFavouriteMovie());
         session2.close();
         
         Session session3=factory.openSession();
         MoviesCache ch3= session3.load(MoviesCache.class,1);
         System.out.println("Name:"+ch3.getAge()+" Age:"+ch3.getAge()+" E-mail:"+ch3.getEmail()+" Favourite movie:"+ch3.getFavouriteMovie());
         session3.close();
         
         t.commit();
         session.close();
      	
         
    }
}
