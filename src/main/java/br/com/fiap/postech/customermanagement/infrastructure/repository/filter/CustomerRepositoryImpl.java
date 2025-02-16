package br.com.fiap.postech.customermanagement.infrastructure.repository.filter;

import br.com.fiap.postech.customermanagement.infrastructure.entity.CustomerEntity;
import br.com.fiap.postech.customermanagement.infrastructure.entity.CustomerEntity_;
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
    public List<CustomerEntity> filter(CustomerFilter customerFilter) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CustomerEntity> criteria = builder.createQuery(CustomerEntity.class);
        Root<CustomerEntity> root = criteria.from(CustomerEntity.class);

        // Criar Restrições
        Predicate[] predicates = createRestritions(customerFilter, builder, root);
        criteria.where(predicates);

        TypedQuery<CustomerEntity> query = entityManager.createQuery(criteria);
        return query.getResultList();
    }

    private Predicate[] createRestritions(CustomerFilter customerFilter, CriteriaBuilder builder, Root<CustomerEntity> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (customerFilter.getId() != null) {
            predicates.add(builder.equal(root.get(CustomerEntity_.id), customerFilter.getId().toString() ));
        }

        if (StringUtils.isNotBlank(customerFilter.getName())) {
            predicates.add(builder.like(root.get(CustomerEntity_.name), "%" + customerFilter.getName() + "%"));
        }

        if (StringUtils.isNotBlank(customerFilter.getEmail())) {
            predicates.add(builder.like(root.get(CustomerEntity_.email), "%" + customerFilter.getEmail() + "%"));
        }

        if (StringUtils.isNotBlank(customerFilter.getPhone())) {
            predicates.add(builder.like(root.get(CustomerEntity_.phone), "%" + customerFilter.getPhone() + "%"));
        }

        if (StringUtils.isNotBlank(customerFilter.getCellPhone())) {
            predicates.add(builder.like(root.get(CustomerEntity_.cellPhone), "%" + customerFilter.getCellPhone() + "%"));
        }

        if (StringUtils.isNotBlank(customerFilter.getZipCode())) {
            predicates.add(builder.like(root.get(CustomerEntity_.zipCode), "%" + customerFilter.getZipCode() + "%"));
        }

        if (StringUtils.isNotBlank(customerFilter.getNeighborhood())) {
            predicates.add(builder.like(root.get(CustomerEntity_.neighborhood), "%" + customerFilter.getNeighborhood() + "%"));
        }

        if (StringUtils.isNotBlank(customerFilter.getCity())) {
            predicates.add(builder.like(root.get(CustomerEntity_.city), "%" + customerFilter.getCity() + "%"));
        }

        if (StringUtils.isNotBlank(customerFilter.getState())) {
            predicates.add(builder.like(root.get(CustomerEntity_.state), "%" + customerFilter.getState() + "%"));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
