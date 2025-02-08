package br.com.fiap.postech.customers.gateway.database.jpa.repository.filter.impl;

import br.com.fiap.postech.customers.gateway.database.jpa.entity.CustomerEntity;
import br.com.fiap.postech.customers.gateway.database.jpa.repository.filter.domain.CustomersFilter;
import br.com.fiap.postech.customers.gateway.database.jpa.repository.filter.CustomersRepositoryQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomersRepositoryQuery {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CustomerEntity> filter(CustomersFilter customersFilter) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CustomerEntity> criteria = builder.createQuery(CustomerEntity.class);
        Root<CustomerEntity> root = criteria.from(CustomerEntity.class);

        // Criar Restrições
        Predicate[] predicates = createRestritions(customersFilter, builder, root);
        criteria.where(predicates);

        TypedQuery<CustomerEntity> query = entityManager.createQuery(criteria);
        return query.getResultList();
    }

    private Predicate[] createRestritions(CustomersFilter customersFilter, CriteriaBuilder builder, Root<CustomerEntity> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (customersFilter.getId() != null) {
            predicates.add(builder.equal(root.get("id"), customersFilter.getId().toString() ));
        }

        if (StringUtils.isNotBlank(customersFilter.getName())) {
            predicates.add(builder.like(root.get("name"), "%" + customersFilter.getName() + "%"));
        }

        if (StringUtils.isNotBlank(customersFilter.getEmail())) {
            predicates.add(builder.like(root.get("email"), "%" + customersFilter.getEmail() + "%"));
        }

        if (StringUtils.isNotBlank(customersFilter.getPhone())) {
            predicates.add(builder.like(root.get("phone"), "%" + customersFilter.getPhone() + "%"));
        }

        if (StringUtils.isNotBlank(customersFilter.getCellPhone())) {
            predicates.add(builder.like(root.get("cell_phone"), "%" + customersFilter.getCellPhone() + "%"));
        }

        if (StringUtils.isNotBlank(customersFilter.getZipCode())) {
            predicates.add(builder.like(root.get("zip_code"), "%" + customersFilter.getZipCode() + "%"));
        }

        if (StringUtils.isNotBlank(customersFilter.getNeighborhood())) {
            predicates.add(builder.like(root.get("neighborhood"), "%" + customersFilter.getNeighborhood() + "%"));
        }

        if (StringUtils.isNotBlank(customersFilter.getCity())) {
            predicates.add(builder.like(root.get("city"), "%" + customersFilter.getCity() + "%"));
        }

        if (StringUtils.isNotBlank(customersFilter.getState())) {
            predicates.add(builder.like(root.get("state"), "%" + customersFilter.getState() + "%"));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
