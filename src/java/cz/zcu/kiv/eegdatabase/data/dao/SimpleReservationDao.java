package cz.zcu.kiv.eegdatabase.data.dao;

import cz.zcu.kiv.eegdatabase.data.pojo.Reservation;

import java.util.Date;
import java.util.List;

/**
 * Implementation of DAO for accessing Reservation entities. This class will use
 * only one specific couple of classes, so it doesn't need to be generic.
 *
 * @author Jan Kolena
 */
public class SimpleReservationDao
        extends SimpleGenericDao<Reservation, Integer>
        implements ReservationDao {

    public SimpleReservationDao() {
        super(Reservation.class);
    }

    public List<Reservation> getReservationsBetween(Date start, Date end) {
        /*String hqlQuery = "from ResearchGroup researchGroup "
            + "left join fetch researchGroup.researchGroupMemberships as membership "
            + "where membership.person.personId = :personId "
            + "order by researchGroup.title";
    return getHibernateTemplate().findByNamedParam(hqlQuery, "personId", person.getPersonId());*/
        return null;
    }

}