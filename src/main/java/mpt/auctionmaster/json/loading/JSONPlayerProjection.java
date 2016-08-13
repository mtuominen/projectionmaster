package mpt.auctionmaster.json.loading;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JSONPlayerProjection {
    @JsonProperty("g")
    private int gamesPlayed;

    @JsonProperty("cmp")
    private int passingCompletions;
    @JsonProperty("att")
    private int passingAttempts;
    @JsonProperty("pyd")
    private int passingYards;
    @JsonProperty("ptd")
    private int passingTouchdowns;
    @JsonProperty("icp")
    private int passingInterceptions;

    @JsonProperty("rsh")
    private int rushingCarries;
    @JsonProperty("rshyd")
    private int rushingYards;
    @JsonProperty("rshtd")
    private int rushingTouchdowns;

    @JsonProperty("rec")
    private int receptions;
    @JsonProperty("recyd")
    private int receivingYards;
    @JsonProperty("rectd")
    private int receivingTouchdowns;

    @JsonProperty("fum")
    private int fumbles;

    @JsonProperty("fgm")
    private int madeFieldGoals;
    @JsonProperty("fga")
    private int attemptedFieldGoals;
    @JsonProperty("xpm")
    private int madeExtraPoints;
    @JsonProperty("xpa")
    private int attemptedExtraPoints;

    @JsonProperty("krtd")
    private float kickReturnTouchdowns;
    @JsonProperty("prtd")
    private float puntReturnTouchdowns;

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getPassingCompletions() {
        return passingCompletions;
    }

    public void setPassingCompletions(int passingCompletions) {
        this.passingCompletions = passingCompletions;
    }

    public int getPassingAttempts() {
        return passingAttempts;
    }

    public void setPassingAttempts(int passingAttempts) {
        this.passingAttempts = passingAttempts;
    }

    public int getPassingYards() {
        return passingYards;
    }

    public void setPassingYards(int passingYards) {
        this.passingYards = passingYards;
    }

    public int getPassingTouchdowns() {
        return passingTouchdowns;
    }

    public void setPassingTouchdowns(int passingTouchdowns) {
        this.passingTouchdowns = passingTouchdowns;
    }

    public int getPassingInterceptions() {
        return passingInterceptions;
    }

    public void setPassingInterceptions(int passingInterceptions) {
        this.passingInterceptions = passingInterceptions;
    }

    public int getRushingCarries() {
        return rushingCarries;
    }

    public void setRushingCarries(int rushingCarries) {
        this.rushingCarries = rushingCarries;
    }

    public int getRushingYards() {
        return rushingYards;
    }

    public void setRushingYards(int rushingYards) {
        this.rushingYards = rushingYards;
    }

    public int getRushingTouchdowns() {
        return rushingTouchdowns;
    }

    public void setRushingTouchdowns(int rushingTouchdowns) {
        this.rushingTouchdowns = rushingTouchdowns;
    }

    public int getReceptions() {
        return receptions;
    }

    public void setReceptions(int receptions) {
        this.receptions = receptions;
    }

    public int getReceivingYards() {
        return receivingYards;
    }

    public void setReceivingYards(int receivingYards) {
        this.receivingYards = receivingYards;
    }

    public int getReceivingTouchdowns() {
        return receivingTouchdowns;
    }

    public void setReceivingTouchdowns(int receivingTouchdowns) {
        this.receivingTouchdowns = receivingTouchdowns;
    }

    public int getFumbles() {
        return fumbles;
    }

    public void setFumbles(int fumbles) {
        this.fumbles = fumbles;
    }

    public int getMadeFieldGoals() {
        return madeFieldGoals;
    }

    public void setMadeFieldGoals(int madeFieldGoals) {
        this.madeFieldGoals = madeFieldGoals;
    }

    public int getAttemptedFieldGoals() {
        return attemptedFieldGoals;
    }

    public void setAttemptedFieldGoals(int attemptedFieldGoals) {
        this.attemptedFieldGoals = attemptedFieldGoals;
    }

    public int getMadeExtraPoints() {
        return madeExtraPoints;
    }

    public void setMadeExtraPoints(int madeExtraPoints) {
        this.madeExtraPoints = madeExtraPoints;
    }

    public int getAttemptedExtraPoints() {
        return attemptedExtraPoints;
    }

    public void setAttemptedExtraPoints(int attemptedExtraPoints) {
        this.attemptedExtraPoints = attemptedExtraPoints;
    }

    public float getKickReturnTouchdowns() {
        return kickReturnTouchdowns;
    }

    public void setKickReturnTouchdowns(float kickReturnTouchdowns) {
        this.kickReturnTouchdowns = kickReturnTouchdowns;
    }

    public float getPuntReturnTouchdowns() {
        return puntReturnTouchdowns;
    }

    public void setPuntReturnTouchdowns(float puntReturnTouchdowns) {
        this.puntReturnTouchdowns = puntReturnTouchdowns;
    }
}
