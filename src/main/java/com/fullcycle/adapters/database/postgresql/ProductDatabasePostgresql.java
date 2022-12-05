package com.fullcycle.adapters.database.postgresql;

import com.fullcycle.application.product.entity.Product;
import com.fullcycle.application.product.entity.ProductInterface;
import com.fullcycle.application.product.persistence.ProductPersistenceInterface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.UUID;

public class ProductDatabasePostgresql implements ProductPersistenceInterface {
  @Override
  public ProductInterface get(UUID id) {
    var emf = Persistence.createEntityManagerFactory("product-db");
    var entityManager = emf.createEntityManager();
    return entityManager.find(Product.class, id);
  }

  @Override
  public ProductInterface save(ProductInterface product) {
    var emf = Persistence.createEntityManagerFactory("product-db");
    var entityManager = emf.createEntityManager();
    var productFind = entityManager.find(Product.class, product.getId());
    if (productFind == null) {
      return create(product, entityManager);
    }
    return update(product, entityManager);
  }

  private ProductInterface create(ProductInterface product, EntityManager entityManager) {
    entityManager.getTransaction().begin();
    entityManager.createQuery("insert into products (id, name, price, status) values (:id, :name, :price, :status)")
      .setParameter("id", product.getId())
      .setParameter("name", product.getName())
      .setParameter("price", product.getPrice())
      .setParameter("status", product.getStatus())
      .executeUpdate();
    entityManager.getTransaction().commit();
    return entityManager.find(Product.class, product.getId());
  }

  private ProductInterface update(ProductInterface product, EntityManager entityManager) {
    entityManager.getTransaction().begin();
    entityManager.createQuery("update products set name = :name, set price = :price, set status = :status where id = :id")
      .setParameter("name", product.getName())
      .setParameter("price", product.getPrice())
      .setParameter("status", product.getStatus())
      .setParameter("id", product.getId())
      .executeUpdate();
    entityManager.getTransaction().commit();
    return entityManager.find(Product.class, product.getId());
  }
}
