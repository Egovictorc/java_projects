package com.victor;

public class StoreData {
    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Employee e1 = new Employee();
        e1.setId(1);
        e1.setFirstName("uche");
        e1.setLastName("Okafor");

        session.save(e1);
        t.commit();
        System.out.println("successfully saved");
        factory.close();
        session.close();
    }
}
