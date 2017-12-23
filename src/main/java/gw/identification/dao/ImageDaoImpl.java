package gw.identification.dao;

import gw.identification.model.Image;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ImageDaoImpl implements ImageDao {
    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.openSession();
    }

    @Override
    public boolean save(Image image) {
        try(Session session = getSession();) {
            session.save(image);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}
