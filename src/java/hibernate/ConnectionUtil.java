package hibernate;

import entity.Course;
import entity.Schedule;
import entity.Student;
import entity.StudentAttendance;
import model.AccountDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import repository.AccountRepository;
import repository.ScheduleRepository;
import repository.StudentAttendanceRepository;
import repository.impl.AccountRepositoryImpl;
import repository.impl.ScheduleRepositoryImpl;
import repository.impl.StudentAttendanceRepositoryImpl;

public class ConnectionUtil {
    
    private static SessionFactory factory = null;
    
    private ConnectionUtil() {
        
    }
    
    public static SessionFactory buildSessionFactory() {
        if (factory == null) {
            Configuration config = new Configuration();
            config.configure("hibernate\\hibernate.cfg.xml");
            
            factory = config.buildSessionFactory();
        }
        return factory;
    }
    
    public static void finish(Session session) {
        if (session != null) {
            session.close();
        }
    }
    
    public static void main(String[] args) {
        
        buildSessionFactory();
        StudentAttendanceRepository studentAttendanceRepository = new StudentAttendanceRepositoryImpl();
        System.out.println(studentAttendanceRepository.getListByScheduleNo(Long.valueOf("1")));
//        AccountRepository accountRepository = new AccountRepositoryImpl();
//        ScheduleRepository scheduleRepository = new ScheduleRepositoryImpl();
//        System.out.println(accountRepository.getByUserNameAndPassWord("sonvhh", "123"));
//        System.out.println(scheduleRepository.getListScheduleByTeacherNo(Long.valueOf("1")));
//        Session session = factory.openSession();
//        session.getTransaction().begin();
//        session.save(Course.builder().courseName("a").build());
//        session.save(entity.Class.builder().className("b").build());
//        session.saveOrUpdate(StudentAttendance.builder().student(Student.builder().studentNo(Long.valueOf(1)).build())
//        .schedule(Schedule.builder().scheduleNo(Long.valueOf(1)).build())
//        .build());
//        session.getTransaction().commit();
    }
    
}
