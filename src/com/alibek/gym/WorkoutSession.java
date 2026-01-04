package com.alibek.gym;

public class WorkoutSession {
    private String sessionId;
    private String date;
    private int durationMinutes;
    private double caloriesBurned;
    private String intensityLevel;
    private boolean active;
    private GymMember member;
    private GymTrainer trainer;

    public WorkoutSession(String sessionId, String date, int durationMinutes, String intensityLevel){
        setSessionId(sessionId);
        setDate(date);
        setDurationMinutes(durationMinutes);
        setIntensityLevel(intensityLevel);
        this.caloriesBurned = 0.0;
        this.active = false;
        this.member = null;
        this.trainer = null;
    }

    // Getters
    public String getSessionId(){
        return sessionId;
    }
    public String getDate(){
        return date;
    }
    public int getDurationMinutes(){
        return durationMinutes;
    }
    public double getCaloriesBurned(){
        return caloriesBurned;
    }
    public String getIntensityLevel(){
        return intensityLevel;
    }
    public boolean isActive(){
        return active;
    }
    public GymMember getMember(){
        return member;
    }
    public GymTrainer getTrainer(){
        return trainer;
    }

    // Setters
    public void setSessionId(String sessionId){
        if(sessionId != null && !sessionId.trim().isEmpty()){
            this.sessionId = sessionId;
        }else{
            System.out.println("Warning: SessionID cannot be empty!");
        }
    }
    public void setDate(String date){
        if(date != null && !date.trim().isEmpty()){
            this.date = date;
        }else{
            System.out.println("Warning: Date cannot be empty!");
        }
    }
    public void setDurationMinutes(int durationMinutes){
        if(durationMinutes > 0){
            this.durationMinutes = durationMinutes;
        }else{
            System.out.println("Warning: Duration cannot be negative or 0! Setting to 60.");
            this.durationMinutes = 60;
        }
    }
    public void setCaloriesBurned(double caloriesBurned){
        if(caloriesBurned >= 0){
            this.caloriesBurned = caloriesBurned;
        }else{
            System.out.println("Warning: Calories cannot be negative! Setting to 0.");
            this.caloriesBurned = 0;
        }
    }
    public void setIntensityLevel(String intensityLevel){
        if(intensityLevel != null && !intensityLevel.trim().isEmpty()){
            this.intensityLevel = intensityLevel;
        }else{
            System.out.println("Warning: Intensity level cannot be empty!");
        }
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public void setMember(GymMember member){
        this.member = member;
    }
    public void setTrainer(GymTrainer trainer){
        this.trainer = trainer;
    }

    public void startSession(){
        if(this.member == null){
            System.out.println("Cannot start session: no member assigned.");
            return;
        }
        this.active = true;
        System.out.println("Session " + sessionId + " started for member " + member.getName() + ".");
    }

    public void endSession(){
        if(!this.active){
            System.out.println("Session " + sessionId + " is not active.");
            return;
        }else{
            this.active = false;
            calculateCalories();
            System.out.println("Session " + sessionId + " ended. Calories burned: " + this.caloriesBurned);
        }
    }

    public double calculateCalories(){
        double factor;
        switch(this.intensityLevel.toLowerCase()){
            case "high": factor = 12.0; break;
            case "medium": factor = 8.0; break;
            case "low": factor = 5.0; break;
            default: factor = 7.0; break;
        }
        this.caloriesBurned = this.durationMinutes * factor;
        return this.caloriesBurned;
    }

    public String sessionSummary(){
        String trainerName = (trainer == null) ? "None" : trainer.getName();
        String memberName = (member == null) ? "None" : member.getName();
        return "WorkoutSession{" + "sessionId = '" + sessionId + "'" +  ", date = '" + date + "'" +
                ", durationMinutes = " + durationMinutes + ", caloriesBurned = " + caloriesBurned +
                ", intensityLevel = '" + intensityLevel + "'" +  ", active = " + active + ", member = " + memberName +
                ", trainer = " + trainerName + "}";
    }

    @Override
    public String toString(){
        return sessionSummary();
    }
}
