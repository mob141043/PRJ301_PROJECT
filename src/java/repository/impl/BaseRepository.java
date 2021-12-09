/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.impl;

import hibernate.ConnectionUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author ADMIN
 */
public abstract class BaseRepository {

    protected SessionFactory sessionFactory = ConnectionUtil.buildSessionFactory();
    protected Session session;
    protected Transaction transaction;
}
