
package mx.desarrollo.persistence.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class HibernateUtil {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY =
            buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory() {
        try {
            String password = System.getenv("AVIEN_DB_PASSWORD");

            if (password == null || password.isBlank()) {
                throw new IllegalStateException(
                        "No se encontró la variable de entorno AVIEN_DB_PASSWORD."
                );
            }

            Map<String, Object> properties = new HashMap<>();
            properties.put("hibernate.connection.password", password);

            return Persistence.createEntityManagerFactory(
                    "persistencePU", properties
            );

        } catch (Throwable ex) {
            System.err.println(
                    "Error creando EntityManagerFactory: " + ex.getMessage()
            );
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return ENTITY_MANAGER_FACTORY;
    }

    public static EntityManager getEntityManager() {
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }

    public static void close() {
        if (ENTITY_MANAGER_FACTORY != null
                && ENTITY_MANAGER_FACTORY.isOpen()) {
            ENTITY_MANAGER_FACTORY.close();
        }
    }
}

