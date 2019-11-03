package com.conichi.technicaltest.dao;

import com.conichi.technicaltest.model.CurrencyResponse;
import com.conichi.technicaltest.model.EnumCurrency;
import com.conichi.technicaltest.model.entity.Currency;
import com.conichi.technicaltest.service.Service;
import com.conichi.technicaltest.utility.Reactive;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;


@Repository
public class Dao {

    private SessionFactory sessionFactory;
    private Service service;

    @Autowired
    public Dao(SessionFactory sessionFactory, Service service) {
        this.sessionFactory = sessionFactory;
        this.service = service;
    }

    public void fillTableWithData() {
        Function<EnumCurrency, CurrencyResponse> getRates = service::getConvertedCurrency;
        Reactive.getInstance().doSilently(getRates.andThen(this::convert).andThen(this::save));
    }

    public Currency convert(CurrencyResponse response) {
        try {
            Currency currency = new Currency();
            currency.setTimeZone(ZoneId.systemDefault());
            currency.setLocalDateTime(LocalDateTime.now());
            currency.setResult(response.getResult());
            currency.setCurrency(response.getEnumCurrency());
            return currency;
        } catch (Exception ignore) {
            return null;
        }
    }

    public void update(Currency currency) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(currency);
        transaction.commit();
        session.close();
    }

    public void delete(Currency currency) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(currency);
        transaction.commit();
        session.close();
    }

    public Currency getById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Currency currency1 = session.get(Currency.class, id);
        transaction.commit();
        session.close();
        return currency1;
    }

    public List<Currency> getAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Currency> list = session.createQuery("FROM Currency").list();
        transaction.commit();
        session.close();
        return list;
    }

    public Long save(Currency currency) {
        if (Objects.nonNull(currency)) {
            Session session = sessionFactory.openSession();
            session.getTransaction().begin();
            Long id = (Long) session.save(currency);
            session.flush();
            session.getTransaction().commit();
            session.close();
            return id;
        } else return 0L;
    }


}
