package hu.bme.mit.train.system;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.sensor.TrainSensorImpl;
import hu.bme.mit.train.user.TrainUserImpl;

public class TrainSystem {

	private TrainController controller = new TrainControllerImpl();
	private TrainUser user = new TrainUserImpl(controller);
	private TrainSensor sensor = new TrainSensorImpl(controller, user);

	public TrainController getController() {
		return controller;
	}

	public TrainSensor getSensor() {
		return sensor;
	}

	public TrainUser getUser() {
		return user;
	}

	public static void main(String[] args){
		TrainSystem trainSystem = new TrainSystem();

		//Giving input signal
		int position[] = { 1, 0, 1, -1, 0, 1, -1};

		//Setting initial speed limit
		trainSystem.getController().setSpeedLimit(10);

		//Looping forever
		int i = 0;
		while(true){
			try{
				Thread.sleep(700);
				int pos = position[i % 7];
				trainSystem.getUser().overrideJoystickPosition(pos);
				i++;
			}catch(Exception e){
				System.out.println("Hiba az iterációban! Terminálunk!");
				break;
			}

		}
	}

}
