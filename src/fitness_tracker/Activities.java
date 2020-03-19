package fitness_tracker;

public class Activities implements IActivities{
	private double Totalcalories,SwimCalories,RunCalories,BoxCalories,TrainCalories;
	private double TotalHeartRate,SwimHeartRate,RunHeartRate,BoxHeartRate,TrainHeartRate;
	




	public Activities() {
		super();
		Totalcalories = 0;
		SwimCalories = 0;
		RunCalories =0;
		BoxCalories = 0;
		TrainCalories = 0;
		TotalHeartRate = 80;
		SwimHeartRate = 0;
		RunHeartRate = 0;
		BoxHeartRate = 0;
		TrainHeartRate = 0;
	}

	@Override
	public void swim(int time) {
		SwimCalories+=time*4;
		SwimHeartRate+=TotalHeartRate*0.002*time;
		TotalHeartRate+=TotalHeartRate*0.002*time;

	}

	@Override
	public void run(int time) {
		RunCalories+=time*5;
		RunHeartRate+=TotalHeartRate*0.003*time;
		TotalHeartRate+=TotalHeartRate*0.003*time;

				
	}

	@Override
	public void boxing(int time) {
		BoxCalories+=time*3;
		BoxHeartRate+=	TotalHeartRate*0.005*time;
		TotalHeartRate+=TotalHeartRate*0.005*time;


				
	}

	@Override
	public void strenth_training(int time) {
		TrainCalories+=time*5;
		TrainHeartRate+=TotalHeartRate*0.006*time;
		TotalHeartRate+=TotalHeartRate*0.006*time;

				
	}

	public double getTotalcalories() {
		Totalcalories=SwimCalories+BoxCalories+RunCalories+TrainCalories;
		return Totalcalories;
	}

	public double getSwimCalories() {
		return SwimCalories;
	}

	public double getRunCalories() {
		return RunCalories;
	}

	public double getBoxCalories() {
		return BoxCalories;
	}

	public double getTrainCalories() {
		return TrainCalories;
	}

	public double getTotalHeartRate() {
		return TotalHeartRate;
	}

	public double getSwimHeartRate() {
		return SwimHeartRate;
	}

	public double getRunHeartRate() {
		return RunHeartRate;
	}

	public double getBoxHeartRate() {
		return BoxHeartRate;
	}

	public double getTrainHeartRate() {
		return TrainHeartRate;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
