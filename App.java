
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

		Vehicle vehicle = new Vehicle();

		vehicle.setVehicleName("Car");

		FourWheeler truck = new FourWheeler();
		truck.setVehicleName("Mercedes");
		truck.setSteeringWheel("Mercedes Steering Wheel");

		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Yamaha");
		bike.setSteeringHandle("Yamaha Steering Handle");

		SessionFactory factory = (SessionFactory) new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(TwoWheeler.class).addAnnotatedClass(FourWheeler.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			session.save(bike);
			session.save(vehicle);
			session.save(truck);
			
			session.getTransaction().commit();

		} catch (Exception e) {

			System.out.println(e);
		} finally {
			session.close();
		}

	}

}
