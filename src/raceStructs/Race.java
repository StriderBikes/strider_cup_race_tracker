package raceStructs;

public class Race {
	Boolean timeOptimized = false;
	Integer ageGroupId;
	Racer[] racerList;
	
	public Race(String loc, Integer ageGroup) {
		this.ageGroupId = ageGroup;
	}
	
	public Boolean is_time_optimized() {
		return this.timeOptimized;
	}
}
