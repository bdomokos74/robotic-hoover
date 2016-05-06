package org.bds.resource;

import org.bds.HibernateUtil;
import org.bds.domain.Input;
import org.bds.domain.Output;
import org.bds.entity.Simulation;
import org.bds.service.Simulator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by bdomokos on 04/05/16.
 */
@RestController
@RequestMapping("/api/simulations")

public class SimulationResource {

    @RequestMapping(method = RequestMethod.GET)
    public List<Simulation> getAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        return (List<Simulation>)session.createQuery("from Simulation").list();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public Output simulate(@RequestBody Input input) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Output res = Simulator.simulate(input);

        Simulation sim = new Simulation(input.toString(), res.toString());

        session.save(sim);
        session.getTransaction().commit();
        session.close();
        return res;
    }

}
