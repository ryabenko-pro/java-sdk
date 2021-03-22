package com.elarian.model;

public final class GetDigits implements VoiceAction {
    public Say say = null;
    public Play play = null;
    public long timeout;
    public String finishOnKey = "#";
    public int numDigits;

    public GetDigits(Say say, long timeout, String finishOnKey, int numDigits) {
        this.say = say;
        this.timeout = timeout;
        this.finishOnKey = finishOnKey;
        this.numDigits = numDigits;
    }

    public GetDigits(Play play, long timeout, String finishOnKey, int numDigits) {
        this.play = play;
        this.timeout = timeout;
        this.finishOnKey = finishOnKey;
        this.numDigits = numDigits;
    }
}
